package kr.or.ddit.servlet;

import java.io.File;
import java.io.IOException;
import java.io.Reader;
import java.sql.Clob;
import java.sql.SQLException;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import kr.or.ddit.dbConnection.model.User;
import kr.or.ddit.dbConnection.service.AttService;
import kr.or.ddit.dbConnection.service.IAttService;
import kr.or.ddit.dbConnection.service.IPostService;
import kr.or.ddit.dbConnection.service.PostService;
import kr.or.ddit.util.FileuploadUtil;

@WebServlet("/postForm")
@MultipartConfig(maxFileSize = 1024 * 1024 * 5, maxRequestSize = 1024 * 1024 * 5 * 5)
public class PostForm extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private IPostService postService = new PostService();
	private IAttService attService = new AttService();

	private static final Logger logger = LoggerFactory.getLogger(PostForm.class);

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		User user = (User) request.getSession().getAttribute("user");
		
		String board_id = request.getParameter("board_id");
		String __post_id = request.getParameter("post_id");
		
		// 글 수정일 경우
		if (__post_id != null && !__post_id.equals("")) {
			try {
				int post_id = Integer.parseInt(__post_id);
				Map post = postService.selectDetail(post_id);				
				List<Map> attList = attService.selectAllOfPost(post_id);
				request.setAttribute("attList", attList);
				
				request.setAttribute("title", post.get("POST_TITLE"));
				Clob clob = (Clob) post.get("POST_CONT");
				String content = "";
				try {
					Reader rd = clob.getCharacterStream();
					char[] c = new char[512];
					int len = 0;
					while ( (len=rd.read(c)) != -1) {
						content += String.valueOf(c);
						logger.debug("c: {}", String.valueOf(c));
					}
				} catch (SQLException e) {
					e.printStackTrace();
				}
				request.setAttribute("content", content);
			} catch (NumberFormatException e) {
				response.sendRedirect(request.getContextPath() + "/board?board_id=" + board_id + "&page=1");
				return;
			}
		}
		
		if (user == null) {
			response.sendRedirect(request.getContextPath() + "/board?board_id=" + board_id + "&page=1");
			return;
		}
		
		request.getRequestDispatcher("/board/postForm.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		User user = (User) request.getSession().getAttribute("user");
		
		String board_id = request.getParameter("board_id");
		
		if (user == null) {
			response.sendRedirect(request.getContextPath() + "/board?board+id=" + board_id + "&page=1");
			return;
		}
		String userId = user.getUserId();
		
		String title = request.getParameter("title");
		String content = request.getParameter("smarteditor");
		
		Map map = new HashMap<String, Object>();
		
		map.put("board_id", board_id);
		map.put("post_title", title);
		map.put("post_cont", content);
		
		map.put("userId", userId);
		
		String __post_id = request.getParameter("post_id");
		Integer post_id;
		
		String __post_parent = request.getParameter("post_parent");
		
		int attSize = 0;
		
		if (__post_id == null || "".equals(__post_id)) {
			// 답글일 경우
			if (__post_parent != null && !__post_parent.equals("")) {
				try {
					int post_parent = Integer.parseInt(__post_parent);
					Map parentPost = postService.selectDetail(post_parent);
					map.put("post_parent", post_parent);
					map.put("gn", parentPost.get("GN"));
				} catch (NumberFormatException e) {
				}
			}
			
			// 새 글 쓰기일 경우(답글 포함)
			postService.insert(map);
			post_id = (Integer) map.get("post_id");
		} else { // 글 수정일 경우
			try {
				post_id = Integer.parseInt(__post_id);
			} catch (NumberFormatException e) {
				response.sendRedirect(request.getContextPath() + "/board?board+id=" + board_id + "&page=1");
				return;
			}
			Map post = new HashMap<String, Object>();
			post.put("post_id", post_id);
			post.put("post_title", title);
			post.put("post_cont", content);
			postService.update(post);
			
			List attList = attService.selectAllOfPost(post_id);
			attSize = attList.size();
		}
		
		String[] delItems = request.getParameter("delItems").split(",");
		try {
			for (String item : delItems) {
				int att_id = Integer.parseInt(item);
				List<Map> __attList = attService.selectAllOfPost(post_id);
				Map att = null;
				for (Map __att : __attList) {
					if (att_id == Integer.valueOf(String.valueOf(__att.get("ATT_ID")))) {
						att = __att;
					}
				}
				File delFile = new File("e:\\upload\\" + att.get("ATT_PATH"));
				logger.debug("{}", "e:\\upload\\" + att.get("ATT_PATH"));
				delFile.delete();
				attService.delete(att_id);
			}
		} catch (NumberFormatException e) {
			logger.debug("error");
		}
		
		Collection<Part> parts = request.getParts();
		int fileNumber = 0;
		for (Part part : parts) {
			if (fileNumber >= 5 - attSize) break;
			String contentDisposition = part.getHeader("Content-Disposition");
			if (!FileuploadUtil.isFile(contentDisposition)) continue;
			
			String fileName = FileuploadUtil.getFilename(contentDisposition);
			if ("".equals(fileName)) continue;
			
			String extension = FileuploadUtil.getFileExtension(contentDisposition);
			
			String root = FileuploadUtil.getPath();
			String path = UUID.randomUUID().toString() + extension;
			path = path.replaceAll("\\\\", "/");
			
			part.write(root + path);
			fileNumber++;
			Map attMap = new HashMap<String, Object>();
			attMap.put("post_id", post_id);
			attMap.put("att_path", path);
			attMap.put("att_name", fileName);
			
			attService.insert(attMap);
		}
		
		response.sendRedirect(request.getContextPath() + "/post?post_id=" + post_id);
	}

}

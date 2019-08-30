package kr.or.ddit.servlet;

import java.io.IOException;
import java.io.Reader;
import java.sql.Clob;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import kr.or.ddit.dbConnection.model.User;
import kr.or.ddit.dbConnection.service.AttService;
import kr.or.ddit.dbConnection.service.CommentService;
import kr.or.ddit.dbConnection.service.IAttService;
import kr.or.ddit.dbConnection.service.ICommentService;
import kr.or.ddit.dbConnection.service.IPostService;
import kr.or.ddit.dbConnection.service.PostService;

@WebServlet("/post")
public class Post extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final Logger logger = LoggerFactory.getLogger(Post.class);
	
	IPostService postService = new PostService();
	ICommentService cmtService = new CommentService();
	IAttService attService = new AttService();
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String __post_id = request.getParameter("post_id");
		
		if (__post_id == null || __post_id.equals("")) {
			response.sendRedirect(request.getContextPath() + "/");
			return;
		}
		
		int post_id;
		try {
			post_id = Integer.parseInt(__post_id);
		} catch (NumberFormatException e) {
			response.sendRedirect(request.getContextPath() + "/");
			return;
		}
		
		Map post = postService.selectDetail(post_id);
		
		if ("Y".equals(post.get("POST_DEL"))) {
			response.sendRedirect(request.getContextPath() + "/");
			return;
		}
		List<Map> cmtList = cmtService.selectAllOfPost(post_id);
		List<Map> attList = attService.selectAllOfPost(post_id);
		
		Clob clob = (Clob) post.get("POST_CONT");
		String content = "";
		try {
			Reader rd = clob.getCharacterStream();
			char[] c = new char[512];
			int len = 0;
			while ( (len=rd.read(c)) != -1) {
				content += String.valueOf(c);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		request.setAttribute("post", post);
		request.setAttribute("cmtList", cmtList);
		request.setAttribute("attList", attList);
		request.setAttribute("content", content);
		request.getRequestDispatcher("/board/postDetail.jsp").forward(request, response);
	}
	
//	@Override
//	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		request.setCharacterEncoding("UTF-8");
//		User user = (User) request.getSession().getAttribute("user");
//		
//		if (user != null) {
//			String cmtCont = request.getParameter("commentContent");
//			Map cmt = new HashMap<String, Object>();
//			cmt.put("cmt_cont", cmtCont);
//			try {
//				cmt.put("post_id", Integer.parseInt(request.getParameter("post_id")));
//			} catch (NumberFormatException e) {
//				doGet(request, response);
//				return;
//			}
//			cmt.put("userId", user.getUserId());
//			
//			cmtService.insert(cmt);
//		}
//		
//		logger.debug("post_id: {}", request.getParameter("post_id"));
//		
//		doGet(request, response);
//	}
}

package kr.or.ddit.servlet;

import java.io.IOException;
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
import kr.or.ddit.dbConnection.service.CommentService;
import kr.or.ddit.dbConnection.service.ICommentService;

@WebServlet("/comment")
public class Cmt extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final Logger logger = LoggerFactory.getLogger(Cmt.class);
	private ICommentService cmtService = new CommentService();
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		User user = (User) request.getSession().getAttribute("user");
		
		String __cmt_id = request.getParameter("cmt_id");
		String __post_id = request.getParameter("post_id");
		
		if (user == null) {
			response.sendRedirect(request.getContextPath() + "/post?post_id=" + __post_id);
			return;
		}
		
		try {
			int cmt_id = Integer.parseInt(__cmt_id);
			int post_id;
			
			try {
				post_id = Integer.parseInt(__post_id);
			} catch (NumberFormatException e) {
				response.sendRedirect(request.getContextPath() + "/post?post_id=" + __post_id);
				return;
			}
			
			// 남의 것 삭제 못하게 하기
			List<Map> list = cmtService.selectAllOfPost(post_id);
			Map cmt = null;
			for (Map map : list) {
				String uid = (String) map.get("USERID");
				String cmtId = String.valueOf(map.get("CMT_ID"));
				
				if (__cmt_id.equals(cmtId) && user.getUserId().equals(uid)) {
					cmt = map;
				}
			}
			
			if (cmt != null) cmtService.deleteByUpdate(cmt_id);
		} catch (NumberFormatException e) {
			response.sendRedirect(request.getContextPath() + "/post?post_id=" + __post_id);
			return;
		}
		
		response.sendRedirect(request.getContextPath() + "/post?post_id=" + __post_id);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		String __post_id = request.getParameter("post_id");
		User user = (User) request.getSession().getAttribute("user");
		
		if (user != null) {
			String cmtCont = request.getParameter("commentContent");
			Map cmt = new HashMap<String, Object>();
			cmt.put("cmt_cont", cmtCont);
			try {
				cmt.put("post_id", Integer.parseInt(request.getParameter("post_id")));
			} catch (NumberFormatException e) {
				response.sendRedirect(request.getContextPath() + "/post?post_id=" + __post_id);
				return;
			}
			cmt.put("userId", user.getUserId());
			
			cmtService.insert(cmt);
		}
		
		response.sendRedirect(request.getContextPath() + "/post?post_id=" + __post_id);
	}
}

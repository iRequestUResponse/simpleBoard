package kr.or.ddit.servlet;

import java.io.IOException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import kr.or.ddit.dbConnection.model.User;
import kr.or.ddit.dbConnection.service.IPostService;
import kr.or.ddit.dbConnection.service.PostService;

@WebServlet("/postDelete")
public class PostDelete extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private static final Logger logger = LoggerFactory.getLogger(PostDelete.class);
	
	private IPostService postService = new PostService();
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String __post_id = request.getParameter("post_id");
		User user = (User) request.getSession().getAttribute("user");
		
		if (user == null) {
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
		String userId = (String) post.get("USERID");
		
		if (userId == null || !userId.equals(user.getUserId())) {
			response.sendRedirect(request.getContextPath() + "/");
			return;
		}
		
		Object board_id = post.get("BOARD_ID");
		logger.debug("board_id {} {}", board_id instanceof Integer, board_id instanceof String);
		
		postService.deleteByUpdate(post_id);
		
		response.sendRedirect(request.getContextPath() + "/board?board_id=" + board_id + "&page=1");
	}
}

package kr.or.ddit.servlet;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.dbConnection.service.AttService;
import kr.or.ddit.dbConnection.service.CommentService;
import kr.or.ddit.dbConnection.service.IAttService;
import kr.or.ddit.dbConnection.service.ICommentService;
import kr.or.ddit.dbConnection.service.IPostService;
import kr.or.ddit.dbConnection.service.PostService;

@WebServlet("/post")
public class Post extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
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
		List<Map> cmtList = cmtService.selectAllOfPost(post_id);
		List<Map> attList = attService.selectAllOfPost(post_id);
		
		request.setAttribute("post", post);
		request.setAttribute("cmtList", cmtList);
		request.setAttribute("attList", attList);
		request.getRequestDispatcher("/board/postDetail.jsp").forward(request, response);
	}
}

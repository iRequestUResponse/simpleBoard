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

import kr.or.ddit.dbConnection.service.BoardService;
import kr.or.ddit.dbConnection.service.IBoardService;
import kr.or.ddit.dbConnection.service.IPostService;
import kr.or.ddit.dbConnection.service.PostService;

@WebServlet("/board")
public class Board extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private IPostService postService = new PostService();
	private IBoardService boardService = new BoardService();
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/*
		----
		board_id,
		page
		pageSize
		
		----
		pageLength
		*/
		
		
		String __board_id = request.getParameter("board_id");
		String __page = request.getParameter("page");
		String __pageSize = request.getParameter("pageSize");
		
		if (__board_id == null || __board_id.equals("") || __page == null || __page.equals("")) {
			response.sendRedirect(request.getContextPath() + "/");
			return;
		}
		if (__pageSize == null || __pageSize.equals("")) __pageSize = "10";
		
		int board_id = Integer.parseInt(__board_id);
		int page = Integer.parseInt(__page);
		int pageSize = Integer.parseInt(__pageSize);
		int pageLength = (postService.selectCnt(board_id) + pageSize - 1) / pageSize;
		
		Map detail = boardService.selectDetail(board_id);
		
		if (detail.get("BOARD_USE").equals("N")) {
			response.sendRedirect(request.getContextPath() + "/");
			return;
		}
		
		Map map = new HashMap<String, Integer>();
		map.put("page", page);
		map.put("pageSize", pageSize);
		map.put("board_id", board_id);
		List postList = postService.selectAll(map);
		
		request.setAttribute("postList", postList);
		request.setAttribute("page", page);
		request.setAttribute("pageSize", pageSize);
		request.setAttribute("pageLength", pageLength);
		
		request.setAttribute("title", detail.get("BOARD_NAME"));
		
		request.getRequestDispatcher("/board/board.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}

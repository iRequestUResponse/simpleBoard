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
import javax.servlet.http.HttpSession;

import kr.or.ddit.dbConnection.model.User;
import kr.or.ddit.dbConnection.service.BoardService;
import kr.or.ddit.dbConnection.service.IBoardService;

@WebServlet("/boardManagement")
public class BoardManagement extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private IBoardService boardService = new BoardService();
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List list = boardService.selectAll();
		
		request.setAttribute("boardList", list);
		request.getRequestDispatcher("/board/boardManagement.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("user");
		
		if (user == null) {
			doGet(request, response);
			return;
		}
		
		String type = request.getParameter("type");
		String board_id = request.getParameter("board_id");
		String board_name = request.getParameter("board_name");
		String board_use = request.getParameter("board_use");
		
		Map map = new HashMap<String, Object>();
		map.put("board_name", board_name);
		map.put("board_use", board_use);
		
		if ("create".equals(type)) {
			map.put("userId", user.getUserId());
			boardService.insert(map);
		} else if (user.getUserId().equals(request.getParameter("userId"))) {
			map.put("board_id", Integer.parseInt(board_id));
			boardService.update(map);
		}
		doGet(request, response);
	}

}

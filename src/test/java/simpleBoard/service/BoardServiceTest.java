package simpleBoard.service;

import static org.junit.Assert.assertEquals;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import kr.or.ddit.dbConnection.service.BoardService;
import kr.or.ddit.dbConnection.service.IBoardService;
import kr.or.ddit.util.MybatisUtil;

public class BoardServiceTest {
	private SqlSession sqlSession;
	private IBoardService service = new BoardService();
	
	@Before
	public void setup() {
	}
	
	@After
	public void teardown() {
	}
	
	@Test
	public void selectAllTest() {
		/***Given***/
		List list = service.selectAll();

		/***When***/

		/***Then***/
		assertEquals(2, list.size());
	}
	
	@Test
	public void selectDetail() {
		/***Given***/
		Map board = service.selectDetail(1);
		String board_id = String.valueOf(board.get("BOARD_ID"));
		String board_name = (String) board.get("BOARD_NAME");
		String board_use = (String) board.get("BOARD_USE");
		String userId = (String) board.get("USERID");
		Date __board_time = (Date) board.get("BOARD_TIME");
		String board_time = new SimpleDateFormat("yyyy-MM-dd").format(__board_time);

		/***When***/

		/***Then***/
		assertEquals("1", board_id);
		assertEquals("자유게시판 - brown", board_name);
		assertEquals("Y", board_use);
		assertEquals("brown", userId);
		assertEquals("2019-08-29", board_time);
	}

	@Test
	public void insertTest() {
		/***Given***/
		Map map = new HashMap<String, Object>();
		String board_name = "test board";
		String board_use = "N";
		String userId = "brown"; 
		map.put("board_name", board_name);
		map.put("board_use", board_use);
		map.put("userId", userId);

		/***When***/
		int cnt = service.insert(map);

		/***Then***/
		assertEquals(1, cnt);
	}
	
	@Test
	public void updateTest() {
		/***Given***/
		Map map = new HashMap<String, Object>();
		int board_id = 7;
		String board_name = "test board";
		String board_use = "N";
		String userId = "brown"; 
		map.put("board_id", board_id);
		map.put("board_name", board_name);
		map.put("board_use", board_use);
		map.put("userId", userId);

		/***When***/
		int cnt = service.update(map);

		/***Then***/
		assertEquals(1, cnt);
	}	
}

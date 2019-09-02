package simpleBoard.service;

import static org.junit.Assert.assertEquals;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import kr.or.ddit.dbConnection.service.CommentService;
import kr.or.ddit.dbConnection.service.ICommentService;
import kr.or.ddit.util.MybatisUtil;

public class CommentServiceTest {
	private ICommentService service = new CommentService();
	
	@Before
	public void setup() {
	}

	@After
	public void teardown() {
	}
	
	@Test
	public void selectAllOfPostTest() {
		/***Given***/
		List list = service.selectAllOfPost(1);

		/***When***/

		/***Then***/
		assertEquals(12, list.size());
	}
	
	@Test
	public void insertTest() {
		/***Given***/
		Map map = new HashMap();
		map.put("cmt_cont", "테스트 덧글");
		map.put("post_id", 1);
		map.put("userId", "cony");

		/***When***/
		int cnt = service.insert(map);

		/***Then***/
		assertEquals(1, cnt);
	}

	@Test
	public void deleteByUpdateTest() {
		/***Given***/

		/***When***/
		int cnt = service.deleteByUpdate(3);

		/***Then***/
		assertEquals(1, cnt);
	}
}

package simpleBoard.service;

import static org.junit.Assert.assertEquals;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import kr.or.ddit.dbConnection.service.IPostService;
import kr.or.ddit.dbConnection.service.PostService;
import kr.or.ddit.util.MybatisUtil;

public class PostServiceTest {
	private IPostService service = new PostService();
	
	@Before
	public void setup() {
	}
	
	@After
	public void teardown() {
	}

	@Test
	public void selectAllTest() {
		/***Given***/
		Map page = new HashMap();
		page.put("page", 1);
		page.put("pageSize", 10);
		page.put("board_id", 1);
		List list = service.selectAll(page);

		/***When***/

		/***Then***/
		assertEquals(10, list.size());
	}
	
	@Test
	public void selectCntTest() {
		/***Given***/
		int cnt = service.selectCnt(1);

		/***When***/

		/***Then***/
		assertEquals(15, cnt);
	}
	
	@Test
	public void selectDetailTest() {
		/***Given***/
		Map post = service.selectDetail(5);
		String post_title = (String) post.get("POST_TITLE");
		
		/***When***/

		/***Then***/
		assertEquals("첨부파일 테스트", post_title);
	}
	
	@Test
	public void insertTest() {
		/***Given***/
		Map post = new HashMap();
		post.put("post_title", "daoTest");
		post.put("post_cont", "daoTest content");
		post.put("board_id", 1);
		post.put("userId", "brown");

		/***When***/
		int cnt = service.insert(post);

		/***Then***/
		assertEquals(cnt, 1);
	}
	
	@Test
	public void updateTest() {
		/***Given***/
		Map map = new HashMap();
		map.put("post_id", 5);
		map.put("post_title", "title changed");
		map.put("post_cont", "");

		/***When***/
		int cnt = service.update(map);

		/***Then***/
		assertEquals(1, cnt);		
	}

	@Test
	public void deleteByUpdateTest() {
		/***Given***/

		/***When***/
		int cnt = service.deleteByUpdate(5);

		/***Then***/
		assertEquals(1, cnt);
	}
}

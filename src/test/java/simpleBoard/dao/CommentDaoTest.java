package simpleBoard.dao;

import static org.junit.Assert.assertEquals;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import kr.or.ddit.dbConnection.repository.CommentDao;
import kr.or.ddit.dbConnection.repository.ICommentDao;
import kr.or.ddit.util.MybatisUtil;

public class CommentDaoTest {
	private SqlSession sqlSession;
	private ICommentDao dao = new CommentDao();
	
	@Before
	public void setup() {
		sqlSession = MybatisUtil.getSession();
	}

	@After
	public void teardown() {
		sqlSession.rollback();
		sqlSession.close();
	}
	
	@Test
	public void selectAllOfPostTest() {
		/***Given***/
		List list = dao.selectAllOfPost(sqlSession, 1);

		/***When***/

		/***Then***/
		assertEquals(10, list.size());
	}
	
	@Test
	public void insertTest() {
		/***Given***/
		Map map = new HashMap();
		map.put("cmt_cont", "테스트 덧글");
		map.put("post_id", 1);
		map.put("userId", "cony");

		/***When***/
		int cnt = dao.insert(sqlSession, map);

		/***Then***/
		assertEquals(1, cnt);
	}

	@Test
	public void deleteByUpdateTest() {
		/***Given***/

		/***When***/
		int cnt = dao.deleteByUpdate(sqlSession, 3);

		/***Then***/
		assertEquals(1, cnt);
	}
}

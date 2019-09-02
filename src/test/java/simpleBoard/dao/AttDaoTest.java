package simpleBoard.dao;

import static org.junit.Assert.assertEquals;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import kr.or.ddit.dbConnection.repository.AttDao;
import kr.or.ddit.dbConnection.repository.IAttDao;
import kr.or.ddit.util.MybatisUtil;

public class AttDaoTest {
	private SqlSession sqlSession;
	private IAttDao dao = new AttDao();
	
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
		List<Map> list = dao.selectAllOfPost(sqlSession, 5);
		List<Map> list2 = dao.selectAllOfPost(sqlSession, 6);

		/***When***/

		/***Then***/
		assertEquals(2, list.size());
		assertEquals(3, list2.size());
	}

	@Test
	public void insertTest() {
		/***Given***/
		Map map = new HashMap();
		map.put("att_id", 9999);
		map.put("att_name", "test");
		map.put("att_path", "testPath");
		map.put("post_id", 1);

		/***When***/
		int cnt = dao.insert(sqlSession, map);

		/***Then***/
		assertEquals(1, cnt);
	}
	
	@Test
	public void deleteTest() {
		/***Given***/
		

		/***When***/
		int cnt = dao.delete(sqlSession, 4);
		int cnt2 = dao.delete(sqlSession, 43);

		/***Then***/
		assertEquals(1, cnt);
		assertEquals(0, cnt2);
	}
}

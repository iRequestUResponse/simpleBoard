package simpleBoard;

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
	private IAttDao attDao = new AttDao();
	
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
		List<Map> list = attDao.selectAllOfPost(sqlSession, 0);

		/***When***/

		/***Then***/
		assertEquals(0, list.size());
	}
	
	@Test
	public void insertTest() {
		/***Given***/
		Map att = new HashMap<String, Object>();
		

		/***When***/

		/***Then***/
	}
	
	@Test
	public void deleteTest() {
		/***Given***/
		

		/***When***/

		/***Then***/
	}

}

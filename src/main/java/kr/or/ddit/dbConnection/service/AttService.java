package kr.or.ddit.dbConnection.service;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import kr.or.ddit.dbConnection.repository.AttDao;
import kr.or.ddit.dbConnection.repository.IAttDao;
import kr.or.ddit.util.MybatisUtil;

public class AttService implements IAttService {
	private IAttDao dao = new AttDao();

	@Override
	public List<Map> selectAllOfPost(int post_id) {
		SqlSession sqlSession = MybatisUtil.getSession();
		List<Map> list = dao.selectAllOfPost(sqlSession, post_id);
		sqlSession.close();
		return list;
	}

	@Override
	public int insert(Map map) {
		SqlSession sqlSession = MybatisUtil.getSession();
		int cnt = dao.insert(sqlSession, map);
		sqlSession.commit();
		sqlSession.close();
		return cnt;
	}

	@Override
	public int delete(int att_id) {
		SqlSession sqlSession = MybatisUtil.getSession();
		int cnt = dao.delete(sqlSession, att_id);
		sqlSession.commit();
		sqlSession.close();
		return cnt;
	}

}

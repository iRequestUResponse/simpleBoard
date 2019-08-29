package kr.or.ddit.dbConnection.service;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import kr.or.ddit.dbConnection.repository.BoardDao;
import kr.or.ddit.dbConnection.repository.IBoardDao;
import kr.or.ddit.util.MybatisUtil;

public class BoardService implements IBoardService {
	private IBoardDao dao = new BoardDao(); 

	@Override
	public List<Map> selectAll() {
		SqlSession sqlSession = MybatisUtil.getSession();
		List<Map> list = dao.selectAll(sqlSession);
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
	public int update(Map map) {
		SqlSession sqlSession = MybatisUtil.getSession();
		int cnt = dao.update(sqlSession, map);
		sqlSession.commit();
		sqlSession.close();
		return cnt;
	}

}

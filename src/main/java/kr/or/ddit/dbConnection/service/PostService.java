package kr.or.ddit.dbConnection.service;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import kr.or.ddit.dbConnection.repository.IPostDao;
import kr.or.ddit.dbConnection.repository.PostDao;
import kr.or.ddit.util.MybatisUtil;

public class PostService implements IPostService {
	private IPostDao dao = new PostDao();

	@Override
	public List<Map> selectAll(Map map) {
		SqlSession sqlSession = MybatisUtil.getSession();
		List<Map> list = dao.selectAll(sqlSession, map);
		sqlSession.close();
		return list;
	}
	
	@Override
	public int selectCnt(int board_id) {
		SqlSession sqlSession = MybatisUtil.getSession();
		int cnt = dao.selectCnt(sqlSession, board_id);
		sqlSession.close();
		return cnt;
	}

	@Override
	public Map selectDetail(int post_id) {
		SqlSession sqlSession = MybatisUtil.getSession();
		Map one = dao.selectDetail(sqlSession, post_id);
		sqlSession.close();
		return one;
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

	@Override
	public int deleteByUpdate(int post_id) {
		SqlSession sqlSession = MybatisUtil.getSession();
		int cnt = dao.deleteByUpdate(sqlSession, post_id);
		sqlSession.commit();
		sqlSession.close();
		return cnt;
	}

}

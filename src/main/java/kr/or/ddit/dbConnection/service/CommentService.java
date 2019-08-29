package kr.or.ddit.dbConnection.service;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import kr.or.ddit.dbConnection.repository.CommentDao;
import kr.or.ddit.dbConnection.repository.ICommentDao;
import kr.or.ddit.util.MybatisUtil;

public class CommentService implements ICommentService {
	private ICommentDao dao = new CommentDao();
	
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
	public int deleteByUpdate(int cmt_id) {
		SqlSession sqlSession = MybatisUtil.getSession();
		int cnt = dao.deleteByUpdate(sqlSession, cmt_id);
		sqlSession.commit();
		sqlSession.close();
		return cnt;
	}

}

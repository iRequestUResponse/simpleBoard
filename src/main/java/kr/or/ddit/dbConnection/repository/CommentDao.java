package kr.or.ddit.dbConnection.repository;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

public class CommentDao implements ICommentDao {

	@Override
	public List<Map> selectAllOfPost(SqlSession sqlSession, int post_id) {
		return sqlSession.selectList("comment.selectAllOfPost", post_id);
	}

	@Override
	public int insert(SqlSession sqlSession, Map map) {
		return sqlSession.insert("comment.insert", map);
	}

	@Override
	public int deleteByUpdate(SqlSession sqlSession, int cmt_id) {
		return sqlSession.update("comment.deleteByUpdate", cmt_id);
	}

}

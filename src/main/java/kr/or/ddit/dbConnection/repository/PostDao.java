package kr.or.ddit.dbConnection.repository;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

public class PostDao implements IPostDao {

	@Override
	public List<Map> selectAll(SqlSession sqlSession, Map map) {
		return sqlSession.selectList("post.selectAll", map);
	}
	
	@Override
	public int selectCnt(SqlSession sqlSession, int board_id) {
		return sqlSession.selectOne("post.selectCnt", board_id);
	}

	@Override
	public Map selectDetail(SqlSession sqlSession, int post_id) {
		return sqlSession.selectOne("post.selectDetail", post_id);
	}

	@Override
	public int insert(SqlSession sqlSession, Map map) {
		return sqlSession.insert("post.insert", map);
	}

	@Override
	public int update(SqlSession sqlSession, Map map) {
		return sqlSession.update("post.update", map);
	}

	@Override
	public int deleteByUpdate(SqlSession sqlSession, int post_id) {
		return sqlSession.update("post.deleteByUpdate", post_id);
	}

}

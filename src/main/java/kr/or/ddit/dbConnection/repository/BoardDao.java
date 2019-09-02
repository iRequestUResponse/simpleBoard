package kr.or.ddit.dbConnection.repository;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

public class BoardDao implements IBoardDao {

	@Override
	public List<Map> selectAll(SqlSession sqlSession) {
		return sqlSession.selectList("board.selectAll");
	}
	
	@Override
	public List<Map> selectAllUsed(SqlSession sqlSession) {
		return sqlSession.selectList("board.selectAllUsed");
	}
	
	@Override
	public Map selectDetail(SqlSession sqlSession, int board_id) {
		return sqlSession.selectOne("board.selectDetail", board_id);
	}

	@Override
	public int insert(SqlSession sqlSession, Map map) {
		return sqlSession.insert("board.insert", map);
	}

	@Override
	public int update(SqlSession sqlSession, Map map) {
		return sqlSession.update("board.update", map);
	}

}

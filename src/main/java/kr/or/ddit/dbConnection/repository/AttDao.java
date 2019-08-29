package kr.or.ddit.dbConnection.repository;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

public class AttDao implements IAttDao {

	@Override
	public List<Map> selectAllOfPost(SqlSession sqlSession, int post_id) {
		return sqlSession.selectList("att.selectAllOfPost", post_id);
	}

	@Override
	public int insert(SqlSession sqlSession, Map map) {
		return sqlSession.insert("att.insert", map);
	}

	@Override
	public int delete(SqlSession sqlSession, int att_id) {
		return sqlSession.delete("att.delete", att_id);
	}

}

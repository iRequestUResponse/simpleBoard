package kr.or.ddit.dbConnection.repository;

import org.apache.ibatis.session.SqlSession;

import kr.or.ddit.dbConnection.model.User;

public class UserDao implements IUserDao {
	/**
	* Method : getUser
	* 작성자 : PC-17
	* 변경이력 :
	* @param userId
	* @return
	* Method 설명 :userId를 갖는 사용자 정보 조회
	*/
	@Override
	public User getUser(SqlSession sqlSession, String userId) {
		return sqlSession.selectOne("user.getUser", userId);
	}
}

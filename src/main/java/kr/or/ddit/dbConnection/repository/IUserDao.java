package kr.or.ddit.dbConnection.repository;

import org.apache.ibatis.session.SqlSession;

import kr.or.ddit.dbConnection.model.User;

public interface IUserDao {
	/**
	* Method : getUser
	* 작성자 : PC-17
	* 변경이력 :
	 * @param sqlSession 
	* @param userId
	* @return
	* Method 설명 : 사용자 상세 조회
	*/
	User getUser(SqlSession sqlSession, String userId);
}

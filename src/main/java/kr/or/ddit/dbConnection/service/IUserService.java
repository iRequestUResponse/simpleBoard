package kr.or.ddit.dbConnection.service;

import kr.or.ddit.dbConnection.model.User;

public interface IUserService {
	/**
	* Method : getUser
	* 작성자 : PC-17
	* 변경이력 :
	* @param userId
	* @return
	* Method 설명 : 사용자 상세 조회
	*/
	User getUser(String userId);
}

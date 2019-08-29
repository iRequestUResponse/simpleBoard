package kr.or.ddit.dbConnection.service;

import java.util.List;
import java.util.Map;

public interface ICommentService {
	/**
	* Method : selectAllOfPost
	* 작성자 : PC-17
	* 변경이력 :
	* @param post_id
	* @return (cmt_id, cmt_cont, cmt_time, post_id, userId, cmt_del)
	* Method 설명 : 게시글의 덧글 모두 가져오기
	*/
	List<Map> selectAllOfPost(int post_id);
	
	/**
	* Method : insert
	* 작성자 : PC-17
	* 변경이력 :
	* @param map (cmt_id, cmt_cont, cmt_time, post_id, userId, cmt_del)
	* @return cmt_id
	* Method 설명 : 덧글 추가
	*/
	int insert(Map map);
	

	/**
	* Method : updateToDelete
	* 작성자 : PC-17
	* 변경이력 :
	* @param cmt_id
	* @return success?
	* Method 설명 : 덧글 삭제
	*/
	int deleteByUpdate(int cmt_id);
}

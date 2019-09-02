package kr.or.ddit.dbConnection.service;

import java.util.List;
import java.util.Map;

public interface IPostService {
	/**
	* Method : selectAll
	* 작성자 : PC-17
	* 변경이력 :
	* @param map (page, pageSize)
	* @return (post_id, board_id, post_title, post_cont, userId, post_time, post_parent, post_del)
	* Method 설명 : 모든 게시글을 가져온다
	*/
	List<Map> selectAll(Map map);
	
	/**
	* Method : selectCnt
	* 작성자 : PC-17
	* 변경이력 :
	* @return cnt
	* Method 설명 : 해당 게시판의 모든 게시글의 수를 가져온다 
	*/
	int selectCnt(int board_id);
	
	/**
	* Method : selectDetail
	* 작성자 : PC-17
	* 변경이력 :
	* @param post_id
	* @return (post_id, board_id, post_title, post_cont, userId, post_time, post_parent, post_del)
	* Method 설명 : 게시글 상세를 가져온다
	*/
	Map selectDetail(int post_id);
	
	/**
	* Method : insert
	* 작성자 : PC-17
	* 변경이력 :
	* @param map (board_id, post_title, post_cont, userId, post_parent?, gn?)
	* @return post_id
	* Method 설명 : 게시글을 추가한다
	*/
	int insert(Map map);
	
	/**
	* Method : update
	* 작성자 : PC-17
	* 변경이력 :
	* @param map (post_title, post_cont, post_id)
	* @return success?
	* Method 설명 :게시글을 수정한다
	*/
	int update(Map map);
	
	/**
	* Method : updateTodelete
	* 작성자 : PC-17
	* 변경이력 :
	* @param post_id
	* @return success?
	* Method 설명 : 게시글을 삭제한다
	*/
	int deleteByUpdate(int post_id);
}

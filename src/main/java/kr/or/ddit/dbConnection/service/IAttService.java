package kr.or.ddit.dbConnection.service;

import java.util.List;
import java.util.Map;

public interface IAttService {
	/**
	* Method : selectAllOfPost
	* 작성자 : PC-17
	* 변경이력 :
	* @param post_id
	* @return (att_id, att_name, att_path, post_id)
	* Method 설명 : 게시글의 첨부파일 목록을 얻어옴
	*/
	List<Map> selectAllOfPost(int post_id);
	
	/**
	* Method : insert
	* 작성자 : PC-17
	* 변경이력 :
	* @param map (att_name, att_path, post_id)
	* @return att_id
	* Method 설명 : 게시글에 첨부파일 추가
	*/
	int insert(Map map);
	
	/**
	* Method : delete
	* 작성자 : PC-17
	* 변경이력 :
	* @param att_id
	* @return success?
	* Method 설명 : 게시글의 첨부파일 제거
	*/
	int delete(int att_id);
}
package kr.or.ddit.dbConnection.service;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

public interface IBoardService {
	/**
	* Method : selectAll
	* 작성자 : PC-17
	* 변경이력 :
	* @return (board_id, board_name, board_use, userId, board_time)
	* Method 설명 : 모든 게시판 목록 가져오기
	*/
	List<Map> selectAll();
	
	/**
	* Method : selectBoard
	* 작성자 : PC-17
	* 변경이력 :
	* @param sqlSession
	* @param board_id
	* @return (board_id, board_name, board_use, userId, board_time)
	* Method 설명 : 게시판 상세 가져오기
	*/
	Map selectDetail(int board_id);
	
	/**
	* Method : insert
	* 작성자 : PC-17
	* 변경이력 :
	* @param map (board_name, board_use, userId)
	* @return board_id
	* Method 설명 : 게시판 추가
	*/
	int insert(Map map);
	
	/**
	* Method : update
	* 작성자 : PC-17
	* 변경이력 :
	* @param map (board_name, board_use, board_id)
	* @return success?
	* Method 설명 : 게시판 수정 
	*/
	int update(Map map);
}

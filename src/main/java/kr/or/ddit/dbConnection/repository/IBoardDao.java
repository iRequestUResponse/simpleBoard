package kr.or.ddit.dbConnection.repository;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

public interface IBoardDao {
	/**
	* Method : selectAll
	* 작성자 : PC-17
	* 변경이력 :
	* @param sqlSession
	* @return (board_id, board_name, board_use, userId, board_time)
	* Method 설명 : 모든 게시판 목록 가져오기
	*/
	List<Map> selectAll(SqlSession sqlSession);
	
	/**
	* Method : insert
	* 작성자 : PC-17
	* 변경이력 :
	* @param sqlSession
	* @param map (board_name, board_use, userId)
	* @return board_id
	* Method 설명 : 게시판 추가
	*/
	int insert(SqlSession sqlSession, Map map);
	
	/**
	* Method : update
	* 작성자 : PC-17
	* 변경이력 :
	* @param sqlSession
	* @param map (board_name, board_use, board_id)
	* @return success?
	* Method 설명 : 게시판 수정 
	*/
	int update(SqlSession sqlSession, Map map);
}

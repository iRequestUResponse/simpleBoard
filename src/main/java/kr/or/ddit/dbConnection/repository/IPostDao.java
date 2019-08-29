package kr.or.ddit.dbConnection.repository;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

public interface IPostDao {
	/**
	* Method : selectAll
	* 작성자 : PC-17
	* 변경이력 :
	* @param sqlSession
	* @return (post_id, board_id, post_title, post_cont, userId, post_time, post_parent, post_del, gn)
	* Method 설명 : 해당 페이지의 게시글을 가져온다
	*/
	List<Map> selectAll(SqlSession sqlSession, Map map);
	
	/**
	* Method : selectCnt
	* 작성자 : PC-17
	* 변경이력 :
	* @param sqlSession
	* @return cnt
	* Method 설명 : 모든 게시글의 수를 가져온다 
	*/
	int selectCnt(SqlSession sqlSession);
	
	/**
	* Method : selectDetail
	* 작성자 : PC-17
	* 변경이력 :
	* @param sqlSession
	* @param post_id
	* @return (post_id, board_id, post_title, post_cont, userId, post_time, post_parent, post_del, gn)
	* Method 설명 : 게시글 상세를 가져온다
	*/
	Map selectDetail(SqlSession sqlSession, int post_id);
	
	/**
	* Method : insert
	* 작성자 : PC-17
	* 변경이력 :
	* @param sqlSession
	* @param map (post_id, board_id, post_title, post_cont, userId, post_time, post_parent, post_del, gn)
	* @return post_id
	* Method 설명 : 게시글을 추가한다
	*/
	int insert(SqlSession sqlSession, Map map);
	
	/**
	* Method : update
	* 작성자 : PC-17
	* 변경이력 :
	* @param sqlSession
	* @param map (post_title, post_cont, post_id)
	* @return success?
	* Method 설명 :게시글을 수정한다
	*/
	int update(SqlSession sqlSession, Map map);
	
	/**
	* Method : updateTodelete
	* 작성자 : PC-17
	* 변경이력 :
	* @param sqlSession
	* @param post_id
	* @return success?
	* Method 설명 : 게시글을 삭제한다
	*/
	int deleteByUpdate(SqlSession sqlSession, int post_id);
}

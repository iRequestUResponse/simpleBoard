package kr.or.ddit.dbConnection.repository;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

public interface ICommentDao {
	/**
	* Method : selectAllOfPost
	* 작성자 : PC-17
	* 변경이력 :
	* @param sqlSession
	* @param post_id
	* @return (cmt_id, cmt_cont, cmt_time, post_id, userId, cmt_del)
	* Method 설명 : 게시글의 덧글 모두 가져오기
	*/
	List<Map> selectAllOfPost(SqlSession sqlSession, int post_id);
	
	/**
	* Method : insert
	* 작성자 : PC-17
	* 변경이력 :
	* @param sqlSession
	* @param map (cmt_cont, post_id, userId)
	* @return cmt_id
	* Method 설명 : 덧글 추가
	*/
	int insert(SqlSession sqlSession, Map map);
	

	/**
	* Method : updateToDelete
	* 작성자 : PC-17
	* 변경이력 :
	* @param sqlSession
	* @param cmt_id
	* @return success?
	* Method 설명 : 덧글 삭제
	*/
	int deleteByUpdate(SqlSession sqlSession, int cmt_id);
}

package kr.or.ddit.dbConnection.service;

import org.apache.ibatis.session.SqlSession;

import kr.or.ddit.dbConnection.model.User;
import kr.or.ddit.dbConnection.repository.IUserDao;
import kr.or.ddit.dbConnection.repository.UserDao;
import kr.or.ddit.util.MybatisUtil;

public class UserService implements IUserService {
	
	private IUserDao userDao;
	public UserService() {
		userDao = new UserDao();
	}

	@Override
	public User getUser(String userId) {
		SqlSession sqlSession = MybatisUtil.getSession();
		User user = userDao.getUser(sqlSession, userId);
		sqlSession.commit();
		sqlSession.close();
		return user;
	}
}

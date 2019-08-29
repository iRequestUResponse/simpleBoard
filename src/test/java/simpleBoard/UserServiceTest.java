package simpleBoard;

import static org.junit.Assert.*;

import org.junit.Test;

import kr.or.ddit.dbConnection.model.User;
import kr.or.ddit.dbConnection.service.IUserService;
import kr.or.ddit.dbConnection.service.UserService;

public class UserServiceTest {
	
	private IUserService userService = new UserService(); 

	@Test
	public void test() {
		/***Given***/
		String userId = "brown";

		/***When***/
		User user = userService.getUser(userId);

		/***Then***/
		assertEquals("브라운", user.getUserNm());
	}

}

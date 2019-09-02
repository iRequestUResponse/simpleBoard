package simpleBoard.service;

import static org.junit.Assert.assertEquals;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import kr.or.ddit.dbConnection.service.AttService;
import kr.or.ddit.dbConnection.service.IAttService;

public class AttServiceTest {
	private IAttService service = new AttService();
	
	@Before
	public void setup() {
		service.delete(9999);
	}
	
	@After
	public void teardown() {
	}
	
	@Test
	public void selectAllOfPostTest() {
		/***Given***/
		List<Map> list = service.selectAllOfPost(5);
		List<Map> list2 = service.selectAllOfPost(6);

		/***When***/

		/***Then***/
		assertEquals(2, list.size());
		assertEquals(2, list2.size());
	}

	@Test
	public void insertTest() {
		/***Given***/
		Map map = new HashMap();
		map.put("att_id", 9999);
		map.put("att_name", "test");
		map.put("att_path", "testPath");
		map.put("post_id", 1);

		/***When***/
		int cnt = service.insert(map);

		/***Then***/
		assertEquals(1, cnt);
	}
}

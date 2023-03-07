package test;


import java.sql.SQLException;
import java.util.List;


import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import db.DataAccessException;
import model.Group;

public class TestGroupDB {

	@BeforeEach
	public void setUp() throws Exception {
		DBCleanup.cleanDB();
	}

	@AfterEach
	public void tearDown() throws Exception {
	}

	@Test
	public void testFindAll() {
//		try {
//			List<Group> gs = new GroupDB().findAll();
//			assertEquals(2, gs.size());
//		} catch (HorribleException e) {
//			fail("Couldn't do findAll on Groups");
//			e.printStackTrace();
//		}
	}

}

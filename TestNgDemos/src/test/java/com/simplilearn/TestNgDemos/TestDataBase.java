package com.simplilearn.TestNgDemos;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import java.util.HashMap;

import org.testng.Assert;
import org.testng.annotations.Test;

public class TestDataBase {
	@Test
	
	public void testDataBase() {
		DatabaseUtils utils = new DatabaseUtils();
		utils.openConnection();
		HashMap<Integer, String> users= utils.getUsers();
		
		AssertJUnit.assertEquals(2, users.size());
		AssertJUnit.assertEquals("John", users.get(1));
		AssertJUnit.assertEquals("Mani", users.get(2));
		
		utils.closeConnection();
	}

}

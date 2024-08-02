package com.simplilearn.seleniumDemos;

import java.util.HashMap;

import org.testng.Assert;
import org.testng.annotations.Test;

public class TestDataBase {
	@Test
	
	public void testDataBase() {
		DatabaseUtils utils = new DatabaseUtils();
		utils.openConnection();
		HashMap<Integer, String> users= utils.getUsers();
		
		Assert.assertEquals(2, users.size());
		Assert.assertEquals("John", users.get(1));
		Assert.assertEquals("Mani", users.get(2));
		
		utils.closeConnection();
	}

}

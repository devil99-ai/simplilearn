package com.simplilearn.TDD;

import org.testng.Assert;
import org.testng.annotations.Test;

public class AppTest {
	@Test
	public void testPassword() {
		PasswordValidator password = new PasswordValidator();
		boolean result = password.isValid("pq11r");
		Assert.assertEquals(true, result);
	}
}


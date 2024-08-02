package com.simplilearn.JunitMaven;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * Unit test for simple App.
 */
public class AppTest{
	@Test
	void test() {
		int actualAmount = 100;
		int expectedAmount=1000;
		
		Assertions.assertEquals(expectedAmount, actualAmount);
	}
	
		
	
	
}

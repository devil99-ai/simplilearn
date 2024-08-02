package com.simplilearn.myapp.test;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import junit.framework.TestCase;

public class MyFirstJunitTest extends TestCase {
	@Test
	void test() {
		int expectedAmount =1000;
		int actualAmount = 1000;
		
		Assertions.assertEquals(expectedAmount,actualAmount);
	}

}

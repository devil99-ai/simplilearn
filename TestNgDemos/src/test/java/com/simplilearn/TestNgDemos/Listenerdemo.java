package com.simplilearn.TestNgDemos;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.Test;

public class Listenerdemo {
	
		String message = "Welcome to simplilearn";
		
		@Test
		public void testCase1() {
			System.out.println("Testcase1: must be passed");
			AssertJUnit.assertEquals(message, "Welcome to simplilearn");
		}
		
		@Test
		public void testCase2() {
			System.out.println("Testcase2: must be failed");
			AssertJUnit.assertEquals(message, "simplilearn");
		}
		@Test
		public void testCase3() {
			System.out.println("Testcase1: must be skipped");
			throw new SkipException("skipping the test case 3");
		}
	
}

package com.simplilearn.TestNgDemos;

import org.testng.SkipException;
import org.testng.annotations.Test;

public class SkipTestDemo {
	@Test(enabled = false)
	public void Test1() {
		System.out.println("TestCase1 - This will not be executed");
	}
	@Test
	public void Test2() {
		System.out.println("TestCase2 - Skip Exception Example");
		throw new SkipException("Skipping this test2");
	}
	@Test
	public void Test3() {
		System.out.println("TestCase3 - Conditional Skip");
		boolean isDataAvailable = false;
		if(!isDataAvailable) {
			throw new SkipException("Skipping case3 on a condition");
		}
	}

}

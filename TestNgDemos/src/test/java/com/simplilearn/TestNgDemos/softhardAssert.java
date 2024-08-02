package com.simplilearn.TestNgDemos;

import org.testng.annotations.Test;
import org.testng.asserts.Assertion;
import org.testng.asserts.SoftAssert;

public class softhardAssert {
	
	String className = "softhardAssert";
	Assertion hardAssert = new Assertion();
	SoftAssert softAssert = new SoftAssert();
	
	@Test
	public void hardAssertTest() {
		hardAssert.assertTrue(true==true);
		hardAssert.assertTrue("softhardAssert"=="softhardAssert");
		hardAssert.assertEquals(className, "softhardAssert");
		System.out.println("hardAsserttest Successfully passed !!");
	}
	@Test
	public void softAssertTest() {
		softAssert.assertTrue(true==true);
		softAssert.assertTrue("softhardAssert"=="softhardAssert");
		softAssert.assertEquals(className, "softhardAssert");
		System.out.println("softAssertTest successfully passed !!");
		softAssert.assertAll();
	}

}
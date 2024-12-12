package com.simplilearn.TestNgDemos;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;
import org.testng.asserts.Assertion;
import org.testng.asserts.SoftAssert;

public class softhardAssert {
	
	String className = "softhardAssert";
	Assertion hardAssert = new Assertion();
	SoftAssert softAssert = new SoftAssert();
	
	@Test
	public void hardAssertTest() {
		AssertJUnit.assertTrue(true==true);
		AssertJUnit.assertTrue("softhardAssert"=="softhardAssert");
		AssertJUnit.assertEquals(className, "softhardAssert");
		System.out.println("hardAsserttest Successfully passed !!");
	}
	@Test
	public void softAssertTest() {
		AssertJUnit.assertTrue(true==true);
		AssertJUnit.assertTrue("softhardAssert"=="softhardAssert");
		AssertJUnit.assertEquals(className, "softhardAssert");
		System.out.println("softAssertTest successfully passed !!");
		softAssert.assertAll();
	}

}

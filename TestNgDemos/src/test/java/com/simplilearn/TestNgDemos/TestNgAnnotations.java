package com.simplilearn.TestNgDemos;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class TestNgAnnotations {
	@Test
	public void Test1() {
		System.out.println("Test Case 1");
	}
	@Test
	public void Test2() {
		System.out.println("Test case 2");
	}
	@BeforeMethod
	public void BeforeMethod() {
		System.out.println("Before Method");
		
	}
	@AfterMethod
	public void afterMethod() {
		System.out.println("After Method");
	}
	
	@BeforeTest
	public void beforeTest() {
		System.out.println("Before test");
	}
	@AfterTest
	public void afterTest() {
		System.out.println("After Test");
	}
	@BeforeClass
	public void beforeClass() {
		System.out.println("Before class");
		
	}
	@AfterClass
	public void afterClass() {
		System.out.println("After Class");
	}
	@BeforeSuite
	public void beforeSuite() {
		System.out.println("Before Suite");
		
	}
	@AfterSuite
	public void aftersuite() {
		System.out.println("After Suite");
	}

}

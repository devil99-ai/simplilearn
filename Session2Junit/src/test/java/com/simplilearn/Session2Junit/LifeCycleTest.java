package com.simplilearn.Session2Junit;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class LifeCycleTest {
	Calculator cal;
	
	@BeforeAll
	public static void beforeAll() {
		System.out.println("Before all executed");
	}
	@AfterAll
	public static void afterAll() {
		System.out.println("After all executed");
	}
	@BeforeEach
	public void beforeEach() {
		System.out.println("Before Each executed");
		 cal = new Calculator();
	}
	@AfterEach
	public void afterEach() {
		System.out.println("After Each executed");
	}
	@Test
	void Add() {
		System.out.println("Add executed");
		Calculator cal = new Calculator();
		int actualResult = cal.add(10, -5);
		int expectedResult = 5;
		Assertions.assertEquals(expectedResult, actualResult);
	}
	@Test
	void testModulo() {
		System.out.println("testModulo executed");
		Calculator cal = new Calculator();
		int actualResult = cal.modulo(10, -5);
		int expectedResult = 0;
		Assertions.assertEquals(expectedResult, actualResult);
	}

}

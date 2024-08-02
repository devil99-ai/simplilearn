package com.simplilearn.Session2Junit;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertTrue;
public class calculatorAppTest {
	
	@Test
	public void testEvenCalculator() {
		Calculator1 calc =new Calculator1();
		assertTrue(calc.isEvenNumber(2));
		assertTrue(calc.isEvenNumber(6));
		assertTrue(calc.isEvenNumber(8));
		assertTrue(calc.isEvenNumber(4));
		assertTrue(calc.isEvenNumber(10));
		assertTrue(calc.isEvenNumber(12));
		assertTrue(calc.isEvenNumber(18));
		assertTrue(calc.isEvenNumber(20));
	}
	@ParameterizedTest
	@ValueSource(ints= {2, 4, 6, 12, 16, 22})
	public void test(int number) {
		Calculator1 calc =new Calculator1();
		System.out.println("number is: "+number);
		assertTrue(calc.isEvenNumber(number));
	}

}

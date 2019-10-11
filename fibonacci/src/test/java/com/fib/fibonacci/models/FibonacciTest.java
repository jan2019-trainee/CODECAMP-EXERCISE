package com.fib.fibonacci.models;


import static org.junit.Assert.assertEquals;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class FibonacciTest{

	@Test
	public void testGenerate() {
		String pattern1 = "0 + 1 + 1 + ";
		String pattern2 = "0 + 1 + 1 + 2 + ";
		String pattern3 = "0 + 1 + 1 + 2 + 3 + ";
		Fibonacci fibonacci = new Fibonacci();
		
		assertThat("error", pattern1, is( equalTo (fibonacci.generate(2)))) ;
		assertThat("error", pattern2, is( equalTo (fibonacci.generate(3)))) ;
		assertThat("error", pattern3, is( equalTo (fibonacci.generate(4)))) ;
		
		assertThat("error", pattern3, is( not (equalTo (fibonacci.generate(2))))) ;
		assertThat("error", pattern1, is( not (equalTo (fibonacci.generate(3))))) ;
		assertThat("error", pattern2, is( not (equalTo (fibonacci.generate(4))))) ;
	}
	
	@Test
	public void testReturnNumber() {
		int expectedResult = 3;
		Fibonacci fibo = mock(Fibonacci.class);
		when(fibo.getNum()).thenReturn(3);
		assertEquals(fibo.getNum(),expectedResult);
	}

}
	























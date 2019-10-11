package com.fib.fibonacci.models;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.Test;

public class FibonacciTest2 {

	@Test
	public void testGenerate() {
		Fibonacci fibo = mock(Fibonacci.class);
		when(fibo.getNum()).thenReturn(3);
		assertEquals(fibo.getNum(),3);
	}

}

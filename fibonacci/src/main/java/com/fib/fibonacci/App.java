package com.fib.fibonacci;

import com.fib.fibonacci.models.Fibonacci;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	int number = 4;
    	Fibonacci fibonacci =  new Fibonacci();
        
    	fibonacci.generate(number);
    }
}

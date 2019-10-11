package com.fib.fibonacci.models;

public class Fibonacci {

	private int num;
	
	public Fibonacci() {}
	
	public Fibonacci(int num) {
		super();
		this.setNum(num);
	}

	public String generate(int n) {
		int t1 = 0, t2 = 1;
		String result = "";
		
		for (int i = 0; i <= n; i++) {
			result += t1 + " + ";
			int sum = t1 + t2;
			t1 = t2;
			t2 = sum;
		}
		return result;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}
}

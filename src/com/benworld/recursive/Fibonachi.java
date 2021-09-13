package com.benworld.recursive;

public class Fibonachi {
	public int fibo(int num) {
		if(num <= 1) {
			return num;
		}else {
			return this.fibo(num-1) + this.fibo(num-2);
		}
	}
}

package com.benworld.recursive;

public class Dynamic {
	public int dynamic(int num) {
		int[] cache = new int[num+1];
		cache[0] = 0;
		cache[1] = 1;
		for(int i=2; i<num+1; i++) {
			cache[i] = cache[i-1] + cache[i-2];
		}
		return cache[num];
	}
}

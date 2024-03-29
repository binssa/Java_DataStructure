package com.benworld.datastructure;

import java.util.ArrayList;

public class MyQueue<T> {
	//ArrayList를 활용하여 Queue 생성
	private ArrayList<T> queue = new ArrayList<T>();
	
	public void enqueue(T item) {
		queue.add(item);
	}
	
	public T dequeue() {
		if(queue.isEmpty()) {
			return null;
		}
		return queue.remove(0);
	}
	
	public boolean isEmpty() {
		return queue.isEmpty();
	}
}

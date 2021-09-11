package com.benworld.datastructure;

import java.util.ArrayList;
import java.util.Collections;

// 배열을 통한 Heap 구현
// 부모 노드 Index Number = 자식 노드 Index Number/2
// 왼쪽 자식 노드 Index Number = 부모 노드 Index Number * 2;
// 오른쪽 자식 노드 Index Number = 부모 노드 Index Number * 2 + 1;
public class MyHeap {
	public ArrayList<Integer> heapArray = null;
	
	public MyHeap(int data) {
		heapArray = new ArrayList<Integer>();
		
		heapArray.add(null);
		heapArray.add(data);
	}
	
	// 부모의 값보다 작은 지 확인하는 메서드
	public boolean moveUp(int inserted_idx) {
		// Root Node일 경우 
		if(inserted_idx <= 1) {
			return false;
		}
		int parent_idx = inserted_idx/2;
		if(this.heapArray.get(inserted_idx) > this.heapArray.get(parent_idx)) {
			return true;
		}else {
			return false;
		}
	}

	// 삽입 
	public boolean insert(int data) {
		int inserted_idx, parent_idx;
		
		if(heapArray == null) {
			heapArray = new ArrayList<Integer>();
			
			heapArray.add(null);
			heapArray.add(data);
			return true;
		}
		this.heapArray.add(data);
		inserted_idx = this.heapArray.size() - 1;
		
		while(this.moveUp(inserted_idx)) {
			parent_idx = inserted_idx/2;
			Collections.swap(heapArray, inserted_idx, parent_idx);
			inserted_idx = parent_idx;
		}
		return true;
	}
	public boolean moveDown(int pop_idx) {
		int left_idx, right_idx;
		left_idx = pop_idx * 2;
		right_idx = pop_idx * 2 + 1;
		
		// Case 1 : 자식 노드가 없을 때 
		if(left_idx >= this.heapArray.size()) {
			return false;
		}
		// Case 2 : 오른쪽 자식 노드가 없을 때
		else if(right_idx >= this.heapArray.size()) {
			if(this.heapArray.get(pop_idx) < this.heapArray.get(left_idx)) {
				return true;
			}
			else {
				return false;
			}
		}
		// Case 3 : 양쪽 모두 자식 노드가 있을 때
		else {
			if(this.heapArray.get(left_idx) > this.heapArray.get(right_idx)) {
				if(this.heapArray.get(pop_idx) < this.heapArray.get(left_idx)) {
					return true;
				}else {
					return false;
				}
			}else {
				if(this.heapArray.get(pop_idx) < this.heapArray.get(right_idx)) {
					return true;
				}else {
					return false;
				}
			}
		}
	}
	
	// 삭제 
	public Integer pop() {
		int return_data, pop_idx, left_idx, right_idx;
		
		if(this.heapArray == null) {
			return null;
		}else {
			// root data 반환
			return_data = this.heapArray.get(1);
			// root 자리에 가장 마지막 값을 넣은뒤 해당 값 삭제
			this.heapArray.set(1, this.heapArray.get(this.heapArray.size()-1));
			this.heapArray.remove(this.heapArray.size()-1);
			pop_idx = 1;
			
			while(this.moveDown(pop_idx)) {
				left_idx = pop_idx * 2;
				right_idx = pop_idx * 2 + 1;
				// Case 1: 오른쪽 자식이 없을 때
				if(right_idx >= this.heapArray.size()) {
					if(this.heapArray.get(pop_idx) < this.heapArray.get(left_idx)) {
						Collections.swap(heapArray, pop_idx, left_idx);
						pop_idx = left_idx;
					}
				}
				// Case 2 : 양쪽 자식 모두 있을 때
				else {
					if(this.heapArray.get(left_idx) > this.heapArray.get(right_idx)) {
						if(this.heapArray.get(pop_idx) < this.heapArray.get(left_idx)){
							Collections.swap(heapArray, pop_idx, left_idx);
							pop_idx = left_idx;
						}
					}else {
						if(this.heapArray.get(pop_idx) < this.heapArray.get(right_idx)){
							Collections.swap(heapArray, pop_idx, right_idx);
							pop_idx = right_idx;
						}
					}
				}
			}
			
			return return_data;
		}
	}
}

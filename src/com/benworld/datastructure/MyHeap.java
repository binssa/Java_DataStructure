package com.benworld.datastructure;

import java.util.ArrayList;
import java.util.Collections;

// �迭�� ���� Heap ����
// �θ� ��� Index Number = �ڽ� ��� Index Number/2
// ���� �ڽ� ��� Index Number = �θ� ��� Index Number * 2;
// ������ �ڽ� ��� Index Number = �θ� ��� Index Number * 2 + 1;
public class MyHeap {
	public ArrayList<Integer> heapArray = null;
	
	public MyHeap(int data) {
		heapArray = new ArrayList<Integer>();
		
		heapArray.add(null);
		heapArray.add(data);
	}
	
	// �θ��� ������ ���� �� Ȯ���ϴ� �޼���
	public boolean moveUp(int inserted_idx) {
		// Root Node�� ��� 
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

	// ���� 
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
		
		// Case 1 : �ڽ� ��尡 ���� �� 
		if(left_idx >= this.heapArray.size()) {
			return false;
		}
		// Case 2 : ������ �ڽ� ��尡 ���� ��
		else if(right_idx >= this.heapArray.size()) {
			if(this.heapArray.get(pop_idx) < this.heapArray.get(left_idx)) {
				return true;
			}
			else {
				return false;
			}
		}
		// Case 3 : ���� ��� �ڽ� ��尡 ���� ��
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
	
	// ���� 
	public Integer pop() {
		int return_data, pop_idx, left_idx, right_idx;
		
		if(this.heapArray == null) {
			return null;
		}else {
			// root data ��ȯ
			return_data = this.heapArray.get(1);
			// root �ڸ��� ���� ������ ���� ������ �ش� �� ����
			this.heapArray.set(1, this.heapArray.get(this.heapArray.size()-1));
			this.heapArray.remove(this.heapArray.size()-1);
			pop_idx = 1;
			
			while(this.moveDown(pop_idx)) {
				left_idx = pop_idx * 2;
				right_idx = pop_idx * 2 + 1;
				// Case 1: ������ �ڽ��� ���� ��
				if(right_idx >= this.heapArray.size()) {
					if(this.heapArray.get(pop_idx) < this.heapArray.get(left_idx)) {
						Collections.swap(heapArray, pop_idx, left_idx);
						pop_idx = left_idx;
					}
				}
				// Case 2 : ���� �ڽ� ��� ���� ��
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

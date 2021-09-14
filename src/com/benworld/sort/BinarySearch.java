package com.benworld.sort;

import java.util.ArrayList;

public class BinarySearch {
	public boolean search(ArrayList<Integer> dataList, int findData) {
		// Case 1 : 값이 하나인데 찾는 값일 때
		if(dataList.size()==1 && findData == dataList.get(0)) {
			return true;
		}
		// Case 2 : 값이 하나인데 찾는 값이 아닐 때
		if(dataList.size()==1 && findData != dataList.get(0)) {
			return false;
		}
		// Case 3 : 값이 0개 일때 
		if(dataList.size() == 0) {
			return false;
		}
		
		
		int mid = dataList.size()/2;
		
		// Case 4 : 중간 값이 찾는 값일 때
		if(dataList.get(mid) == findData) {
			return true;
		}else {
			// Case 5-1 : 중간 값보다 찾는 값이 클 때 
			if(dataList.get(mid) < findData) {
				return this.search(new ArrayList<Integer>(dataList.subList(mid, dataList.size())), findData);
			// Case 5-2 : 중간 값보다 찾는 값이 작을 때 
			}else {
				return this.search(new ArrayList<Integer>(dataList.subList(0, mid)), findData);
			}
		}
	}
}

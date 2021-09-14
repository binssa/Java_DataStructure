package com.benworld.sort;

import java.util.ArrayList;

public class BinarySearch {
	public boolean search(ArrayList<Integer> dataList, int findData) {
		// Case 1 : ���� �ϳ��ε� ã�� ���� ��
		if(dataList.size()==1 && findData == dataList.get(0)) {
			return true;
		}
		// Case 2 : ���� �ϳ��ε� ã�� ���� �ƴ� ��
		if(dataList.size()==1 && findData != dataList.get(0)) {
			return false;
		}
		// Case 3 : ���� 0�� �϶� 
		if(dataList.size() == 0) {
			return false;
		}
		
		
		int mid = dataList.size()/2;
		
		// Case 4 : �߰� ���� ã�� ���� ��
		if(dataList.get(mid) == findData) {
			return true;
		}else {
			// Case 5-1 : �߰� ������ ã�� ���� Ŭ �� 
			if(dataList.get(mid) < findData) {
				return this.search(new ArrayList<Integer>(dataList.subList(mid, dataList.size())), findData);
			// Case 5-2 : �߰� ������ ã�� ���� ���� �� 
			}else {
				return this.search(new ArrayList<Integer>(dataList.subList(0, mid)), findData);
			}
		}
	}
}

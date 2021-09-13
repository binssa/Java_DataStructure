package com.benworld.sort;

import java.util.ArrayList;

public class MergeSort {
	public ArrayList<Integer> split(ArrayList<Integer> data) {
		if(data.size() <= 1) {
			return data; 
		}
		int medium = data.size()/2;
		
		ArrayList<Integer> leftArr = split(new ArrayList<Integer>(data.subList(0, medium)));
		ArrayList<Integer> rightArr = split(new ArrayList<Integer>(data.subList(medium, data.size())));
		
		return merge(leftArr, rightArr);
		
	}
	public ArrayList<Integer> merge(ArrayList<Integer> leftArr, ArrayList<Integer> rightArr) {
		int lp = 0;
		int rp = 0;
		
		ArrayList<Integer> resultArr = new ArrayList<Integer>();
		while(leftArr.size() > lp && rightArr.size() > rp) {
			// ���� �迭�� ���� ������ �迭�� ������ ���� �� 
			if(leftArr.get(lp) < rightArr.get(rp)) {
				resultArr.add(leftArr.get(lp));
				lp++;
			// ������ �迭�� ���� ���� �迭�� ������ ���� ��				
			}else {
				resultArr.add(rightArr.get(rp));
				rp++;
			}
		}
		while(leftArr.size() > lp) {
			resultArr.add(leftArr.get(lp));
			lp++;
		}
		while(rightArr.size() > rp) {
			resultArr.add(rightArr.get(rp));
			rp++;
		}
		return resultArr;
	}
}

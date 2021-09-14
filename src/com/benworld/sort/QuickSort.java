package com.benworld.sort;

import java.util.ArrayList;

public class QuickSort {
	public ArrayList<Integer> sort(ArrayList<Integer> dataList){
		if(dataList.size()<=1) {
			return dataList;
		}
		int pibot = 0;
		ArrayList<Integer> leftArr = new ArrayList<Integer>();
		ArrayList<Integer> rightArr = new ArrayList<Integer>();
		for(int i=pibot+1;i<dataList.size();i++) {
			if(dataList.get(pibot) > dataList.get(i)) {
				leftArr.add(dataList.get(i));
			}else {
				rightArr.add(dataList.get(i));
			}
		}
		
		ArrayList<Integer> resultArr = new ArrayList<Integer>();
		resultArr.addAll(this.sort(leftArr));
		resultArr.add(dataList.get(pibot));
		resultArr.addAll(this.sort(rightArr));
		return resultArr;
	}
}

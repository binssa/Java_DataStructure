package com.benworld.sort;

import java.util.ArrayList;
import java.util.Collections;

public class InsertionSort {
	public ArrayList<Integer> sort(ArrayList<Integer> dataList){
		for(int i=0;i<dataList.size()-1;i++) {
			for(int j=i+1;j>0;j--) {
				if(dataList.get(j) < dataList.get(j-1)){
					Collections.swap(dataList, j-1, j);
				}
			}
		}
		return dataList;
	}
}

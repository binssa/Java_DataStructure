package com.benworld.sort;

import java.util.ArrayList;

public class SequentialSearch {
	public boolean search(ArrayList<Integer> dataList, int findItem) {
		for(int i=0; i<dataList.size();i++) {
			if(dataList.get(i) == findItem) {
				return true;
			}
		}
		return false;
	}
}

package com.benworld.search;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class Greedy {
	public void coinFunc(int price, ArrayList<Integer> coinList) {
		int totalCoinCount = 0;
		int coinNum = 0;
		ArrayList<Integer> details = new ArrayList<Integer>();
		
		for(int i=0; i<coinList.size(); i++) {
			coinNum = price/coinList.get(i);
			totalCoinCount += coinNum;
			price -= coinNum * coinList.get(i);
			details.add(coinNum);
			System.out.println(coinList.get(i)+"�� : "+coinNum+"��");
		}
		System.out.println("�� ���� ���� : " +totalCoinCount);
	}
	
	public void knapsackFunc(Integer[][] objectList, double capacity) {
		double total = 0.0;
		double fraction = 0.0;
		
		Arrays.sort(objectList, new Comparator<Integer[]>(){
			public int compare(Integer[] objectItem1, Integer[] objectItem2) {
				return (objectItem2[1]/objectItem2[0]) - (objectItem1[1]/objectItem1[0]);
			}
		});
		for(int i=0;i<objectList.length;i++) {
			if((capacity - (double)objectList[i][0]) > 0) {
				capacity -= (double)objectList[i][0];
				total  += (double)objectList[i][1];
				System.out.println("���� : "+objectList[i][0]+", ��ġ : "+objectList[i][1]);
			}else {
				fraction = capacity/(double)objectList[i][0];
				total  += (double)objectList[i][1]*fraction;
				System.out.println("���� : "+objectList[i][0]+", ��ġ : "+objectList[i][1] + ", ���� : "+fraction);
				break;
			}
		}
		System.out.println("�� ���� �� �ִ� ��ġ : "+total);
	}
}

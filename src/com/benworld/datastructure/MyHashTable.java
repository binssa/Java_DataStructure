package com.benworld.datastructure;

public class MyHashTable {
	public Slot[] hashTable;
	
	public MyHashTable(Integer size) {
		this.hashTable = new Slot[size];
	}
	
	public class Slot {
		String value;
		Slot(String value) {
			this.value = value;
		}
	}
	
	public Integer hashFunction(String key) {
		return (int)(key.charAt(0)) % this.hashTable.length;
	}
	
	public void saveData(String key, String value) {
		int index = this.hashFunction(key);
		if(hashTable[index] != null) {
			hashTable[index].value = value;
		}else {
			hashTable[index] = new Slot(value);
		}
	}
	
	public String getData(String key) {
		int index = this.hashFunction(key);
		if(hashTable[index] == null) {
			return null;
		}else {
			return this.hashTable[index].value;
		}
	}
	
}

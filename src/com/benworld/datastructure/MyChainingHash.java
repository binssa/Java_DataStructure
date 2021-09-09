package com.benworld.datastructure;

public class MyChainingHash {
	public Slot[] hashTable;
	
	public MyChainingHash(Integer size) {
		this.hashTable = new Slot[size];
	}
	
	// Chaining Slot
	public class Slot{
		String key;
		String value;
		Slot next;
		Slot(String key, String value) {
			this.key = key;
			this.value = value;
			this.next = null;
		}
	}
	
	public Integer hashFunction(String key) {
		return (int)(key.charAt(0)) % this.hashTable.length;
	}
	
	public boolean saveData(String key, String value) {
		int index = this.hashFunction(key);
		if(hashTable[index] != null) {
			//hashTable[index].value = value;
			Slot findSlot = this.hashTable[index];
			Slot prevSlot = this.hashTable[index];
			while(findSlot != null) {
				if(findSlot.key == key) {
					findSlot.value = value;
					return true;
				}else {
					prevSlot = findSlot;
					findSlot = findSlot.next;
				}
			}
			prevSlot.next = new Slot(key,value);
		}else {
			hashTable[index] = new Slot(key, value);
		}
		return true;
	}
	
	public String getData(String key) {
		int index = this.hashFunction(key);
		if(hashTable[index] == null) {
			return null;
		}else {
			Slot findSlot = this.hashTable[index];
			while(findSlot != null) {
				if(findSlot.key == key) {
					return findSlot.value;
				}else {
					findSlot = findSlot.next;
				}
			}
			return null;
		}
	}
	
}

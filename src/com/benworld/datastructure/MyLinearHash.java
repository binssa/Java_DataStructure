package com.benworld.datastructure;

public class MyLinearHash {
	public Slot[] hashTable;
	
	public MyLinearHash(Integer size) {
		this.hashTable = new Slot[size];
	}
	
	// ±âº» Slot
	public class Slot {
		String key;
		String value;
		Slot(String key, String value) {
			this.key = key;
			this.value = value;
		}
	}
		
	public Integer hashFunction(String key) {
		return (int)(key.charAt(0)) % this.hashTable.length;
	}
	
	public boolean saveData(String key, String value) {
		int index = this.hashFunction(key);
		if(this.hashTable[index] != null) {
			if(this.hashTable[index].key == key) {
				this.hashTable[index].value = value;
				return true;
			}else {
				int cur_idx = index + 1;
				while(this.hashTable[cur_idx] != null) {
					if(this.hashTable[cur_idx].key == key) {
						this.hashTable[cur_idx].value = value;
						return true;
					}else {
						cur_idx++;
						if(cur_idx >= this.hashTable.length) {
							return false;
						}
					}
				}
				this.hashTable[cur_idx] = new Slot(key, value);
				return true;
			}
		}else {
			this.hashTable[index] = new Slot(key, value);
		}
		return true;
	}
	
	public String getData(String key) {
		int index = this.hashFunction(key);
		if(this.hashTable[index] == null) {
			return null;
		}else {
			if(this.hashTable[index].key == key) {
				return this.hashTable[index].value;
			}else {
				int cur_idx = index + 1;
				while(this.hashTable[cur_idx] != null) {
					if(this.hashTable[cur_idx].key == key) {
						return this.hashTable[cur_idx].value;
					}else {
						cur_idx++;
						if(cur_idx >= this.hashTable.length) {
							return null;
						}
					}
				}
				return null;
			}
		}
	}
	
}

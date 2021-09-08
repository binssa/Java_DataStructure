package com.benworld.datastructure;

public class MyLinkedList<T> {
	public Node<T> head = null;
	
	public class Node<T>{
		T item;
		Node<T> next = null;
		
		public Node(T item){
			this.item = item;
		}
	}
	
	public void addNode(T item) {
		if(head == null) {
			head = new Node<T>(item);
		}else {
			Node<T> node = this.head;
			while(node.next != null) {
				node = node.next;
			}
			node.next = new Node<T>(item);
		}
		
	}
	// 전체 데이터 출력 
	public void printAll() {
		if(head != null) {
			Node<T> node = this.head;
			System.out.println(node.item);
			while(node.next != null) {
				node = node.next;
				System.out.println(node.item);
			}
		}
	}
	
	public Node<T> searchNode(T frontItem) {
		if(this.head == null) {
			return null;
		}else {
			Node<T> node = this.head;
			while(node != null) {
				if(node.item == frontItem) {
					return node;
				}else {
					node = node.next;
				}
			}
			return null;
		}
	}
	public void addNodeInside(T item, T frontItem) {
		Node<T> searchedNode = this.searchNode(frontItem);
		
		if(searchedNode == null) {
			this.addNode(item);
		}else {
			Node<T> nextNode = searchedNode.next;
			searchedNode.next = new Node<T>(item);
			searchedNode.next.next = nextNode;
		}
	}
	
	public boolean deleteNode(T item) {
		if(this.head == null) {
			return false;
		}else {
			Node<T> node = this.head;
			if(node.item == item) {
				this.head = node.next;
				return true;
			}else {
				while(node.next != null) {
					if(node.next.item == item) {
						node.next = node.next.next;
						return true;
					}
					node = node.next;
				}
			}
			return false;
		}
	}
}

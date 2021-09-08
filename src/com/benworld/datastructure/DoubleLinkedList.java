package com.benworld.datastructure;

public class DoubleLinkedList<T> {
	public Node<T> head = null;
	public Node<T> tail = null;
	
	public class Node<T>{
		T item;
		Node<T> prev = null;
		Node<T> next = null;
		
		public Node(T item) {
			this.item = item;
		}
	}
	
	// 기본 노드 추가 
	public void addNode(T item) {
		if(this.head == null) {
			this.head = new Node(item);
			this.tail = this.head;
		}else {
			Node<T> node = this.head;
			while(node.next != null) {
				node = node.next;
				
			}
			node.next = new Node<T>(item);
			node.next.prev = node;
			this.tail = node.next;
		}
	}
	
	// 전체 노드 출력 
	public void printAll() {
		if(this.head != null) {
			Node<T> node = this.head;
			System.out.println(node.item);
			while(node.next != null) {
				node = node.next;
				System.out.println(node.item);
			}
		}
	}
	
	// head부터 노드 검색 
	public boolean searchFromHead(T item) {
		if(this.head == null) {
			return false;
		}else {
			Node<T> node = this.head;
			while(node != null) {
				if(node.item == item) {
					return true;
				}
				node = node.next;
			}
			return false;
		}
	}
	// tail부터 노드 검색
	public Node<T> searchFromTail(T item) {
		if(this.head == null) {
			return null;
		}else {
			Node<T> node = this.tail;
			while(node != null) {
				if(node.item == item) {
					return node;
				}
				node = node.prev;
			}
		}
		return null;
	}
	
	// 임의 노드 앞에 노드를 추가하는 메서드 추가
	public void addNodeInside(T item, T backItem) {
		Node<T> searchedNode = this.searchFromTail(backItem);
		
		if(searchedNode == null) {
			this.addNode(item);
		}else {
			// 1, 2, 3 중 2 앞에 넣고 싶을 경우
			if(searchedNode == head) {
				Node<T> newHead = new Node<T>(item);
				newHead.next = this.head;
				this.head = newHead;
				newHead.next.prev = this.head;
			}else {
				Node<T> prevNode = searchedNode.prev; // 검색된 노드의 이전 노드 주소를 담을 임시 노드(즉, 1을 가지고있음) 
				searchedNode.prev = new Node<T>(item); // 검색된 노드의 이전 주소에 새 노드 생성
				searchedNode.prev.next = searchedNode; // 검색된 노드의 이전 주소의 다음 주소로 검색된 노드를 입력
				searchedNode.prev.prev = prevNode; // 새로 추가한 노드의 이전 노드 주소를 넣음 (1을 가진 노드를 추가)
				searchedNode.prev.prev.next = searchedNode.prev;
			}
		}
	}
}

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
	
	// �⺻ ��� �߰� 
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
	
	// ��ü ��� ��� 
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
	
	// head���� ��� �˻� 
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
	// tail���� ��� �˻�
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
	
	// ���� ��� �տ� ��带 �߰��ϴ� �޼��� �߰�
	public void addNodeInside(T item, T backItem) {
		Node<T> searchedNode = this.searchFromTail(backItem);
		
		if(searchedNode == null) {
			this.addNode(item);
		}else {
			// 1, 2, 3 �� 2 �տ� �ְ� ���� ���
			if(searchedNode == head) {
				Node<T> newHead = new Node<T>(item);
				newHead.next = this.head;
				this.head = newHead;
				newHead.next.prev = this.head;
			}else {
				Node<T> prevNode = searchedNode.prev; // �˻��� ����� ���� ��� �ּҸ� ���� �ӽ� ���(��, 1�� ����������) 
				searchedNode.prev = new Node<T>(item); // �˻��� ����� ���� �ּҿ� �� ��� ����
				searchedNode.prev.next = searchedNode; // �˻��� ����� ���� �ּ��� ���� �ּҷ� �˻��� ��带 �Է�
				searchedNode.prev.prev = prevNode; // ���� �߰��� ����� ���� ��� �ּҸ� ���� (1�� ���� ��带 �߰�)
				searchedNode.prev.prev.next = searchedNode.prev;
			}
		}
	}
}

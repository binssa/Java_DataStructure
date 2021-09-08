package com.benworld.datastructure;

public class Main {

	public static void main(String[] args) {
//		MyQueue<String> queue = new MyQueue<String>();
//		queue.enqueue("first");
//		queue.enqueue("second");
//		queue.enqueue("third");
//		
//		System.out.println(queue.dequeue());
//		System.out.println(queue.dequeue());
//		System.out.println(queue.dequeue());
//		System.out.println(queue.isEmpty());
//		
//		MyStack<Integer> stack = new MyStack<Integer>();
//		stack.push(1);
//		stack.push(2);
//		stack.push(3);
//		
//		System.out.println(stack.pop());
//		System.out.println(stack.pop());
//		System.out.println(stack.pop());
//		System.out.println(stack.pop());
//		MyLinkedList<Integer> ll = new MyLinkedList<Integer>();
//		ll.addNode(1);
//		ll.addNode(2);
//		ll.addNode(3);
//		ll.addNode(4);
//		ll.addNodeInside(7, 20);
//		//System.out.println(ll.head.next.item);
//		ll.printAll();
//		
//		if(ll.deleteNode(8)) {
//			ll.printAll();
//		}
//		
//		DoubleLinkedList<Integer> dl = new DoubleLinkedList<Integer>();
//		dl.addNode(1);
//		dl.addNode(2);
//		dl.addNode(3);
//		
//		dl.printAll();
//		System.out.println("====");
//		//System.out.println(dl.searchFromHead(3));
//		//System.out.println(dl.searchFromTail(1));
//		dl.addNodeInside(7, 1);
//		dl.addNodeInside(8, 6);
//		dl.printAll();
		
		MyHashTable ht = new MyHashTable(20);
		ht.saveData("DaveLee", "01022223333");
		ht.saveData("Chalie", "01055452222");
		System.out.print(ht.getData("Chalie"));
	}
}

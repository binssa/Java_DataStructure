package com.benworld.datastructure;

import java.util.ArrayList;

import com.benworld.sort.MergeSort;

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
		
//		MyHash ht = new MyHash(20);
//		ht.saveData("DaveLee", "01022223333");
//		ht.saveData("Chalie", "01055452222");
//		System.out.println(ht.getData("Chalie"));
		
//		MyChainingHash ch = new MyChainingHash(20);
//		ch.saveData("DaveLee", "01022223333");
//		ch.saveData("Chalie", "01055452222");
//		ch.saveData("David", "01046465858");
//		ch.saveData("Drake", "01024243232");
//		System.out.println(ch.getData("Drake"));
//		System.out.println(ch.getData("DaveLee"));
		
		
//		MyLinearHash lh = new MyLinearHash(20);
//		lh.saveData("DaveLee", "01022223333");
//		lh.saveData("Chalie", "01055452222");
//		lh.saveData("David", "01046465858");
//		lh.saveData("Drake", "01024243232");
//		System.out.println(lh.getData("Drake"));
//		System.out.println(lh.getData("DaveLee"));
		
//		BinaryTree bt = new BinaryTree();
//		bt.insertNode(10);
//		bt.insertNode(15);
//		bt.insertNode(13);
//		bt.insertNode(11);
//		bt.insertNode(14);
//		bt.insertNode(18);
//		bt.insertNode(16);
//		bt.insertNode(19);
//		bt.insertNode(17);
//		bt.insertNode(7);
//		bt.insertNode(8);
//		bt.insertNode(6);
//		System.out.println(bt.deleteNode(15));
//		System.out.println("HEAD : " + bt.head.value);
//		System.out.println("HEAD LEFT : " + bt.head.left.value);
//		System.out.println("HEAD LEFT LEFT : " + bt.head.left.left.value);
//		System.out.println("HEAD LEFT RIGHT : " + bt.head.left.right.value);
//		System.out.println();
//		System.out.println("HEAD RIGHT : " + bt.head.right.value);
//		System.out.println("HEAD RIGHT LEFT : " + bt.head.right.left.value);
//		System.out.println("HEAD RIGHT RIGHT : " + bt.head.right.right.value);
//		
//		MyHeap heapTest = new MyHeap(15);
//		heapTest.insert(10);
//		heapTest.insert(8);
//		heapTest.insert(5);
//		heapTest.insert(4);
//		heapTest.insert(20);
//		System.out.println(heapTest.heapArray);
//		heapTest.pop();
//		System.out.println(heapTest.heapArray);
		
		ArrayList<Integer> dataList = new ArrayList<Integer>();
//		dataList.add(10);
//		dataList.add(44);
//		dataList.add(9);
//		dataList.add(55);
//		dataList.add(7);
//		dataList.add(82);
		
		for(int i=0;i<100;i++) {
			dataList.add((int)(Math.random()*100));
		}
//		
//		BubbleSort bsort = new BubbleSort();
//		bsort.sort(dataList);
		
//		SelectionSort ssort = new SelectionSort();
//		ssort.sort(dataList);
		
//		InsertionSort isort = new InsertionSort();
//		isort.sort(dataList);
		
//		System.out.println(dataList);
//		
//		Fibonachi fibo = new Fibonachi();
//		System.out.println(fibo.fibo(10));
//		
//		Dynamic dy = new Dynamic();
//		System.out.println(dy.dynamic(10));
		
		MergeSort ms = new MergeSort();
		System.out.println(ms.split(dataList));
	}
}

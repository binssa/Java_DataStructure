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
		
		BinaryTree bt = new BinaryTree();
		bt.insertNode(5);
		bt.insertNode(3);
		bt.insertNode(1);
		bt.insertNode(4);
		bt.insertNode(7);
		bt.insertNode(9);
		
		Node test = bt.search(7);
		System.out.println(test.value);
	}
}

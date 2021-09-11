package com.benworld.datastructure;

class Node{
	Node left;
	Node right;
	int value;
	public Node(int value) {
		this.value=value;
		this.right=null;
		this.left=null;
	}
}
public class BinaryTree {
	Node head = null; 
	

	
	public boolean insertNode(int value) {
		// Case 1 : Data가 없을 때
		if(this.head == null) {
			this.head = new Node(value);
		}else {
			// Case 2 : Node가 하나 이상 들어가 있을 때
			Node findNode = this.head;
			while(true) {
				// Case 2-1 : Node의 왼쪽에 들어가야할 때
				if(value < findNode.value) {
					if(findNode.left != null) {
						findNode = findNode.left;
					}else {
						findNode.left = new Node(value);
						break;
					}
				}
				// Case 2-2 : Node의 오른쪽에 들어가야할 때
				else {
					if(findNode.right != null) {
						findNode = findNode.right;
					}else {
						findNode.right = new Node(value);
						break;
					}
				}
			}
		}
		return true;
	}
	
	public Node search(int value) {
		// Case 1 : Node가 하나도 없을 때
		if(this.head == null) {
			return null;
		}
		// Case 2 : Node가 하나 이상 있을 때 
		else {
			Node findNode = this.head; // Root 노드
			while(findNode != null) {
				if(findNode.value == value) {
					return findNode;
				}else if(value < findNode.value) { // 값이 작을 경우
					findNode = findNode.left;
				}else { // 값이 클 경우
					findNode = findNode.right;
				}
			}
			return null;
		}
	}
	
	// 삭제
	public boolean deleteNode(int value) {
		boolean searched = false;
		
		Node curParentNode = this.head;
		Node curNode = this.head;
		// 트리에 값이 없을 때
		if(this.head == null) {
			return false;
		}else {
			// 트리에 값이 하나 있을 때 
			if(this.head.value == value && this.head.left == null & this.head.right==null) {
				this.head = null;
				return true;
			}
			// 트리의 값이 두개 이상일 때 
			while(curNode != null) {
				// 현재 노드와 값이 같을 때
				if(curNode.value == value) {
					searched = true;
					break;
				}
				// 현재 노드보다 값이 클 때
				else if(curNode.value < value) {
					curParentNode = curNode;
					curNode = curNode.right;
				}
				// 현재 노드보다 값이 작을 때
				else {
					curParentNode = curNode;
					curNode = curNode.left;
				}
			}
			// 검색이 안되었을 때 
			if(searched == false) {
				return false;
			}
		}
	// Case 1 : Leaf 노드일 경우
	if(curNode.left == null && curNode.right == null) {
		if(curNode.value > value) {
			curParentNode.left = null;
			curNode = null;
		}else {
			curParentNode.right = null;
			curNode = null;
		}
		return true;
	}
	// Case 2 : Child Node가 하나일 경우
	// Case 2-1 : Child Node가 오른쪽에만 있을 경우
	else if(curNode.left == null && curNode.right != null) {
		if(value < curParentNode.value) {
			curParentNode.left = curNode.right;
			curNode = null;
		}else {
			curParentNode.right = curNode.right;
			curNode = null;
		}
		curParentNode.right = curNode.right;
		return true;
	}
	// Case 2-2 : Child Node가 왼쪽에만 있을 경우 
	else if(curNode.right == null && curNode.left != null) {
		if(value < curParentNode.value) {
			curParentNode.left = curNode.left;
			curNode = null;
		}else {
			curParentNode.right = curNode.left;
			curNode = null;
		}
		return true;
	}
	// Case 3 : Child Node가 두개일 경우
	else {
		// Case 3-1 : 삭제할 노드가 Parent Node의 왼쪽에 있을 때 
		if(value < curParentNode.value) {
			Node changeNode = curNode.right;
			Node changeParentNode = curNode.right;
			
			while(changeNode.left != null) {
				changeParentNode = changeNode;
				changeNode = changeNode.left;
			}
			// While문 끝나면, changeNode에 삭제할 Node의 오른 쪽 Node 중 가장 작은 값을 가진 Node가 들어감.
			// Case 3-1-1 : changeNode의 child Node가 없을 때
			if(changeNode.right == null) {
				changeParentNode.left = null;
			}
			// Case 3-1-2 : changeNode의 child Node가 있을 때
			else {
				changeParentNode.left = changeNode.right;
			}
			// curParentNode의 왼쪽에 검색한 가장 작은 값이 들어감.
			curParentNode.left = changeNode;
			changeNode.right = curNode.right;
			changeNode.left = curNode.left;
			
			curNode = null;
		}
		// Case 3-2 : 삭제할 노드가 Parent Node의 오른쪽에 있을 때
		else {
			Node changeNode = curNode.right;
			Node changeParentNode = curNode.right;
			// 가장 작은 값을 찾기 위한 순회
			while(changeNode.left != null) {
				changeParentNode = changeNode;
				changeNode = changeNode.left;
			}
			// Case 3-2-1 : changeNode의 child Node가 없을 때
			if(changeNode.right == null) {
				changeParentNode.left = null;
			}
			// Case 3-2-2 : changeNode의 child Node가 있을 때
			else {
				changeParentNode.left = changeNode.right;
			}
			
			curParentNode.right = changeNode;
			
			changeNode.left = curNode.left;
			changeNode.right = curNode.right;
			
			curNode = null;
		}
	}
	return true;// 수정 필요
	}
}

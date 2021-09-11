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
		// Case 1 : Data�� ���� ��
		if(this.head == null) {
			this.head = new Node(value);
		}else {
			// Case 2 : Node�� �ϳ� �̻� �� ���� ��
			Node findNode = this.head;
			while(true) {
				// Case 2-1 : Node�� ���ʿ� ������ ��
				if(value < findNode.value) {
					if(findNode.left != null) {
						findNode = findNode.left;
					}else {
						findNode.left = new Node(value);
						break;
					}
				}
				// Case 2-2 : Node�� �����ʿ� ������ ��
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
		// Case 1 : Node�� �ϳ��� ���� ��
		if(this.head == null) {
			return null;
		}
		// Case 2 : Node�� �ϳ� �̻� ���� �� 
		else {
			Node findNode = this.head; // Root ���
			while(findNode != null) {
				if(findNode.value == value) {
					return findNode;
				}else if(value < findNode.value) { // ���� ���� ���
					findNode = findNode.left;
				}else { // ���� Ŭ ���
					findNode = findNode.right;
				}
			}
			return null;
		}
	}
	
	// ����
	public boolean deleteNode(int value) {
		boolean searched = false;
		
		Node curParentNode = this.head;
		Node curNode = this.head;
		// Ʈ���� ���� ���� ��
		if(this.head == null) {
			return false;
		}else {
			// Ʈ���� ���� �ϳ� ���� �� 
			if(this.head.value == value && this.head.left == null & this.head.right==null) {
				this.head = null;
				return true;
			}
			// Ʈ���� ���� �ΰ� �̻��� �� 
			while(curNode != null) {
				// ���� ���� ���� ���� ��
				if(curNode.value == value) {
					searched = true;
					break;
				}
				// ���� ��庸�� ���� Ŭ ��
				else if(curNode.value < value) {
					curParentNode = curNode;
					curNode = curNode.right;
				}
				// ���� ��庸�� ���� ���� ��
				else {
					curParentNode = curNode;
					curNode = curNode.left;
				}
			}
			// �˻��� �ȵǾ��� �� 
			if(searched == false) {
				return false;
			}
		}
	// Case 1 : Leaf ����� ���
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
	// Case 2 : Child Node�� �ϳ��� ���
	// Case 2-1 : Child Node�� �����ʿ��� ���� ���
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
	// Case 2-2 : Child Node�� ���ʿ��� ���� ��� 
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
	// Case 3 : Child Node�� �ΰ��� ���
	else {
		// Case 3-1 : ������ ��尡 Parent Node�� ���ʿ� ���� �� 
		if(value < curParentNode.value) {
			Node changeNode = curNode.right;
			Node changeParentNode = curNode.right;
			
			while(changeNode.left != null) {
				changeParentNode = changeNode;
				changeNode = changeNode.left;
			}
			// While�� ������, changeNode�� ������ Node�� ���� �� Node �� ���� ���� ���� ���� Node�� ��.
			// Case 3-1-1 : changeNode�� child Node�� ���� ��
			if(changeNode.right == null) {
				changeParentNode.left = null;
			}
			// Case 3-1-2 : changeNode�� child Node�� ���� ��
			else {
				changeParentNode.left = changeNode.right;
			}
			// curParentNode�� ���ʿ� �˻��� ���� ���� ���� ��.
			curParentNode.left = changeNode;
			changeNode.right = curNode.right;
			changeNode.left = curNode.left;
			
			curNode = null;
		}
		// Case 3-2 : ������ ��尡 Parent Node�� �����ʿ� ���� ��
		else {
			Node changeNode = curNode.right;
			Node changeParentNode = curNode.right;
			// ���� ���� ���� ã�� ���� ��ȸ
			while(changeNode.left != null) {
				changeParentNode = changeNode;
				changeNode = changeNode.left;
			}
			// Case 3-2-1 : changeNode�� child Node�� ���� ��
			if(changeNode.right == null) {
				changeParentNode.left = null;
			}
			// Case 3-2-2 : changeNode�� child Node�� ���� ��
			else {
				changeParentNode.left = changeNode.right;
			}
			
			curParentNode.right = changeNode;
			
			changeNode.left = curNode.left;
			changeNode.right = curNode.right;
			
			curNode = null;
		}
	}
	return true;// ���� �ʿ�
	}
}

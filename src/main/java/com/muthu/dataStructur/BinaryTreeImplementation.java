package com.muthu.dataStructur;

public class BinaryTreeImplementation<T extends Integer> {

	private Node root;
	public void display() {
		display(root);
	}
	private class Node{
		int value;
		Node right;
		Node left;
		int level;
		int height;
	}
	public int getValue(Node node) {
		return node.value;
	}
	public int getLevel(Node node) {
		return node.level;
	}
	public int getbreathHeight(Node node) {
		if(node == null) {
			return 0;
		}
		return node.height;
	}
	public Node getValue(int value) {
		Node temp = root;
		if(root.value == value) {
			return root;
		}
		while(temp != null) {
			if(temp.value == value) {
				return temp;
			}
			else if(temp.value > value) {
				temp = temp.left;
			}
			else if(temp.value < value) {
				temp = temp.right;
			}
		}
		return new Node();
	}
	public void removeNode(int value) {
		if(root.value == value) {
			root = null;
			System.out.println("No root available pls add");
			return;
		}
		Node temp = root;
		while(temp != null) {
			if(temp.right != null && temp.right.value == value) {
				temp.right = null;
				return;
			}
			else if(temp.left != null && temp.left.value == value) {
				temp.left = null;
				return;
			}
			else if(temp.value < value) {
				temp = temp.right;
			}
			else if(temp.value > value) {
				temp = temp.left;
			}
		}
	}
	public void display(Node node) {
		if(node == null) {
			return;
		}
		display(node.right);
		for(int i = 0;i < node.level;i++) {
			System.out.print("\t\t");
		}
		System.out.print("-->"+node.value);
		System.out.println();
		display(node.left);	
	}
	
	private int setHeight(Node node) {
		if(node == null) {
			return 0;
		}
		int leftHeight = setHeight(node.left);
		int rightHeight = setHeight(node.right);
		if(node.left != null || node.right != null) {
			node.height = Math.max(leftHeight,rightHeight)+1;
		}
		return node.height;
	}
	public void insertValues(int value) {
		insertValue(value);
		setHeight(root);
	}
	private void insertValue(int value) {
		if(root == null) {
			root = new Node();
			root.value = value;
			root.level = 0;
			return;
		}
		Node temp = root;
		while(temp != null) {
			if(temp.value < value) {
				if(temp.right == null) {
					temp.right = new Node();
					temp.right.value = value;
					temp.right.level = temp.level + 1;
					return;
				}
				else {
					temp = temp.right;
				}
			}
			else if(temp.value > value) {
				if(temp.left == null) {
					temp.left = new Node();
					temp.left.value = value;
					temp.left.level = temp.level + 1;
					return;
				}
				else {
					temp = temp.left;
				}
			}
		}
		
	}
	public boolean checkBalancedTree() {
		return checkBalancedTree(root);
	}
	
	public void postOrderTraversal() {
		postOrderTraversal(root);
		System.out.println();
	}
	
	private void postOrderTraversal(Node root) {
		if(root == null) {
			return;
		}
		postOrderTraversal(root.left);
		postOrderTraversal(root.right);
		System.out.print(root.value);
		
		
	}
	
	public void preOrderTraversal() {
		preOrderTraversal(root);
		System.out.println();
	}
	
	public void inOrderTraversal() {
		inOrderTraversal(root);
		System.out.println();
	}
	
	private void inOrderTraversal(Node root) {
		if(root == null) {
			return;
		}
		inOrderTraversal(root.left);
		System.out.print(root.value);
		inOrderTraversal(root.right);
	}
	
	private void preOrderTraversal(Node root) {
		if(root == null) {
			return;
		}
		System.out.print(root.value);
		preOrderTraversal(root.left);
		preOrderTraversal(root.right);
	}
	
	private boolean checkBalancedTree(Node node) {
		if(node == null) {
			return true;
		}
		
		return (Math.abs(getbreathHeight(node.left) - getbreathHeight(node.right)) <= 1) && checkBalancedTree(node.left) && checkBalancedTree(node.right);
	}
}

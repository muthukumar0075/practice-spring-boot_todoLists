package com.muthu.dataStructur;

public class AVLTreeImplementation<T extends Integer> {
	private Node root;
	private class Node{
		int value;
		Node right;
		Node left;
		int height;
	}
	public void display() {
		display(root,0);
	}
	private void display(Node node,int level) {
		if(node == null) {
			return;
		}
		display(node.right,level + 1);
		for(int i = 0;i < level;i++) {
			System.out.print("\t\t");
		}
		System.out.print("-->"+node.value);
		System.out.println();
		display(node.left,level + 1);	
	}
	
	public void insertValue(int value) {
		if(root == null) {
			root = new Node();
			root.value = value;
			return;
		}
		insert(root, value);
	}
	
	private Node insert(Node node,int value) {
		if(node == null) {
			node = new Node();
			node.value = value;
			return node;
		}
		if(value < node.value) {
			node.left = insert(node.left,value);
		}
		if(value > node.value) {
			node.right = insert(node.right,value);
		}
		node.height = Math.max(getbreathHeight(node.left), getbreathHeight(node.right)) + 1;
		return AVLBalance(node);
		
		
	}
	
	private Node AVLBalance(Node node) {
		//checking for leftHeavy
		if(getbreathHeight(node.left) - getbreathHeight(node.right) > 1) {
			//left left
			if(getbreathHeight(node.left.left) - getbreathHeight(node.left.right) > 0) {
				return rightRotate(node);
			}
			//left right
			if(getbreathHeight(node.left.left) - getbreathHeight(node.left.right) < 0) {
				node.left = leftRotate(node.left);
				return rightRotate(node);
			}
		}
		// checking for rightHeavy
		if(getbreathHeight(node.left) - getbreathHeight(node.right) < -1) {
			//right right
			if(getbreathHeight(node.right.left) - getbreathHeight(node.right.right) < 0) {
				return leftRotate(node);
			}
			// right left
			if(getbreathHeight(node.right.right) - getbreathHeight(node.right.left) > 0) {
				node.right = rightRotate(node.right);
				return leftRotate(node);
			}	
		}
		return node;
	}
	
	private Node leftRotate(Node node) {
		Node g = node.right;
		Node t2 = g.left;
		
		g.left = node;
		node.right = t2;
		node.height = Math.max(getbreathHeight(node.left), getbreathHeight(node.right)) + 1;
		g.height = Math.max(getbreathHeight(g.left),getbreathHeight(g.right))+1;
		if(node == root) {
			root = g;
		}
		return g;
	}
	private Node rightRotate(Node node) {
		Node c = node.left;
		Node t3 = c.right;
		
		c.right = node;
		node.left = t3;
		node.height = Math.max(getbreathHeight(node.left),getbreathHeight(node.right)) + 1;
		c.height = Math.max(getbreathHeight(c.left), getbreathHeight(c.right)) + 1;
		if(node == root) {
			root = c;
		}
		return c;
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
	public boolean checkBalancedTree() {
		return checkBalancedTree(root);
	}

	private boolean checkBalancedTree(Node node) {
		if(node == null) {
			return true;
		}
		return (Math.abs(getbreathHeight(node.left) - getbreathHeight(node.right)) <= 1) && checkBalancedTree(node.left) && checkBalancedTree(node.right);
	}
	public int getbreathHeight(Node node) {
		if(node == null) {
			return 0;
		}
		return node.height;
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

}

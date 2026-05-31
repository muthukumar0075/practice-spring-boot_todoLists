package com.muthu.dataStructur;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreeTestData {
	private Node root;
	class Node{
		private int value;
		private Node left;
		private Node right;
		
		Node(int value){
			this.value = value;
		}
	}
	
	public void createTestDataForBST(int value) {
		if(root == null) {
			root = new Node(value);
		}
		addDataAndSorted(value,root);
	}
	
	private Node addDataAndSorted(int value, Node root) {
		if(root == null) {
			root = new Node(value);
			return root;
		}
		if(root.value < value) {
			root.right = addDataAndSorted(value,root.right);
		}
		if(root.value > value) {
			root.left = addDataAndSorted(value,root.left);
		}
		return root;
		
	}
	
	public void print() {
		print(root);
	}
	
	public Node getRoot() {
		return root;
	}
	
	private void print(Node root) {
		if(root == null) {
			return;
		}
		print(root.left);
		System.out.println(root.value);
		print(root.right);
	}
	
	public List<Integer> getDataInList(){
		List<Integer> lst = new ArrayList<>();
		getBSTInList(lst,root);
		return lst;
	}
	
	private void getBSTInList(List<Integer> lst,Node root) {
		if(root == null) {
			return;
		}
		
		getBSTInList(lst,root.left);
		lst.add(root.value);
		getBSTInList(lst,root.right);
	}
	
	public void fndTheSwappedElement(Node node) {
		Node firstPrev = null;
		Node secondPrev = null;
		findTheNodes(node,firstPrev,secondPrev,false);
	}
	public void findTheNodes(Node node,Node firstPrev,Node secondPrev,boolean leftMove) {
		if(node == null) {
			return;
		}
		if(leftMove && node.left != null && node.value < node.left.value) {
			if(firstPrev == null) {
				firstPrev = node.left;
			}
			else {
				secondPrev = node.left;
			}
		}
		else if((!leftMove) && node.right != null && node.value > node.right.value) {
			if(firstPrev == null) {
				firstPrev = node.right;
			}
			else {
				secondPrev = node.right;
			}
		}
		findTheNodes(node.left, firstPrev, secondPrev,true);
		findTheNodes(node.right, firstPrev, secondPrev,false);
	}
	public void swapp(Node node,Node firstPrev,Node secondPrev) {
		if(node == null) {
			return;
		}
		
		if(node.left != null && node.left == firstPrev) {
			Node temp = firstPrev;
			Node tempLeft = temp.left;
			Node tempRight = temp.right;
			firstPrev.left = secondPrev.left;
			firstPrev.right = secondPrev.right;
			secondPrev.left = tempLeft;
			secondPrev.right = tempRight;
			node.left = secondPrev;
		}
		else if(node.right != null && node.right == firstPrev) {
			Node temp = firstPrev;
			Node tempLeft = temp.left;
			Node tempRight = temp.right;
			firstPrev.left = secondPrev.left;
			firstPrev.right = secondPrev.right;
			secondPrev.left = tempLeft;
			secondPrev.right = tempRight;
			node.right = secondPrev;
		}
		else if(node.left != null && node.left == secondPrev) {
			node.left = firstPrev;
		}
		else if(node.right != null && node.right == secondPrev) {
			node.right = firstPrev;
		}
		swapp(node.left, firstPrev, secondPrev);
		swapp(node.right, firstPrev, secondPrev);
	}
	

}

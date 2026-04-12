package com.muthu.dataStructur;

import java.io.InputStream;
import java.util.Scanner;

public class Binarytree<T> {
	private  Node root;
	protected class Node{
		Object value;
		Node right;
		Node left;
	}
	
	public Node getNode() {
		return root;
	}
	
	public void populate(Scanner scan) {
		root = new Node();
		System.out.println("value?");
		Object value = scan.nextInt();
		root.value = value;
		populateValue(scan,root);
	}
	
	private void populateValue(Scanner scan,Node node) {
		System.out.println("Need left y/n");
		String flag = scan.next();
		if(flag.equals("y")) {
			node.left = new Node();
			System.out.println("root " + node.value +"left value?");
			int value = scan.nextInt();
			node.left.value = value;
			populateValue(scan, node.left);
		}
		System.out.println("Need right  y/n");
		String flagRight = scan.next();
		if(flagRight.equals("y")) {
			node.right = new Node();
			System.out.println("root " + node.value +"right value?");
			int value = scan.nextInt();
			node.right.value = value;
			populateValue(scan, node.right);
		}
	}
	
	public void result(Node node) {
		if(node != null) {
			System.out.print(node.value);
			if(node.left != null) {
				result(node.left);
			}
			if(node.right != null) {
				result(node.right);
			}
		}
	}
	
	public static void main(String args[]) {
		Binarytree<Integer> binaryTree = new Binarytree<>();
		Scanner scan = new Scanner(System.in);
		binaryTree.populate(scan);
		binaryTree.result(binaryTree.root);
		
	}
	

}

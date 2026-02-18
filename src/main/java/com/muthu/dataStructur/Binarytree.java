package com.muthu.dataStructur;

import java.io.InputStream;
import java.util.Scanner;

public class Binarytree<T> {
	private Node root;
	private class Node{
		Object value;
		Node right;
		Node left;
	}
	
	public void populate(Scanner scan) {
		root = new Node();
		System.out.println("value?");
		Object value = scan.nextInt();
		root.value = value;
		populateValue(scan,root);
	}
	
	private void populateValue(Scanner scan,Node node) {
		System.out.println("Need left");
		boolean flag = scan.nextBoolean();
		if(flag) {
			node.left = new Node();
			System.out.println("value?");
			int value = scan.nextInt();
			node.left.value = value;
			populateValue(scan, node.left);
		}
		System.out.println("Need right");
		boolean flagRight = scan.nextBoolean();
		if(flagRight) {
			node.right = new Node();
			System.out.println("value?");
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

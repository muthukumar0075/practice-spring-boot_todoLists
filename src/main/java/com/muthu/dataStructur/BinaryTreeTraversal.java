package com.muthu.dataStructur;

public class BinaryTreeTraversal<T> extends Binarytree<T> {

	public void inorderTraversal(Node node) {
		if(node == null) {
			return;
		}
		
		inorderTraversal(node.left);
		System.out.print(node.value +"-->");
		inorderTraversal(node.right);
	}
	
	public void preOrderTraversal(Node node) {
		if(node == null) {
			return;
		}
		System.out.print(node.value +"-->");
		inorderTraversal(node.left);
		inorderTraversal(node.right);
		
	}
	
	public void postOrderTraversal(Node node) {
		if(node == null) {
			return;
		}
		
		inorderTraversal(node.left);
		inorderTraversal(node.right);
		System.out.print(node.value +"-->");
	}
}

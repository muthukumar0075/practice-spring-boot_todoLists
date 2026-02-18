package com.muthu.dataStructur;


public class SegmentTreeImplementation{
	private Node root;
	private class Node{
		int data;
		int startRange;
		int endRange;
		Node left;
		Node right;
		
		public Node(int startRange,int endRange) {
			this.startRange = startRange;
			this.endRange = endRange;
		}
	}
	public void segmentTree(int[] arr) {
		root = contructTree(arr, 0, arr.length - 1);
	}
	
	public void updateValueOfTree(int value,int index) {
		updateTheTree(value,index,root);
	}
	
	private Node updateTheTree(int data,int index,Node node) {
		if(node.startRange == index && node.endRange == index) {
			node.data = data;
			return node;
		}
		if(node.startRange <= index && node.endRange >= index) {
			node.left = updateTheTree(data, index, node.left);
			node.right = updateTheTree(data, index, node.right);
			node.data = node.left.data + node.right.data;
		}
		return node;
	}
	
	private Node contructTree(int[] arr,int start,int end) {
		if(start == end) {
			Node leavenode = new Node(start, end);
			leavenode.data = arr[start];
			return leavenode;
		}
		int mid = (start + end)/2;
		Node node = new Node(start, end);
		node.left = contructTree(arr, start, mid);
		node.right = contructTree(arr, mid + 1, end);
		node.data = node.left.data + node.right.data;
		
		return node;
		
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
		System.out.print("-->"+node.data);
		System.out.println();
		display(node.left,level + 1);	
	}

}

package com.muthu.dataStructur;

import java.util.Stack;

public class DepthFirstInLoop<T> extends Binarytree<T> {
	
	public void helperForLoop(Node node) {
		Stack<Node> container = new Stack<>();
		container.push(node);
		while(!container.isEmpty()) {
			Node nodeValue = container.pop();
			System.out.print(nodeValue.value +" -->");
			if(nodeValue.right != null) {
				container.push(nodeValue.right);
			}
			if(nodeValue.left != null) {
				container.push(nodeValue.left);
			}
		}
	}
}

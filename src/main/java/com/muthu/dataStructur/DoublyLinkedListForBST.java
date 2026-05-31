package com.muthu.dataStructur;

public class DoublyLinkedListForBST {
	private Node head;
	private Node tail;
	private int size;
	class Node{
		private int value;
		private Node next;
		private Node prev;
		
		Node(int value){
			this.value = value;
		}
	}
	
	public void addValue(int value) {
		if(this.head == null) {
			head = new Node(value);
			tail = head;
			this.size++;
			return;
		}
		Node tempTail = getTail();
		if(tail == head) {
			tail = new Node(value);
			head.next = tail;
			tail.prev = head;
			this.size++;
			return;
		}
		tempTail.next = new Node(value);
		tempTail.next.prev = tail;
		tail = tempTail.next;
		size++;
	}
	
	private Node getTail() {
		return tail;
	}
	
	public Node getHead() {
		return head;
	}
	
	public void display() {
		Node temp = head;
		while(temp != null) {
			System.out.print(temp.value + "Start");
			System.out.print(temp.next == null ? null : temp.next.value + "Next");
			System.out.print(temp.prev == null ? null : temp.prev.value + "Prev");
			temp = temp.next;
			System.out.println();
		}
	}
	
	

}

package com.muthu.dataStructur;

public class MuthuCircularListedList<T> {
	private MuthuNode head;
	private MuthuNode tail;
	private int size;

	class MuthuNode{
		private Object value;
		private MuthuNode next;
		
		private MuthuNode(T value) {
			this.value = value;
		}
	}
	
	public void addFirst(T value) {
		MuthuNode node = new MuthuNode(value);
		if(head == null) {
			node.next = head;
			head = node;
			tail = head;
			tail.next = head;
			size +=1;
		}
		else {
			node.next = head;
			head = node;
			tail.next = head;
			size +=1;
		}
	}
	
	public void addAtIndex(T value ,int index) {
		if(index == 0) {
			addFirst(value);
		}
		else if(index == size) {
			addLast(value);
		}
		else if(index >= 0 && index < size) {
			MuthuNode prevNode = get(index - 2);
			MuthuNode node = new MuthuNode(value);
			node.next = prevNode.next;
			prevNode.next = node;
			size +=1;
		}
	}
	
	public void addLast(T value){
		MuthuNode node = new MuthuNode(value);
		if(tail == null) {
			addFirst(value);
		}
		else {
			tail.next = node;
			node.next = head;
			tail = node;
			size +=1;
		}
	}
	
	public MuthuNode get(int index){
		MuthuNode temp = head;
		for(int i = 0;i <= index;i++) {
			temp = temp.next;
		}
		return temp;
	}
	
	public T removeFirst() {
		T value = (T) head.value;
		tail.next = head.next;
		head = head.next;
		size -=1;
		return value;
	}
	
	public T removeLast() {
		T value = (T) tail.value;
		MuthuNode prevLast = get(size - 2);
		prevLast.next = head;
		tail = prevLast;
		size -=1;
		return value;
	}
	
	public void show() {
		MuthuNode temp = head;
		for(int i = 0;i < size;i++) {
			System.out.print(temp.value+" --> ");
			temp = temp.next;
		}
		System.out.println("END");
	}
}

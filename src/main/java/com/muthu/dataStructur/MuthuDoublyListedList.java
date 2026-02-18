package com.muthu.dataStructur;


public class MuthuDoublyListedList<T> {
	private MuthuNode head;
	private MuthuNode tail;
	private int size;
	class MuthuNode{
		private Object value;
		private MuthuNode prev;
		private MuthuNode next;
		
		public MuthuNode(T value) {
			this.value = value;
		}
	}
	
	public void addStart(T value) {
		MuthuNode node = new MuthuNode(value);
		if(head == null) {
			node.next = head;
			node.prev = null;
			head = node;
			tail = head;
		}
		else {
			node.next = head;
			head.prev = node;
			head = node;
			node.prev=null;
		}
		size +=1;
	}
	public void addAtIndex(int index,T value) {
		if(index == 0) {
			addStart(value);
		}
		else if(index == size -1 || index == size) {
			addLast(value);
		}
		else {
			MuthuNode temp = get(index);
			MuthuNode node = new MuthuNode(value);
			node.next = temp;
			node.prev = temp.prev;
			temp.prev.next = node;
			size +=1;
		}
		
	}
	public MuthuNode get(int index) {
		if(index == 0) {
			return head;
		}
		else if(index == size -1) {
			return tail;
		}
		else if(index < size && index >= 0) {
			MuthuNode temp = head;
			int count = 0;
			while(count != index) {
				temp = temp.next;
				count +=1;
			}
			return temp;
		}
		else {
			throw new IndexOutOfBoundsException(index);
		}
	}
	
	public int getFirst() {
		return (int) head.value;
	}
	
	public int getLast() {
		return (int)tail.value;
	}
	
	public void addLast(T value) {
		if(tail == null) {
			addStart(value);
		}
		else {
			MuthuNode node = new MuthuNode(value);
			tail.next = node;
			node.prev = tail;
			tail = node;
			size +=1;
		}
	}
	
	public int size() {
		return size;
	}
	
	public String toString() {
		if(size==0) {
			return"{}";
		}
		String value = "{";
		MuthuNode temp;
		temp = head;
		while(temp != null) {
			value += temp.value+",";
			temp = temp.next;
		}
		value = value.substring(0, value.length()-1);
		value +="}";
		return value;
		
	}
	

}

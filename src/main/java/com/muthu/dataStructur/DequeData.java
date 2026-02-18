package com.muthu.dataStructur;

import java.util.LinkedList;

import com.muthu.dataStructur.MuthuListedList.MuthuNode;

public class DequeData<E>{
	Node head;
	Node tail;
	int size = 0;
	private class Node<E>{
		E value;
		Node next;
		
		private Node(E value,Node next){
			this.value = value;
			this.next = next;
		}
	}
	
	public void addFirst(E value){
		Node node = null;
		if(head == null) {
			node = new Node(value, null);
			head = node;
			tail = head;
		}
		else {
			node = new Node(value, head);
			head = node;
		}
		size++;
	}
	
	public void addLast(E value) {
		Node node = null;
		if(tail == null) {
			addFirst(value);
		}
		else {
			node = new Node(value,null);
			tail.next = node;
			tail = node;
			size++;
		}
	}
	
	public E removeFirst() {
		E value = (E) head.value;
		head = head.next;
		size--;
		return value;
	}
	
	public E removeLast() {
		E value = (E) tail.value;
		Node prevLast = getPreLast();
		prevLast.next = null;
		tail = prevLast;
		size--;
		return value;
	}
	
	public E getFirst() {
		return (E) head.value;
	}
	
	public E getLast() {
		return (E) tail.value;
	}
	
	public Node getPreLast() {
		Node prevLast = head;
		for(int i = 1;i < size - 1;i++){
			prevLast = prevLast.next;
		}
		return prevLast;
	}
	
	public String toDisplay(Node head) {
		if(head == null) {
			return"{}";
		}
		String value = "{";
		Node temp;
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

package com.muthu.dataStructur;

import com.muthu.dataStructur.MuthuListedList.MuthuNode;

public class MuthuListedList<T> {
	private MuthuNode head;
	private MuthuNode tail;
	private int size;
	
	class MuthuNode{
		private MuthuNode next;
		private Object value;
		
		MuthuNode(T value){
			this.value = value;
		}

		public MuthuNode() {
			// TODO Auto-generated constructor stub
		}
		
	}
	public void addFirst(T value) {
		MuthuNode node = new MuthuNode(value);
		node.next = head;
		head = node;
		if(tail == null) {
			tail = head;
		}
		size+=1;
	}
	
	public void addLast(T value) {
		MuthuNode node = new MuthuNode(value);
		if(tail != null) {
			tail.next = node;
			tail = node;
			size+=1;
		}
		else {
			addFirst(value);
		}
		
		
	}
	
	public int getFirstValue() {
		return (int) head.value;
	}
	
	public int getLastValue() {
		return (int) tail.value;
	}
	
	public int getSize() {
		return size;
	}
	
	public void addAtIndex(int index,T value) {
		if(!(index >=0 && index < size)) {
			throw new IndexOutOfBoundsException(index);
		}
		if(index == 0) {
			addFirst(value);
		}
		else if(index == (size-1)) {
			addLast(value);
		}
		else {
			int count = 0;
			MuthuNode temp = head;
			while(temp != null && count != (index-1)) {
				temp = temp.next;
				count+=1;
			}
			MuthuNode node = new MuthuNode(value);
			node.next = temp.next;
			temp.next = node;
			size+=1;
		}
	}
	
	public T removeFirst() {
		T val = (T) head.value;
		head = head.next;
		if(head== null) {
			tail=null;
		}
		size-=1;
		return val;
	}
	
	public T removeLast() {
		T val = (T) head.value;
		MuthuNode temp;
		if(size >=2) {
			temp = get(size - 2);
			tail = temp;
			tail.next = null;
			size-=1;
		}
		else {
			removeFirst();
		}
		return val;
	}
	
	public int removeAtIndex(int index) {
		if(!(index >=0 && index < size)) {
			throw new IndexOutOfBoundsException(index);
		}
		if(index == 0) {
			return (int) removeFirst();
		}
		else if(index == size -1) {
			return (int) removeLast();
		}
		else {
			MuthuNode previousTemp = get(index - 1);
			int value = (int) previousTemp.next.value;
			previousTemp.next = previousTemp.next.next;
			size-=1;
			return value;
		}
	}
	
	public MuthuNode get(int index) {
		if(index == 0) {
			return head;
		}
		else if(index == (size-1)) {
			return tail;
		}
		else {
			int count = 0;
			MuthuNode temp = head;
			while(temp != null && count != index) {
				temp = temp.next;
				count +=1;
			}
			return temp;
		}
		
		
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
	
	public void indexUsingRecursion(int index,T value,MuthuNode temp,int count) {
		if(temp == null && index == 0) {
			MuthuNode node = new MuthuNode(value);
			head = node;
			tail = node;
			size += 1;
			return;
		}
		else if(index == count) {
			MuthuNode node = new MuthuNode(value);
			if(count == size) {
				tail.next = node;
				tail = node;
			}
			else {
				node.next = temp.next;
				temp.next = node;
			}
			size += 1;
			return;
		}
		indexUsingRecursion(index, value, temp.next,count+1);
	}
	
	public MuthuNode getHead() {
		return head;
	}
	
	public MuthuNode deleteDuplicates(MuthuNode head) {
        if(head == null){
            return head;
        }
        if(head.next == null){
            return head;
        }
        MuthuNode p1 = head;
        MuthuNode p2 = p1.next;
        while(p1 != null){
            if(p1.value == p2.value){
                if(p2.next == null){
                    p1.next = null;
                    tail=p1;
                    size -=1;
                    break;
                }
                else{
                    p2 = p2.next;
                    size -=1;
                }
                
            }
            else{
                p1.next = p2;
                p1 = p2;
                if(p2.next != null){
                    p2 = p2.next;
                }
                else if(p2.next == null){
                    break;
                }
                
            }
        }
        
        return head;  
    }
	
	 public MuthuNode sortList(MuthuNode head) {
	        if(head.next == null){
	            return head;
	        }
	        MuthuNode temp = head;
	        MuthuNode mid = findMid(temp);
	        MuthuNode firstHalf = sortList(getFirstHalf(temp,mid));
	        MuthuNode secondHalf = sortList(getSecondHalf(mid));
	        return merge(firstHalf,secondHalf);
	        
	    }
	 MuthuNode findMid(MuthuNode temp){
	        if(temp == null){
	            return null;
	        }
	        MuthuNode node = new MuthuNode();
	        MuthuNode fastP = temp;
	        MuthuNode slowP = temp;
	        while(fastP != null && fastP.next != null){
	            slowP = slowP.next;
	            fastP = fastP.next.next;
	        }
	        return slowP; 
	    }
	 MuthuNode getFirstHalf(MuthuNode head,MuthuNode mid){
		 MuthuNode tempHead = new MuthuNode((T) head.value);
		 MuthuNode temp = tempHead;
	        while(head.next!= null && head.next.value != mid.value){
	            temp.next = new MuthuNode((T) head.next.value);
	            head = head.next;
	            temp = temp.next;
	            
	        }
	        return tempHead;
	    }
	 MuthuNode getSecondHalf(MuthuNode head){
		 MuthuNode tempHead = new MuthuNode((T) head.value);
		 MuthuNode temp = tempHead;
	        while(head.next!= null){
	            temp.next = new MuthuNode((T) head.next.value);
	            head = head.next;
	            temp = temp.next;
	        }
	        return tempHead;
	    }

	 MuthuNode merge(MuthuNode first,MuthuNode second){
		 MuthuNode i = first;
		 MuthuNode j = second;
		 MuthuNode nodeHead = new MuthuNode();
		 MuthuNode node = nodeHead;
	        while(i != null && j != null){
	            if((int)i.value < (int)j.value){
	                node.next = new MuthuNode((T) i.value);
	                node = node.next;
	                i = i.next;
	            }
	            else if((int)j.value < (int)i.value){
	                node.next = new MuthuNode((T) j.value);
	                node = node.next;
	                j = j.next;
	            }
	        }

	        while(i != null){
	            node.next = new MuthuNode((T) i.value);
	            i = i.next;
	            node = node.next;
	        }
	        while(j != null){
	            node.next = new MuthuNode((T) j.value);
	            node = node.next;
	            j = j.next;
	        }
	        return nodeHead.next;

	    }
	
	public String toDisplay(MuthuNode head) {
		if(head == null) {
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
	
	 public MuthuNode sortByBubbleList(MuthuNode head) {
		 MuthuNode tempHead = head;
		 MuthuNode sortedNode = null;
	        if(tempHead == null || tempHead.next == null){
	            return head;
	        }
	        while(tempHead != null){
	        	MuthuNode InnerHead = head;
	            while(InnerHead != sortedNode){
	                if(InnerHead.next != null && (int)InnerHead.value > (int)InnerHead.next.value){
	                    if(InnerHead == head){
	                        InnerHead.next = InnerHead.next.next;
	                        InnerHead.next.next = InnerHead;
	                        head = InnerHead.next;
	                    }
	                    else{
	                    	MuthuNode prev = getPrev(InnerHead,head);
	                        prev.next = InnerHead.next;
	                        InnerHead.next = prev.next.next;
	                        prev.next.next = InnerHead;

	                    }
	                }
	                InnerHead = InnerHead.next;
	            }
	            sortedNode = InnerHead;
	            tempHead = tempHead.next;
	        }
	        return head;
	    }
	 MuthuNode getPrev(MuthuNode node,MuthuNode head){
		 MuthuNode tempHead = head;
	        while(tempHead.next != node){
	            tempHead = tempHead.next;
	        }
	        return tempHead;

	    }
	 
	 
	 void reverseList(MuthuNode node) {
		 if(node.next == null) {
			 head = node;
			 return;
		 }
		 reverseList(node.next);
		 tail.next = node;
		 node.next = null;
		 tail = node;
	 }
	

}

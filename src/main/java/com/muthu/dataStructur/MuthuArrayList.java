package com.muthu.dataStructur;

public class MuthuArrayList<a> {

	protected final int size = 10;
	protected Object[] arr =  new Object[size];
	protected int currentSize = 0;
	
	public void add(a value) {
		if(currentSize == arr.length) {
			Object[] temp = new Object[arr.length * 2];
			for(int i = 0; i<arr.length ;i++) {
				temp[i] = arr[i];
			}
			arr = temp;
		}
		arr[currentSize] = value;
		currentSize++;
	}
	
	public void remove(int index) {
		int count = 0;
		Object[] temp = new Object[arr.length];
		for(int i = 0; i < arr.length;i++) {
			if(i != index) {
				temp[count] = arr[i];
				count++;
			}
		}
		arr= temp;
		currentSize--;
	}
	
	public void set(int index, a element) {
		if(index >= arr.length) {
			Object[] temp = new Object[arr.length * 2];
			for(int i = 0; i<arr.length ;i++) {
				temp[i] = arr[i];
			}
			arr = temp;
		}
		arr[index] = element;
	}
	
	public int get(int index) {
		return (int) arr[index];
	}
	
	public int size() {
		return currentSize;
	}
	
	public boolean isEmpty() {
		return currentSize == 0;
	}
	
	public int actualSize() {
		return arr.length;
	}

	@Override
	public String toString() {
		String output = "";
		for(int i = 0;i < currentSize ;i++) {
			if(i == currentSize -1 ) {
				output = output + arr[i];
			}
			else {
				output = output + arr[i]+",";
			}
			
		}
		output+="";
		return "["+ output + "]";
	}
	
	
	
	
}

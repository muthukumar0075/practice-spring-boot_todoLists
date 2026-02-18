package com.muthu.dataStructur;

public class StackData<T> extends MuthuArrayList<T> {
	public StackData() {
	}
	
	public T remove() {
		T value = (T) arr[currentSize - 1];
		arr[currentSize - 1] = null;
		currentSize = currentSize - 1;
		return value;
	}
	

}

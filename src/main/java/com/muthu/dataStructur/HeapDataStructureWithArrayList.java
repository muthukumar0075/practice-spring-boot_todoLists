package com.muthu.dataStructur;

import java.util.ArrayList;
import java.util.List;

public class HeapDataStructureWithArrayList {
	private List<Integer> arr;
	public HeapDataStructureWithArrayList() {
		this.arr = new ArrayList<>();
	}
	
	public void insert(int value,boolean maxHeap) {
		arr.add(value);
		int index = arr.indexOf(value);
		while(!locationValidator(index,maxHeap)) {
			int parentIndex = index / 2;
			int parentValue = arr.get(parentIndex);
			arr.set(parentIndex, arr.get(index));
			arr.set(index, parentValue);
			index = parentIndex;
		}
	}
	
	public void remove(boolean maxHeap) {
		int index = 0;
		int lastValue = arr.removeLast();
		arr.set(0, lastValue);
		while(index + 1 < arr.size() && !locationValidator(index + 1, maxHeap)) {
			int leftValue = arr.get(index + 1);
			int currentValue = arr.get(index);
			if(maxHeap) {
				if(leftValue > currentValue) {
					arr.set(index + 1, currentValue);
					arr.set(index, leftValue);
					index = index + 1;
				}
			}
			else {
				if(leftValue < currentValue) {
					arr.set(index + 1, currentValue);
					arr.set(index, leftValue);
					index = index + 1;
				}
			}
		}
		while(index + 2 < arr.size() && !locationValidator(index + 2, maxHeap)) {
			int rightValue = arr.get(index + 2);
			int currentValue = arr.get(index);
			if(maxHeap) {
				if(rightValue > currentValue) {
					arr.set(index + 2, currentValue);
					arr.set(index, rightValue);
					index = index + 2;
				}
			}
			else {
				if(rightValue < currentValue) {
					arr.set(index + 2, currentValue);
					arr.set(index, rightValue);
					index = index + 2;
				}
			}
		}
		
	}
	
	public void output() {
		System.out.println(arr);
	}
	
	private boolean locationValidator(int index,boolean maxHeap) {
		boolean flag = false;
		int child = arr.get(index);
		int parent = arr.get(index/2);
		if(maxHeap) {
			if(parent >= child) {
				flag = true;
			}
		}
		else {
			if(parent <= child) {
				flag = true;
			}
		}
		return flag;
	}
}

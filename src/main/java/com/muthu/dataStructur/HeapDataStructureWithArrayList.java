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
	
	public int remove(boolean maxHeap) {
		int firstElement = arr.get(0);
		int index = 0;
		if(arr.size() == 1) {
			return arr.removeLast();
		}
		arr.set(index, arr.removeLast());
		while(downwardsValidator(maxHeap,arr.get(index))) {
			if(maxHeap) {
				int leftValueIndex = index * 2 + 1;
				int rightValueIndex = index * 2 + 2;
				if(leftValueIndex < arr.size() && rightValueIndex < arr.size()) {
					if(arr.get(rightValueIndex) < arr.get(leftValueIndex)) {
						int leftValue = arr.get(leftValueIndex);
						arr.set(leftValueIndex, arr.get(index));
						arr.set(index, leftValue);
						index = leftValueIndex;
					}
					else if(arr.get(leftValueIndex) < arr.get(rightValueIndex)) {
						int rightValue = arr.get(rightValueIndex);
						arr.set(rightValueIndex, arr.get(index));
						arr.set(index, rightValue);
						index = rightValueIndex;
					}
				}
				else if(leftValueIndex < arr.size()) {
					if(arr.get(index) < arr.get(leftValueIndex)) {
						int leftValue = arr.get(leftValueIndex);
						arr.set(leftValueIndex, arr.get(index));
						arr.set(index, leftValue);
						index = leftValueIndex;
					}
				}
			}
			else {
				int leftValueIndex = index * 2 + 1;
				int rightValueIndex = index * 2 + 2;
				if(leftValueIndex < arr.size() && rightValueIndex < arr.size()) {
					if(arr.get(rightValueIndex) > arr.get(leftValueIndex)) {
						int leftValue = arr.get(leftValueIndex);
						arr.set(leftValueIndex, arr.get(index));
						arr.set(index, leftValue);
						index = leftValueIndex;
					}
					else if(arr.get(leftValueIndex) > arr.get(rightValueIndex)) {
						int rightValue = arr.get(rightValueIndex);
						arr.set(rightValueIndex, arr.get(index));
						arr.set(index, rightValue);
						index = rightValueIndex;
					}
				}
				else if(leftValueIndex < arr.size()) {
					if(arr.get(index) > arr.get(leftValueIndex)) {
						int leftValue = arr.get(leftValueIndex);
						arr.set(leftValueIndex, arr.get(index));
						arr.set(index, leftValue);
						index = leftValueIndex;
					}
				}
			}
		}
		return firstElement;
	}
	
	public boolean downwardsValidator(boolean maxHeap,int value) {
		boolean flag = false;
		if(maxHeap) {
			int leftValueIndex = arr.indexOf(value) * 2 + 1;
			int rightValueIndex = arr.indexOf(value) * 2 + 2;
			if(leftValueIndex < arr.size() && rightValueIndex < arr.size()) {
				if(value < arr.get(leftValueIndex) || value < arr.get(rightValueIndex)) {
					return true;
				}
			}
			else if(leftValueIndex < arr.size()) {
				if(value < arr.get(leftValueIndex)) {
					return true;
				}
			}
		}else {
			int leftValueIndex = arr.indexOf(value) * 2 + 1;
			int rightValueIndex = arr.indexOf(value) * 2 + 2;
			if(leftValueIndex < arr.size() && rightValueIndex < arr.size()) {
				if(value > arr.get(leftValueIndex) || value > arr.get(rightValueIndex)) {
					return true;
				}
			}
			else if(leftValueIndex < arr.size()) {
				if(value > arr.get(leftValueIndex)) {
					return true;
				}
			}
		}
		return flag;
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
	
	public ArrayList<Integer> heapSort(boolean maxHeap){
		ArrayList<Integer> sortedArr = new ArrayList<>();
		while(!arr.isEmpty()) {
			sortedArr.add(remove(maxHeap));
		}
		return sortedArr;
	}
	
	public List<Integer> sortedArrayUsingUnstoredArr(List<Integer> unsortedArr,boolean max){
		this.arr = unsortedArr;
		for(int i = arr.size()/2; i >= 0; i--) {
			int index = i;
			while(downwardsValidator(max, arr.get(index))) {
				if(max) {
					int leftValueIndex = index * 2 + 1;
					int rightValueIndex = index * 2 + 2;
					if(leftValueIndex < arr.size() && rightValueIndex < arr.size()) {
						if(arr.get(rightValueIndex) < arr.get(leftValueIndex)) {
							int leftValue = arr.get(leftValueIndex);
							arr.set(leftValueIndex, arr.get(index));
							arr.set(index, leftValue);
							index = leftValueIndex;
						}
						else if(arr.get(leftValueIndex) < arr.get(rightValueIndex)) {
							int rightValue = arr.get(rightValueIndex);
							arr.set(rightValueIndex, arr.get(index));
							arr.set(index, rightValue);
							index = rightValueIndex;
						}
					}
					else if(leftValueIndex < arr.size()) {
						if(arr.get(index) < arr.get(leftValueIndex)) {
							int leftValue = arr.get(leftValueIndex);
							arr.set(leftValueIndex, arr.get(index));
							arr.set(index, leftValue);
							index = leftValueIndex;
						}
					}
				}
				else {
					int leftValueIndex = index * 2 + 1;
					int rightValueIndex = index * 2 + 2;
					if(leftValueIndex < arr.size() && rightValueIndex < arr.size()) {
						if(arr.get(rightValueIndex) > arr.get(leftValueIndex)) {
							int leftValue = arr.get(leftValueIndex);
							arr.set(leftValueIndex, arr.get(index));
							arr.set(index, leftValue);
							index = leftValueIndex;
						}
						else if(arr.get(leftValueIndex) > arr.get(rightValueIndex)) {
							int rightValue = arr.get(rightValueIndex);
							arr.set(rightValueIndex, arr.get(index));
							arr.set(index, rightValue);
							index = rightValueIndex;
						}
					}
					else if(leftValueIndex < arr.size()) {
						if(arr.get(index) > arr.get(leftValueIndex)) {
							int leftValue = arr.get(leftValueIndex);
							arr.set(leftValueIndex, arr.get(index));
							arr.set(index, leftValue);
							index = leftValueIndex;
						}
					}
				}
			}
		}
		return this.arr;
	}
}

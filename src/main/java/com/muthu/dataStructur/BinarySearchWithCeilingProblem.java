package com.muthu.dataStructur;

public class BinarySearchWithCeilingProblem {
	public static void main(String[] args) {
		int[] arr = {2,3,5,9,14,16,18};
		System.out.println(arr[binarySearch(arr,14)]);
		
	}
	
	static int binarySearch(int[] arr,int target) {
		int startIndex = 0;
		int endIndex = arr.length - 1;
		boolean isAsc = arr[startIndex]<arr[endIndex];
		if(target > arr[endIndex]) {
			return -1;
		}
		while(startIndex<=endIndex) {
			int midIndex = startIndex + (endIndex - startIndex)/2;// this is very similiar to (s+e)/2
			if(isAsc) {
				if(target > arr[midIndex]) {
					startIndex = midIndex+1;
				}
				else if(target < arr[midIndex]) {
					endIndex = midIndex-1;
				}
				else {
					return midIndex;
				}
			}
			else {
				if(target < arr[midIndex]) {
					startIndex = midIndex+1;
				}
				else if(target > arr[midIndex]) {
					endIndex = midIndex-1;
				}
				else {
					return midIndex;
				}
				
			}
			
			
		}
		
		return startIndex;
	}


}

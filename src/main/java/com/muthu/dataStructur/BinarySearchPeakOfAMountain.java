package com.muthu.dataStructur;

public class BinarySearchPeakOfAMountain {

	public static void main(String[] args) {
		int[] arr = {0,1,2,3,0};
		System.out.println(binarySearch(arr));

	}
	
	static int binarySearch(int[] arr) {
		int start = 0;
		int end = arr.length-1;
		int mid = 0;
		while(start <= end) {
			mid = start + (end - start)/2;
			if(arr[mid] > arr[mid+1]) {
				end = mid ;
			}
			else if(arr[mid] < arr[mid+1]) {
				start = mid +1;
			}
			else {
				return mid;
			}
		}
		return start;
	}

}

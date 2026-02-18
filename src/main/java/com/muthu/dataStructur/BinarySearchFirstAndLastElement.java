package com.muthu.dataStructur;

public class BinarySearchFirstAndLastElement {

	public static void main(String[] args) {
		int[] arr = {2,3,5,9,14,14,14,16,18};
		int[] value = firstAndLastTargetArray(arr, 14);
		for(int ele : value) {
			System.out.println(ele);
		}

	}
	
	static int[] firstAndLastTargetArray(int[] arr ,int target) {
		int[] finding = {-1,-1};
		finding[0] = firstAndLastTargetArray(arr, target, true);
		finding[1] = firstAndLastTargetArray(arr, target, false);
		return finding;
	}
	static int firstAndLastTargetArray(int[] arr ,int target,boolean firstSearch) {
		int ans = -1;
		int startIndex = 0;
		int endIndex = arr.length-1;
		while(startIndex <= endIndex) {
			int midIndex = startIndex + (endIndex -startIndex)/2;
			if(target > arr[midIndex]) {
				startIndex = midIndex+1;
			}
			else if (target < arr[midIndex]) {
				endIndex = midIndex -1;
			}
			else {
				ans = midIndex;
				if(firstSearch) {
					endIndex = midIndex - 1;
				}
				else {
					startIndex = midIndex +1 ;
				}
			}
		}
		return ans;
	}

}

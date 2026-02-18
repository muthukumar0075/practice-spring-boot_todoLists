package com.practice.leetcode;

public class FindSmallestMissingNumber {

	public static void main(String[] args) {
		int[] arr = {7,8,9,11,12};
		System.out.println(smallestMissingElement(arr));
	}
	
	public static int smallestMissingElement(int[] nums) {
		int i= 0;
		while(i < nums.length) {
			if((nums[i] > 0 && nums[i]<nums.length) && nums[i] -1 != i) {
				if(nums[nums[i] -1] != nums[i]) {
					int temp = nums[nums[i] -1];
					nums[nums[i]-1] = nums[i];
					nums[i] = temp;
				}
				else {
					i++;
				}
			}
			else {
				i++;
			}
		}
		for(int j =0;j<nums.length;j++) {
			if(nums[j] -1 != j) {
				return j +1;
			}
		}
		return nums.length+1;
	}

}

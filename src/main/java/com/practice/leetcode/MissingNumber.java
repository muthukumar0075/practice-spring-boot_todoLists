package com.practice.leetcode;

import java.util.Arrays;

public class MissingNumber {

	public static void main(String[] args) {
	int[] arr = {9,6,4,2,3,5,7,0,1};
	System.out.println(cyclicSortKuranal(arr));

	}
	
	static int cyclicSort(int[] nums , int start) {
		int i = 0;
		while(i < nums.length) {
			if(nums[i] >= nums.length) {
				return nums[i] - 1;
			}
			else if(nums[i] - start != i) {
				int temp = nums[nums[i]];
				nums[nums[i]] = nums[i];
				nums[i]= temp;
			}
			else {
				i++;
			}
		}
		return nums[i -1] +1;
	}
	
	static int cyclicSortKuranal(int[] nums) {
		int i = 0;
		while(i < nums.length) {
			if(nums[i] - 0 != i && nums[i]<nums.length) {
				int temp = nums[nums[i] - 0];
				nums[nums[i] - 0] = nums[i];
				nums[i]= temp;
			}
			else {
				i++;
			}
		}
		int j;
		for(j=0; j< nums.length;j++) {
			if(nums[j] != j) {
				return j;
			}
		}
		return j;
	}

}

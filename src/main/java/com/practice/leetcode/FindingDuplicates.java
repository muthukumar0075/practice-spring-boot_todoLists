package com.practice.leetcode;

public class FindingDuplicates {

	public static void main(String[] args) {
		int[] arr = {1,3,4,2,2};
		System.out.println(fndingDupulicates(arr));
	}
	
	static int fndingDupulicates(int[] nums) {
		int i =0;
		int sub =1;
		while(i<nums.length) {
			if(nums[i] -1 != i) {
				if(nums[nums[i]-1] != nums[i]) {
					int temp = nums[nums[i] -1];
					nums[nums[i]-1] = nums[i];
					nums[i] = temp;
				}
				else {
					return nums[i];
				}
			}
			else {
				i++;
			}
			
		}
		return -1;
	}

}

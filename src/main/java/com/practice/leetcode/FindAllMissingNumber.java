package com.practice.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FindAllMissingNumber {

	public static void main(String[] args) {
		int[] arr = {1,1};
		System.out.println(cyclicSort(arr));

	}
	
	static List<Integer> cyclicSort(int[] nums){
		int i = 0;
		int sub = 1;
		List<Integer> missingValue = new ArrayList<>();
		while(i<nums.length) {
			if(nums[i]-sub !=i) {
				if(nums[nums[i]-sub] == nums[i]) {
					i++;
				}
				else {
					int temp = nums[nums[i] - sub];
					nums[nums[i]- sub] = nums[i];
					nums[i]= temp;
				}
			}
			else {
				i++;
			}
		}
		for(int j = 0;j<nums.length;j++) {
			if(nums[j] -1 !=j) {
				missingValue.add(j+1);
			}
		}
		return missingValue;
	}

}

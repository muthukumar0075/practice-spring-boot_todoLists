package com.practice.leetcode;

import java.util.ArrayList;
import java.util.List;

public class FindAllDuplictes {

	public static void main(String[] args) {
		int[] arr = {5,4,6,7,9,3,10,9,5,6};
		System.out.println(findAllDuplicates(arr).toString());

	}

	public static List<Integer> findAllDuplicates(int[] nums){
		List<Integer> allDuplicate = new ArrayList<>();
		int i =0;
		while(i<nums.length) {
			if(nums[i]-1 !=i) {
				if(nums[nums[i]-1] != nums[i]) {
					int temp = nums[nums[i]-1];
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
		for(int j =0; j<nums.length;j++) {
			if(nums[j] != j +1) {
				allDuplicate.add(nums[j]);
			}
		}
		return allDuplicate;
	}
}

package com.muthu.dataStructur;

import java.util.Arrays;

public class CyclicSort {

	public static void main(String[] args) {
		int[] arr = {1,2,3,4,5};
		cyclicSort(arr);
		System.out.println(Arrays.toString(arr));
	}
	
	static void cyclicSort(int[] arr) {
		int i = 0;
		while(i < (arr.length/2)) {
			if((arr[i] - 1) != i) {
				int temp = arr[arr[i] - 1];
				arr[arr[i] - 1] = arr[i];
				arr[i] = temp;
			}
			else {
				i++;
			}
		}
	}

}

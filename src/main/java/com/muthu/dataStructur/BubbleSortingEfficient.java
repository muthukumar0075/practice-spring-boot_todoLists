package com.muthu.dataStructur;

import java.util.Arrays;

public class BubbleSortingEfficient {
	public static void main(String[] args) {
		int[] value = new int[] {1,2,3,4,5};
		bubbleSort(value);
		System.out.println(Arrays.toString(value));
	}
	
	static void bubbleSort(int[] value) {
		for(int i = 0; i < value.length ;i++) {
			boolean swapped = false;
			for(int j = 1; j < value.length-i;j++) {
				//swapping
				if(value[j] < value[j-1]) {
					int temp = value[j];
					value[j] = value[j-1];
					value[j-1] = temp;
					swapped = true;
				}
			}
			if(!swapped) {
				break;
			}
		}
	}

}

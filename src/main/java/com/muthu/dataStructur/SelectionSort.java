package com.muthu.dataStructur;

import java.util.Arrays;

public class SelectionSort {

	public static void main(String[] args) {
		int[] array = {1,2,3,4,5};
		selectionSort(array);
		System.out.println(Arrays.toString(array));

	}
	
	static void selectionSort(int[] value) {
		for(int i = 0;i < value.length;i++) {
			int maxIndex = 0;
			for(int j = 0; j < value.length-i;j++) {
				if(value[j] > value[maxIndex]) {
					maxIndex = j;
				}
			}
			int temp = value[maxIndex];
			value[maxIndex] = value[(value.length-1) -i];
			value[(value.length-1) -i] = temp;
		}
	}

}

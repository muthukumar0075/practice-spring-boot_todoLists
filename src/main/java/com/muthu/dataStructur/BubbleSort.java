package com.muthu.dataStructur;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class BubbleSort {
	
	public static void main(String[] args) {
		int[] arr = new int[] {15, 18, 20, 20, 28, 33, 35, 35, 50, 60, 65, 65, 70, 75, 95, 103, 133, 135, 138, 143, 145, 163, 170, 170, 176, 180, 188, 190, 197, 198, 198, 203, 203, 203, 208, 210, 210, 213, 213, 215, 218, 225, 225, 235, 240, 240, 250, 251, 253, 253, 253, 260, 265, 268, 283, 295, 295, 298, 315, 315, 320, 330, 338, 363, 383, 410, 413, 420, 500, 533, 740
};
		bubbleSort(arr);
		Map<Integer, Integer> map = new TreeMap<>();
		int count = 10;
		int value = 0;
		int size = 0;
		for(int i : arr) {
			size+=1;
		}
		int lastEle = arr[size - 1];
		int checkValue = 0;
		int index = 0;
		while(index < size && checkValue != lastEle) {
			if(arr[index] <= (count)) {
				value += 1;
				map.put(count, value);
				index +=1;
			}
			else if(arr[index] >= count) {
				value = 0;
				count += 10;
			}
			
		}
		System.out.println(Arrays.toString(arr));
		System.out.println(map);
		
		
		
	}
	
	public static void bubbleSort(int[] values) {
		for(int i = 0;i < values.length;i++) {
			int maxValue = 0;
			for(int j= 0;j < (values.length-i);j++) {
				if(values[maxValue] > values[j]) {
					int temp = values[maxValue];
					values[maxValue] = values[j];
					values[j] = temp;
				}
				maxValue = j;
				
			}
		}
	}
	
	

}

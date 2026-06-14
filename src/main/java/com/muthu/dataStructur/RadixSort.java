package com.muthu.dataStructur;

import java.util.List;

public class RadixSort {
	public List<Integer> sort(List<Integer> arr){
		int maxDigit = findMaxDigit(arr);
		for(int i = 0;i < maxDigit;i++) {
			int exp = i * 10 == 0 ? 1 : i * 10;
			radixSort(exp, arr);
		}
		return arr;
	}
	
	public int findMaxDigit(List<Integer> arr) {
		int max = 0;
		for(int i = 0;i < arr.size();i++) {
			int digits = digitFind(arr.get(i));
			if(digits > max) {
				max = digits;
			}
		}
		return max;
	}
	
	public void  radixSort(int exp,List<Integer> arr) {
		int[] frequencyArr = new int[10];
		int[] output = new int[arr.size()];
		
		// finding index value
		for(Integer value : arr) {
			int index = (value / exp) % 10;
			frequencyArr[index]++;
		}
		
		//find the index value need to be placed
		for(int i = 1; i < 10;i++) {
			frequencyArr[i] += frequencyArr[i - 1];
		}
		
		// actual value to output
		for(int i = arr.size() - 1;i >= 0;i--) {
			output[frequencyArr[(arr.get(i)/exp) % 10] - 1] = arr.get(i);
			frequencyArr[(arr.get(i)/exp) % 10]--;
		}
		
		for(int i = 0;i < arr.size();i++) {
			arr.set(i, output[i]);
		}
	}

	public int digitFind(int value) {
		int max = 0;
		while(value > 0) {
			value = value / 10;
			max = max + 1;
		}
		return max;
	}
}

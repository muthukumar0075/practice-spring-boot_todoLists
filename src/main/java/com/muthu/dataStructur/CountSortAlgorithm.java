package com.muthu.dataStructur;
import java.util.List;

public class CountSortAlgorithm <T extends Integer>{
	
	public List<T> sort(List<T> arr){
		int maxEle = findMax(arr);
		int[] frequencyArr = new int[maxEle + 1];
		checkTheFrequency(arr,frequencyArr);
		doTheFinalValidation(frequencyArr,arr);
		return arr;
	}
	
	private int findMax(List<T> arr) {
		int max = Integer.MIN_VALUE;
		for(T value : arr) {
			if(value > max) {
				max = value;
			}
		}
		return max;
	}
	
	private void checkTheFrequency(List<T> arr,int[] frequencyArr) {
		for(T v : arr) {
			frequencyArr[v]++;
		}
	}
	
	private void doTheFinalValidation(int[] frArr,List<T> arr) {
		arr.clear();
		for(int j = 0;j < frArr.length;j++) {
			for(int i = 0;i < frArr[j];i++) {
				Object g = j;
				arr.add((T) g);
			}
		}
	}

}

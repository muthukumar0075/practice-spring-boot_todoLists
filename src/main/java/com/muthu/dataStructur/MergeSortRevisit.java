package com.muthu.dataStructur;

import java.util.Arrays;

public class MergeSortRevisit {

	public static void main(String[] args) {
		int[] arr = {9,8,7,6,5,4,3,2,1};
		System.out.println(Arrays.toString(mergeSortWithCopyArr(arr)));

	}
	
	public static void mergeSort(int[] arr,int start,int last) {
		if((last - start)==1) {
			return;
		}
		int mid =(start+last) /2;
		mergeSort(arr, start, mid);
		mergeSort(arr, mid, last);
		mergeSortByIndex(arr, start, mid, last);
	}
	public static void mergeSortByIndex(int[] arr,int start,int mid,int last) {
		int i = start;
		int j = mid;
		int k = 0;
		int[] sortedArr = new int[last - start];
		while(i < mid && j < last) {
			if(arr[i] <= arr[j]) {
				sortedArr[k] = arr[i];
				i++;
				k++;
			}
			else if(arr[j] < arr[i]) {
				sortedArr[k] = arr[j];
				j++;
				k++;
			}
		}
		while(i < mid) {
			sortedArr[k] = arr[i];
			i++;
			k++;
		}
		
		while(j < last) {
			sortedArr[k] = arr[j];
			j++;
			k++;
		}
		
		for(int l = 0;l < sortedArr.length;l++) {
			arr[start + l] = sortedArr[l];
		}
		
		
	}
	
	public static int[] mergeSortWithCopyArr(int[] arr) {
		if((arr.length)==1) {
			return arr;
		}
		int mid = (arr.length)/2;
		int[] leftSideArr = mergeSortWithCopyArr(Arrays.copyOfRange(arr,0, mid));
		int[] rightSideArr = mergeSortWithCopyArr(Arrays.copyOfRange(arr, mid, arr.length));
		return merger(leftSideArr, rightSideArr);
	}
	
	static int[] merger(int[] left,int[] right) {
		int i = 0;
		int j = 0;
		int k = 0;
		int[] arr = new int[left.length+right.length];
		while(i < left.length && j < right.length) {
			if(left[i] < right[j]) {
				int temp = left[i];
				arr[k] = temp;
				i++;
				k++;
			}
			else if(right[j] < left[i]) {
				int temp = right[j];
				arr[k] = temp;
				j++;
				k++;
			}
		}
		while(i < left.length) {
			int temp = left[i];
			arr[k] = temp;
			i++;
			k++;
		}
		while(j < right.length) {
			int temp = right[j];
			arr[k] = temp;
			j++;
			k++;
		}
		return arr;
	}
	
	

}

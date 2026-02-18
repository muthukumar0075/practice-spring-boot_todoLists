package com.muthu.dataStructur;

import java.lang.reflect.Array;
import java.util.Arrays;

public class MergeSortWithRecursion {

	public static void main(String[] args) {
		int[] arr = {5,4,3,2,1};
		mergeSortIndex(arr,0,arr.length);
		System.out.println(Arrays.toString(arr) );

	}
	
	public static int[] mergeSort(int[] arr) {
		if(arr.length == 1) {
			return arr;
		}
		int mid = arr.length / 2;
		int[] firstHalf = mergeSort(Arrays.copyOfRange(arr,0,mid));
		int[] secondHalf = mergeSort(Arrays.copyOfRange(arr,mid,arr.length));
		return merger(firstHalf,secondHalf);
	}

	private static int[] merger(int[] firstHalf, int[] secondHalf) {
		int[] sortedArr = new int[firstHalf.length + secondHalf.length];
		int i = 0;
		int j = 0;
		int k = 0;
		while(i < firstHalf.length && j < secondHalf.length) {
			if(firstHalf[i] < secondHalf[j]) {
				sortedArr[k] = firstHalf[i];
				i++;
			}
			else if(secondHalf[j] < firstHalf[i]) {
				sortedArr[k] = secondHalf[j];
				j++;
			}
			k++;
		}
		while(i < firstHalf.length) {
			sortedArr[k] = firstHalf[i];
			i++;
			k++;
		}
		while(j < secondHalf.length) {
			sortedArr[k] = secondHalf[j];
			j++;
			k++;
		}
		return sortedArr;
	}
	
	public static void mergeSortIndex(int[] arr,int start,int end) {
		if((end - start) == 1) {
			return;
		}
		int mid = (start+end) / 2;
		mergeSortIndex(arr,start,mid);
		mergeSortIndex(arr,mid,end);
		mergeSorterByIndex(arr,start,mid,end);
	}

	private static void mergeSorterByIndex(int[] arr, int firstHalf,int mid, int secondHalf) {
		int[] sortedArr = new int[secondHalf - firstHalf];
		int i = firstHalf;
		int j = mid;
		int k = 0;
		while(i < mid && j < secondHalf) {
			if(arr[i] < arr[j]) {
				sortedArr[k] = arr[i];
				i++;
			}
			else if(arr[j] < arr[i]) {
				sortedArr[k] = arr[j];
				j++;
			}
			k++;
		}
		while(i < mid) {
			sortedArr[k] = arr[i];
			i++;
			k++;
		}
		while(j < secondHalf) {
			sortedArr[k] = arr[j];
			j++;
			k++;
		}
		
		for(int l = 0;l < sortedArr.length;l++) {
			arr[firstHalf + l] = sortedArr[l];
		}
	}
	
	

}

package com.muthu.dataStructur;

import java.util.Arrays;

public class RevisionOne {

	public static void main(String[] args) {
		int[] arr = {1,2,5,3,4};
		quickSort(arr,0,arr.length-1);
		System.out.println(Arrays.toString(arr));
	}
	
	public static void bubbleSort(int[] arr) {
		for(int i = 0;i < arr.length;i++) {
			for(int j = 0;j < ((arr.length-1) - i);j++) {
				if(arr[j] > arr[j+1]) {
					int temp = arr[j];
					arr[j] = arr[j + 1];
					arr[j + 1] = temp;
				}
			}
		}
	}
	
	public static void selectionSort(int[] arr) {
		for(int i = 0;i < arr.length;i++) {
			int max = 0;
			for(int j = 0;j < arr.length -i;j++) {
				if(arr[max] < arr[j]) {
					max = j;
				}
			}
				int temp = arr[(arr.length -1) - i];
				arr[(arr.length -1) -i] = arr[max];
				arr[max] = temp;
		}
	}
	
	public static void insertionSort(int[] arr) {
		int s = 0;
		int e = 1;
		while(e < arr.length) {
			for(int i = e;i > s;i--) {
				if(arr[i] < arr[i - 1]) {
					int temp = arr[i];
					arr[i] = arr[i - 1];
					arr[i - 1] = temp;
				}
			}
			e++;
		}
	}
	
	public static void cyclicSort(int[] arr) {
		int i = 0;
		while(i<(arr.length)) {
			if((arr[i] - 1) == i){
				i++;
			}
			else {
				int temp = arr[arr[i] - 1];
				arr[arr[i] - 1] = arr[i];
				arr[i] = temp;
			}
		}
	}
	
	public static void mergeSort(int[] arr,int start,int end) {
		if((end - start) == 1) {
			return;
		}
		int mid = start + (end - start)/2;
		mergeSort(arr, start, mid);
		mergeSort(arr, mid, end);
		merger(arr,start,mid,end);
	}
	public static void merger(int[] arr,int s,int m,int e) {
		int i = s;
		int j = m;
		int k = 0;
		int[] sorted = new int[e-s];
		while(i < m && j < e) {
			if(arr[i] < arr[j]) {
				sorted[k] = arr[i];
				i++;
				k++;
			}
			else if(arr[j] < arr[i]) {
				sorted[k] = arr[j];
				j++;
				k++;
			}
		}
		
		while(i < m) {
			sorted[k] = arr[i];
			i++;
			k++;
		}
		while(j < e) {
			sorted[k] = arr[j];
			j++;
			k++;
		}
		for(int sortedI = 0; sortedI < sorted.length;sortedI++) {
			arr[s+sortedI] = sorted[sortedI];
		}
	}
	public static void quickSort(int[] arr,int start,int end) {
		if(start > end) {
			return;
		}
		int s = start;
		int e = end;
		int p = start + (end - start)/2;
		while(s <= e) {
			if(arr[s] < arr[p]) {
				s++;
			}
			else if(arr[e] > arr[p]) {
				e--;
			}
			else {
				int temp = arr[s];
				arr[s] = arr[e];
				arr[e] = temp;
				s++;
				e--;
			}
		}
		quickSort(arr, start, e);
		quickSort(arr, s, end);
	}
	

}

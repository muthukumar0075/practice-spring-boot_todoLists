package com.muthu.dataStructur;

import java.util.Arrays;

public class InsertionSort {

	public static void main(String[] args) {
		int[] arr = {5,4,3,2,1};
		insertionSort(arr);
		System.out.println(Arrays.toString(arr));
	}
	
	static void insertionSort(int[] value) {
		for(int i=0;i<value.length-1;i++) {
			int j=i+1;
			while(value[j-1]>value[j]) {
				int temp = value[j-1];
				value[j-1]=value[j];
				value[j] = temp;
				if(j>1) {
					j=j-1;
				}
			}
		}
	}
	static void insertionSortForKunal(int[] value) {
		for(int i=0;i<value.length-1;i++) {
			for(int j=i+1;j>0;j--){
				if(value[j]<value[j-1]) {
					int temp = value[j];
					value[j]=value[j-1];
					value[j-1] = temp;
				}
				else {
					break;
				}
				
			}
		}
	}

}

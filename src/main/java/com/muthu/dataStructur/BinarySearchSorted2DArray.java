package com.muthu.dataStructur;

import java.util.Arrays;

public class BinarySearchSorted2DArray {
	public static void main(String[] args) {
		int[][] array = {
				{1,2,3,4},
				{5,6,7,8},
				{9,10,11,12},
				{13,14,15,16}
				};
		int[] value = removeUnwantedColumn(array,16);
		System.out.println(Arrays.toString(value));
	}
	
	static int[] removeUnwantedColumn(int[][] arr,int target){
		int sCol = 0;
		int eCol = arr.length-1;
		int mRow = (arr.length - 1)/2;
		
		while(sCol < (eCol - 1)) {
			int mCol = sCol + (eCol - sCol)/2;
			if(arr[mCol][mRow] == target) {
				return new int[] {mCol,mRow};
			}
			
			if(arr[mCol][mRow] < target) {
				sCol = mCol;
			}
			else {
				eCol = mCol ;
			}
		}
		if(arr[sCol][mRow] == target) {
			return new int[] {sCol,mRow};
		}
		if(arr[eCol][mRow] == target) {
			return new int[] {eCol,mRow};
		}
		if(arr[sCol][mRow] > target && arr[sCol][arr[sCol].length -1] >= target) {
			return binerySearch(arr,sCol,target,0,mRow);
		}
		if(arr[sCol][mRow] < target && arr[sCol][arr[sCol].length -1] >= target) {
			return binerySearch(arr, sCol, target, mRow, arr.length);
		}
		if(arr[eCol][mRow] > target) {
			return binerySearch(arr, eCol, target, 0,mRow);
		}
		else {
			return binerySearch(arr, eCol, target, mRow, arr.length);
		}
	}
	
	static int[] binerySearch(int[][] arr, int col, int target, int sRow,int eRow){
		while(sRow < eRow) {
			int mRow = sRow + (eRow - sRow) / 2;
			if(arr[col][mRow] == target) {
				return new int[] {col,mRow};
			}
			if(arr[col][mRow] < target) {
				sRow = mRow + 1;
			}
			else {
				eRow = mRow +1;
			}
		}
		return new int[] {-1,-1};
	}
	

}

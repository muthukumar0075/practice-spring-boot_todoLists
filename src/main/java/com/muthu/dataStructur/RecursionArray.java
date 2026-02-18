package com.muthu.dataStructur;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class RecursionArray {

	public static void main(String[] args) {
		int[] arr = {6,5,4,3,2,1};
		recursionWithSelectionSort(0,0,0,arr);
		System.out.println(Arrays.toString(arr));

	}
	
	public static String RecursionArrayQ1(int[] arr, int pointerOne,int pointerTwo)
	{
		if(arr[pointerOne] > arr[pointerTwo]) {
			return "NotSorted";
		}
		if((arr.length) - 1 == pointerTwo) {
			return "Sorted";
		}
		return RecursionArrayQ1(arr, pointerOne + 1, pointerTwo + 1);
	}
	
	public static int searchTargetWithRecursion(int[] arr , int target , int pointer) {
		if(arr[pointer] == target) {
			return pointer;
		}
		else if(arr.length - 1 == pointer) {
			return -1;
		}
		return searchTargetWithRecursion(arr, target, pointer + 1);
	}
	
	public static ArrayList<Integer> searchTargetAllWithRecursion(int[] arr , int target , int pointer, ArrayList<Integer> storage) {
		if(arr[pointer] == target) {
		    storage.add(pointer);
		}
		else if(arr.length - 1 == pointer) {
			return storage;
		}
		return searchTargetAllWithRecursion(arr, target, pointer + 1,storage);
	}
	
	public static ArrayList<Integer> searchTargetAllWithRecursionWithOutArgument(int[] arr , int target , int pointer) {
		ArrayList<Integer> storage = new ArrayList<>();
		if(arr[pointer] == target) {
		    storage.add(pointer);
		}
		else if(arr.length - 1 == pointer) {
			return storage;
		}
		ArrayList<Integer> answerFromBelowList = searchTargetAllWithRecursionWithOutArgument(arr, target, pointer + 1);
		storage.addAll(answerFromBelowList);
		return storage;
	}
	
	public static int recursionWithBinarySearchAndRotated(int[] arr,int start,int end,int target) {
		int mid = start + (end - start)/2;
		if(start > end) {
			return -1;
		}
		if(arr[mid] == target) {
			return mid;
		}
		else if(arr[start] <= arr[mid]) {
			if(target >= arr[start] && target < arr[mid]) {
				return recursionWithBinarySearchAndRotated(arr, start, mid-1, target);
			}
			else {
				return recursionWithBinarySearchAndRotated(arr, mid+1,end, target);
			}
		}
		else if(target > arr[mid] && target <arr[end]) {
			return recursionWithBinarySearchAndRotated(arr, mid+1, end, target);
		}
		else {
			return recursionWithBinarySearchAndRotated(arr, start, mid-1, target);
		}
	}
	
	public static void recursionWithPatterninvertedTriangle(int x,int y) {
		if(x > 4) {
			return;
		}
		if(y == 0) {
			System.out.println("");
			recursionWithPatterninvertedTriangle(x+1,(4 - x));
		}
		else {
			System.out.print("*");
			recursionWithPatterninvertedTriangle(x, y-1);
		}
	}
	
	public static void recursionWithPatternNormalTriangle(int x,int y) {
		if(x > 4) {
			return;
		}
		if(y > x) {
			System.out.println("");
			recursionWithPatternNormalTriangle(x+1,1);
		}
		else {
			System.out.print("*");
			recursionWithPatternNormalTriangle(x, y+1);
		}
	}
	
	public static void recursionWithPatterninvertedTriangleByKurnal(int x,int y) {
		if(x > 4) {
			return;
		}
		if(y == 0) {
			recursionWithPatterninvertedTriangleByKurnal(x+1,(4 - x));
			System.out.println("");
		}
		else {
			recursionWithPatterninvertedTriangleByKurnal(x, y-1);
			System.out.print("*");
		}
	}
	
	public static void recursionWithBubbleSort(int x,int y,int[] arr) {
		if(x > arr.length -1) {
			return;
		}
		if(y == ((arr.length -1) - x)){
			recursionWithBubbleSort(x+1, 0, arr);
		}
		else if(arr[y] > arr[y + 1]) {
			int temp = arr[y];
			arr[y] = arr[y + 1];
			arr[y + 1] = temp;
			recursionWithBubbleSort(x, y + 1, arr);
		}
		else
		{
			recursionWithBubbleSort(x, y + 1, arr);
		}
		
	}
	
	public static void recursionWithSelectionSort(int x,int y,int maximumIndex,int[] arr) {
		//base
		if(x == (arr.length)) {
			return;
		}
		if(y == (arr.length) - x) {
			int temp = arr[maximumIndex];
			arr[maximumIndex] = arr[((arr.length - 1) - x)];
			arr[((arr.length - 1) - x)] = temp;
			recursionWithSelectionSort(x+1,0,0, arr);
		}
		else if(arr[y] > arr[maximumIndex]) {
			maximumIndex = y;
			recursionWithSelectionSort(x, y+1,maximumIndex, arr);
		}
		else {
			recursionWithSelectionSort(x, y+1,maximumIndex, arr);
		}
	}

}

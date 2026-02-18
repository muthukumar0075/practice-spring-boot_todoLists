package com.muthu.dataStructur;

public class BinerySearchRotatedsortedValue {

	public static void main(String[] args) {
		int[] arr = {9,1,9,9,9,9};
		int target = 1;
		int pivot = findPivot(arr,true);
		if(pivot == -1) {
			System.out.println(binarySearch(arr, 0, arr.length, target));
		}
		else if(arr[pivot] == target) {
			System.out.println(pivot);
		}
		else if(arr[0]>target) {
			System.out.println(binarySearch(arr, pivot+1, arr.length-1, target));
		}
		else {
			System.out.println(binarySearch(arr, 0, pivot, target));
		}
		
	}
	
	static int findPivot(int[] arr,boolean firstTime) {
		int start = 0;
		int end = arr.length-1;
		while(start <=end) {
			int mid = start + (end - start)/2 ;
			if(mid<end && arr[mid] > arr[mid+1]) {
				return mid;
			}
			else if(mid>start && arr[mid] < arr[mid -1]) {
				return mid-1;
			}
			else if(arr[start] == arr[mid] && arr[mid] == arr[end]) {
				if(arr[start] > arr[start+1]) {
					return start;
				}
				else if(arr[end] < arr[end-1]) {
					return end -1;
				}
				else {
					start++;
					end--;
				}
			}
			else if(arr[start] < arr[mid] || arr[start] == arr[mid]  && arr[mid] > arr[end]) {
				start = mid+1;
			}
			else {
				end = mid-1;
			}
		}
		return -1;
	}
	
	static int binarySearch(int[] arr, int start,int end,int target) {
		boolean isAsc = arr[start] < arr[end];
		while(start<= end) {
			int mid = start + (end - start)/2;
			if(isAsc) {
				if(target > arr[mid]) {
					start = mid + 1 ;
				}
				else if(target < arr[mid]) {
					end = mid - 1;
				}
				else {
					return mid;
				}
			}
			else {
				if(target > arr[mid]) {
					end = mid - 1;
				}
				else if(target < arr[mid]) {
					start = mid + 1 ;
				}
				else {
					return mid;
				}
				
			}
		}
		return -1 ;
	}

}

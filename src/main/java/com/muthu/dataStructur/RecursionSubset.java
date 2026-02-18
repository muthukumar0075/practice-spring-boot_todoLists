package com.muthu.dataStructur;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

public class RecursionSubset {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[]  subset= {1,2,3};
		subsets(subset);
	}
	
	public static void subSetOfElements(String processed,String unprocessed) {
		if(unprocessed.equals("")) {
			System.out.println(processed);
			return;
		}
		subSetOfElements(processed+unprocessed.substring(0,1), unprocessed.substring(1));
		subSetOfElements(processed, unprocessed.substring(1));
	}
	
	public static List<String> subSetOfElementsArr(String processed,String unprocessed) {
		if(unprocessed.equals("")) {
			List<String> arr = new ArrayList<>();
			arr.add(processed);
			return arr ;
		}
		char letter = unprocessed.charAt(0);
		int ascii = letter;
		List<String> arrLeft = subSetOfElementsArr(processed+letter, unprocessed.substring(1));
		List<String> arrRight = subSetOfElementsArr(processed, unprocessed.substring(1));
		List<String> arrMid = subSetOfElementsArr(processed+(ascii), unprocessed.substring(1));
		arrLeft.addAll(arrRight);
		arrLeft.addAll(arrMid);
		return arrLeft;
		
	}
	
	public static List<List<Integer>> subSetOfEleUsingLoopByKurnal(int[] arr){
		List<List<Integer>> outerList = new ArrayList<>();
		outerList.add(new ArrayList<>());
		for(int i = 0;i < arr.length;i++) {
			int n=outerList.size();
			for(int j = 0;j < n;j++) {
				List<Integer> innerList = new ArrayList<>(outerList.get(j));
				innerList.add(arr[i]);
				outerList.add(innerList);
			}
		}
		return outerList;
	}
	//so complex didnt worked
	public static List<List<Integer>> subSetOfEleUsingLoopByKurnalDuplicates(int[] arr){
		List<List<Integer>> outerList = new ArrayList<>();
		outerList.add(new ArrayList<>());
		for(int i = 0;i < arr.length;i++) {
			int n=outerList.size();
			for(int j = 0;j < n;j++) {
				List<Integer> innerList = new ArrayList<>(outerList.get(j));
				innerList.add(arr[i]);
				boolean flag = false;
				for(int m = 0;m < n;m++) {
					for(int nm = 0;nm < outerList.get(m).size();nm++) {
						for(int l = 0;l < innerList.size();l++) {
							if(outerList.get(m).get(nm)==(innerList.get(l))) {
								if(l==0 && (innerList.size()==1)) {
									flag = true;
								}
								else {
									flag = true;
								}
							}
							else {
								flag = false;
							}
							
						}
						
					}
				}
				if(!flag) {
					outerList.add(innerList);
				}
			}
		}
		return outerList;
	}
	
	public static List<List<Integer>> subSetWithDuplicates(int[] arr){
		Arrays.sort(arr);
		List<Integer> duplicatesArr = new ArrayList<>();
		for(int m = 0;m < arr.length-1;m++) {
			for(int b = m+1;b < arr.length;b++)
			if(arr[m] == arr[b]) {
				duplicatesArr.add(b);
			}
		}
		List<List<Integer>> outerList = new ArrayList<>();
		outerList.add(new ArrayList<>());
		for(int i = 0;i < arr.length;i++) {
			int n=outerList.size();
			int j = 0;
			if(duplicatesArr.contains(i)) {
				j = n /2;
			}
			for(;j < n;j++) {
				List<Integer> innerList = new ArrayList<>(outerList.get(j));
				innerList.add(arr[i]);
				outerList.add(innerList);
			}
		}
		return outerList;
	}
	
	 public static List<List<Integer>> subsets(int[] nums) {
	        List<Integer> numList = new ArrayList<Integer>();
	        for(int i = 0;i < nums.length;i++){
	            numList.add(nums[i]);
	        }
	        System.out.println("start"+numList);
	        return helper(new ArrayList<Integer>(),numList);
	    }

	    static List<List<Integer>> helper(List<Integer> processedNum,List<Integer> unprocessedNum){
	        if(unprocessedNum.size() == 0){
	            List<List<Integer>> ourList = new ArrayList<List<Integer>>();
	            ourList.add(processedNum);
	            System.out.println("processedNum"+ourList);
	            return ourList;
	        }
	        List<List<Integer>> takeList = null;
	        List<List<Integer>> noTakeList = null;
	        if(unprocessedNum.size() == 1){
	             System.out.println("un"+unprocessedNum);
	             List<Integer> newProcessNum = new ArrayList<>();
	             newProcessNum.addAll(processedNum);
	             newProcessNum.addAll(unprocessedNum.subList(0,1));
	             takeList = helper(newProcessNum,new ArrayList<>());
	        }
	        else{
	            System.out.println("un"+unprocessedNum);
	            List<Integer> newProcessNum = new ArrayList<>();
	            newProcessNum.addAll(processedNum);
	            newProcessNum.addAll(unprocessedNum.subList(0,1));
	             takeList = helper(newProcessNum,unprocessedNum.subList(1,unprocessedNum.size()));
	        }
	        if(unprocessedNum.size() == 1){
	        	List<Integer> newProcessNum = new ArrayList<>();
		        newProcessNum.addAll(processedNum);
	            noTakeList = helper(newProcessNum,new ArrayList<Integer>());
	        }
	        else if(unprocessedNum.size() > 1){
	        	List<Integer> newProcessNum = new ArrayList<>();
		        newProcessNum.addAll(processedNum);
	            noTakeList = helper(newProcessNum,unprocessedNum.subList(1,unprocessedNum.size()));
	        }
	        if(noTakeList != null) {
	        	for(List<Integer> values : noTakeList){
		            System.out.println("from the sep"+values);
		            takeList.add(values);
		        }
	        }
	        System.out.println("FinalResult"+takeList);
	        return takeList;
	    }

}

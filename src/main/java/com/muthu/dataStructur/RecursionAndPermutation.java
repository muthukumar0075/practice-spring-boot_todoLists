package com.muthu.dataStructur;

import java.util.ArrayList;
import java.util.List;

public class RecursionAndPermutation {

	public static void main(String[] args) {
		permutation("", "abcd");
		//System.out.println(permutation("", "abc"));

	}
	public static void permutation(String processed,String unprocessed) {
		if(unprocessed.isEmpty()) {
			System.out.println(processed);
			return;
		}
		for(int i = 0;i <= processed.length();i++) {
			if(processed.length() == i) {
				permutation(processed+unprocessed.charAt(0), unprocessed.substring(1));
			}
			else if(i==0){
				permutation(unprocessed.charAt(0)+processed, unprocessed.substring(1));
			}
			else {
				permutation(processed.substring(0, i) +unprocessed.charAt(0)+processed.substring(i, processed.length()), unprocessed.substring(1));
			}
		}
	}
	
	public static List<String> permutationForArray(String processed,String unprocessed) {
		if(unprocessed.isEmpty()) {
			List<String> arr = new ArrayList<>();
			arr.add(processed);
			return arr;
		}
		List<String> finalList = new ArrayList<>();
		for(int i = 0;i <= processed.length();i++) {
			
			if(processed.length() == i) {
				List<String> innerListRight = permutationForArray(processed+unprocessed.charAt(0), unprocessed.substring(1));
				finalList.addAll(innerListRight);
			}
			else if(i==0){
				List<String> innerListLeft = permutationForArray(unprocessed.charAt(0)+processed, unprocessed.substring(1));
				finalList.addAll(innerListLeft);
			}
			else {
				List<String> innerListMid = permutationForArray(processed.substring(0, i) +unprocessed.charAt(0)+processed.substring(i, processed.length()), unprocessed.substring(1));
				finalList.addAll(innerListMid);
			}
			
		}
		return finalList;
	}
	public static int permutationCount(String processed,String unprocessed) {
		if(unprocessed.isEmpty()) {
			return 1;
		}
		int outerCounter = 0;
		for(int i = 0;i <= processed.length();i++) {
			if(processed.length() == i) {
				int value = permutationCount(processed+unprocessed.charAt(0), unprocessed.substring(1));
				outerCounter+=value;
			}
			else if(i==0){
				int value = permutationCount(unprocessed.charAt(0)+processed, unprocessed.substring(1));
				outerCounter+=value;
			}
			else {
				int value = permutationCount(processed.substring(0, i) +unprocessed.charAt(0)+processed.substring(i, processed.length()), unprocessed.substring(1));
				outerCounter+=value;
			}
		}
		return outerCounter;
	}

}

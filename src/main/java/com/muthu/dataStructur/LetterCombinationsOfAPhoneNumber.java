package com.muthu.dataStructur;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LetterCombinationsOfAPhoneNumber {

	public static void main(String[] args) {
		//dices("",6);
		System.out.println(dicesInList("", 4));

	}
	public static List<String> letterCombination(String digits){
		Map<String, String> map = new HashMap();
		map.put("2", "abc");
		map.put("3", "def");
		map.put("4", "ghi");
		map.put("5", "jkl");
		map.put("6", "mno");
		map.put("7", "pqrs");
		map.put("8", "tuv");
		map.put("9", "wxyz");
		List<String> outerValue = new ArrayList<>();
		int n = digits.length();
		if(n != 1) {
			n = n - 1;
		}
		
		for(int i = 0;i < n;i++) {
			for(int j = 0; j < map.get(digits.charAt(i)+"").length();j++) {
				String processed = map.get(digits.charAt(i)+"").charAt(j)+"";
				String unprocessed = map.get(digits.charAt(digits.length()-1)+"");
				outerValue.addAll(helperFnForSubSet(processed,unprocessed,digits.length(),new ArrayList<String>()));
			}
		}
		return outerValue;
	}
	public static List<String> helperFnForSubSet(String processed,String unprocessed,int digits,List<String>finalValue){
		if(processed.length() == digits || unprocessed.length()==0) {
			List<String> arr = new ArrayList<>();

			if(unprocessed.isEmpty() && processed.length()==1) {
				return arr;
			}else if(processed.length() == digits) {
				arr.add(processed);
				return arr;
			}
			return arr;
			
		}
		List<String> leftArr = helperFnForSubSet(processed+unprocessed.substring(0,1), unprocessed.substring(1), digits,finalValue);
		List<String> rightArr = helperFnForSubSet(processed, unprocessed.substring(1), digits,finalValue);
		finalValue.addAll(leftArr);
		return finalValue;
		
	}
	public static List<String> letterCombinationByKunal(String p,String up){
		if(up.isEmpty()) {
			List<String> arr = new ArrayList<>();
			arr.add(p);
			return arr;
		}
		int digits = up.charAt(0) - '0'; // will return number
		int i = (digits-2)*3;
		if(i== 7 || i ==9) {
			i= i + 1;
		}
		ArrayList<String> finalOutput = new ArrayList<>();
		for(;i< (digits-1)*3;i++) {
			char ch = (char) ('a' + i);
			List<String> internal = letterCombinationByKunal(p+ch, up.substring(1));
			finalOutput.addAll(internal);
		}
		return finalOutput;
	}
	public static int letterCombinationCount(String p,String up) {
		if(up.isEmpty()) {
			int count = 0;
			count = count + 1;
			return count;
		}
		int digits = up.charAt(0) - '0'; // will return number
		int i = (digits-2)*3;
		if(i== 7 || i ==9) {
			i= i + 1;
		}
		int counter = 0;
		for(;i< (digits-1)*3;i++) {
			char ch = (char) ('a' + i);
			int value =letterCombinationCount(p+ch, up.substring(1));
			counter = counter + value; 
		}
		return counter;
	}
	public static void dices(String processed,int unprocessed) {
		if(unprocessed == 0) {
			System.out.println(processed);
			return;
		}
		int counter = 1;
		if((unprocessed - counter)>=0) {
			dices(processed + counter, unprocessed - counter);
			counter = counter + 1;
			if((unprocessed - counter)>=0) {
				dices(processed + counter, unprocessed - counter);
			}
			
		}
		
	}
	
	public static List<String> dicesInList(String processed,int unprocessed){
		if(unprocessed == 0) {
			List<String> innerList = new ArrayList<>();
			innerList.add(processed);
			return innerList;
		}
		List<String> outerList = new ArrayList<>();
		for(int i = 1 ; i <=6 && i <= unprocessed;i++) {
			List<String> leftList = dicesInList(processed + i, unprocessed - i);
			outerList.addAll(leftList);
		}
		return outerList;
	}
	
}

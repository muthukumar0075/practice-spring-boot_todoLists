package com.muthu.dataStructur;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class LinearSearch {

	public static void main(String[] args) {
		
	   int[] arr = {10,23,333,40,533};
	   System.out.println(finder(arr));

	}
	
	static int finder(int[] arr) {
		int evenDigits = 0;
		for(int index=0;index<arr.length;index++) {
			if(digitsFinder(arr[index])%2==0) {
				evenDigits+=1;
			}
		}
		return evenDigits;
	}
	
	static int digitsFinder(int num) {
		int divisible = 0;
		while(num>0) {
			divisible +=1;
			num = num/10;
		}
		return divisible;
	}

}

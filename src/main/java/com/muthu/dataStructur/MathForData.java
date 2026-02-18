package com.muthu.dataStructur;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MathForData {

	public static void main(String[] args) {
		System.out.println(leastCommonDivisor(4, 6));
  	}
	
	public static boolean primeNumber(int n) {
		if(n == 1) {
			return false;
		}
		int c = 2;
		//c*c -> 4 from 4 we are checking
		while(c*c <= n) {
			if(n%c == 0) {
				return false;
			}
			c++;
		}
		return true;
	}
	
	public static void primeNumberByKurnal(int n, boolean[] arr) {
		for(int i = 2; i*i <=n;i++) {
			if(!arr[i]) {
				for(int j = i *2; j <=n;j+=i) {
					arr[j]=true;
				}
			}
		}
		for(int k = 2 ; k < arr.length;k++) {
			if(!arr[k]) {
				System.out.println(k + " primeNumber");
			}
		}
		
	}
	
	public static double findASquareRootOfANumberUsingBinarySearch(int n,int nthTimes) {
		int start = 0;
		int end = n;
		double root = 0.0;
		while(start < end) {
			int mid = start + (end -start)/2;
			if((mid*mid) == n) {
				return mid;
			}
			else if((mid * mid) > n) {
				end = mid - 1;
			}
			else if((mid * mid) < n) {
				start = mid + 1;
			}
		}
		root = end;
		double incre = 0.1;
		for(int i = 0; i < nthTimes;i++) {
			while(root * root <= n) {
				root+=incre;
			}
			root-=incre;
			incre /=10;
		}
		return root;
	}
	
	public static void factorOfANumber(int n) {
		List <Integer> arr = new ArrayList<>();
		for(int i = 1;i <=findASquareRootOfANumberUsingBinarySearch(n,1);i++) {
			if(n % i == 0) {
				if(n/i == i) {
					System.out.print(i+" ");
				}
				else {
					System.out.print(i+" ");
					arr.add(n/i);
				}
			}
		}
		for(int i = (arr.size() - 1); i >= 0 ;i--) {
			System.out.print(arr.get(i)+" ");
		}
	}
	public static int greatestCommonDivisor(int a ,int b) {
		if(a == 0) {
			return b;
		}
		return greatestCommonDivisor(b%a, a);
	}
	
	public static int leastCommonDivisor(int a,int b) {
		return (a*b)/greatestCommonDivisor(a, b);
	}

}

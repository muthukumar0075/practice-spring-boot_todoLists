package com.muthu.dataStructur;

public class Recursion {

	public static void main(String[] args) {
		//fib(0, 1, 0, 5);
		//System.out.println(fibFromkurnal(6));
		//int[] arr = new int[] {1,2,3,4,5,6};
		//System.out.println(binarySearch(0, arr.length-1, 7, arr));
		//recursionLevelOneQ3(5);
		System.out.println(RecursionLevelOneQ12NumberOfStepsRequired(12,0));

	}
	
	public static void fib(int firstIndex,int secondIndex,int counter,int series) {
	int total = 0;
	if(counter == series) {
		return;
	}
	if(counter==0) {
		System.out.println(firstIndex);
		System.out.println(secondIndex);
		total = firstIndex + secondIndex;
		System.out.println(total);
		counter = counter + 1;
		fib(secondIndex, total, counter,series);
	}
	else {
		counter = counter + 1;
		total = firstIndex+secondIndex;
		System.out.println(total);
		fib(secondIndex, total, counter,series);
	}
	}
	
	public static int fibFromkurnal(int n) {
		if(n<2) {
			return n;
		}
		return fibFromkurnal(n-1) + fibFromkurnal(n-2);
	}
	
	
	public static int binarySearch(int startIndex,int endIndex,int target,int[] arr) {
		if(startIndex > endIndex) {
			return -1;
		}
		int mid = startIndex + (endIndex - startIndex)/2;
		if(arr[mid] == target) {
			return mid;
		}
		else if(arr[mid] > target) {
			return binarySearch(startIndex, mid-1, target,arr);
		}
		return binarySearch(mid+1, endIndex, target, arr);
	}
	
	public static void recursionLevelOneQ1(int n) {
		if(n==1) {
			System.out.print(n);
			return;
		}
		else {
			System.out.print(n);
		}
		recursionLevelOneQ1(n-1);
	}
	
	public static void recursionLevelOneQ2(int n) {
		if(n==0) {
			return;
		}
		recursionLevelOneQ2(n-1);
		System.out.print(n);
	}
	
	public static void recursionLevelOneQ3(int n) {
		if(n==0) {
			return;
		}
		System.out.print(n);
		recursionLevelOneQ3(n-1);
		System.out.print(n);
	}
	
	public static int recursionLevelOneQ4(int n) {
		if(n < 2) {
			if(n==0) {
				return 1;
			}
			return n;
		}
		return n * recursionLevelOneQ4(n-1);
	}
	
	public static int recursionLevelOneQ5(int n) {
		if(n < 2) {
			if(n==0) {
				return 1;
			}
			return n;
		}
		return n + recursionLevelOneQ5(n-1);
	}
	
	public static int recursionLevelOneQ6(int n,int sum) {
		int remainder = n % 10;
		if(remainder == n) {
			return sum + n;
		}
		sum = sum + remainder;
		n = (n - remainder) <=0? n :(n - remainder)/10;  
		return recursionLevelOneQ6(n, sum);
	}
	
	public static int recursionLevelOneQ6ByKunal(int n) {
		if(n % 10 == n) {
			return n;
		}
		return recursionLevelOneQ6ByKunal(n/10) + n%10;
	}
	
	public static int recursionLevelOneQ7(int n) {
		if(n % 10 == n) {
			return n;
		}
		return (n%10) * recursionLevelOneQ7(n/10) ;
	}
	
	public static int recursionLevelOneQ8(int n) {
		if(n %10 == n) {
			return n;
		}
		int power = (int) Math.log10(n);
		
		return (int) ((n % 10) * Math.pow(10, power)) + recursionLevelOneQ8(n /10) ;
		
	}
	
	public static boolean recursionLevelOneQ9(int n) {
		if(n == recursionLevelOneQ8(n)) {
			return true;
		}
		return false;
		
	}
	
	public static boolean recursionLevelOneQ10(int nFirst , int nSecond,boolean flag) {
		if(!flag) {
			return flag;
		}
		if(nFirst % 10 == nFirst) {
			return true;
		}
		int power = (int) Math.log10(nFirst);
		int firstPointer = (int) (nFirst / Math.pow(10, power));
		int lastPointer = nSecond % 10;
		flag = (firstPointer == lastPointer);
		nFirst = (int) (nFirst - (firstPointer*Math.pow(10, power)));
		return recursionLevelOneQ10(nFirst , nSecond % 10, flag);
	}
	
	public static int recursionLevelOneQ11(int n, int countOfZero) {
		if(n % 10 == 0) {
			countOfZero = countOfZero + 1;
		}
		if(n % 10 == n) {
			return countOfZero;
		}
		return recursionLevelOneQ11(n/10, countOfZero);
	}
	
	public static int RecursionLevelOneQ12NumberOfStepsRequired(int n, int steps) {
		if(n == 0) {
			return steps;
		}
		if(n % 2 == 0) {
			return RecursionLevelOneQ12NumberOfStepsRequired(n / 2, steps+1);
		}
		else {
			return RecursionLevelOneQ12NumberOfStepsRequired(n - 1, steps+1);
		}
	}
	
	

}

package com.practice.leetcode;

public class Pattern {

	public static void main(String[] args) {
		//pattern(10);
		//patternpyramide(5);
		pattern31(9);
	}
	
	public static void pattern(int n) {
		
		for(int row = 1; row <= n; row++) {
			int pattern = 1;
			// spaces
			for(int spaces = 1;spaces <=n - row;spaces++) {
				System.out.print(" ");
			}
			for(int col = 0;col < (row+(row-1));col++) {
				if(row ==1) {
					System.out.print(pattern);
				}
				else {
					if(row - col >1) {
						System.out.print(row - col);
					}
					else if(row - col == 1) {
						System.out.print(row - col);
					}
					else {
						pattern = pattern + 1;
						System.out.print(pattern);
					}
				}
			}
			System.out.println("");
		}
	}
	
	public static void patternpyramide(int n) {
		
		for(int row = 1; row <= n*2; row++) {
			int maxValue = row <= n ? row : (n*2) - row;
			// spaces
			for(int spaces = 1;spaces <=(n) - maxValue;spaces++) {
				System.out.print(" ");
			}
			for(int col = maxValue;col >=1 ;col--) {
				System.out.print(col);
			}
			for(int col = 2;col <=maxValue ;col++) {
				System.out.print(col);
			}
			System.out.println("");
		}
	}	
	
	public static void pattern31(int n) {
		//outerloop n*2
		for(int row = 1;row<n*2;row++) {
			//innerloop n*2
			int startSub = 0;
			int endAdd = (n*2)-1;
			int pattern = n;
			for(int col = 1; col < n*2;col++) {
				int compare = row > n ? n - (row - n) : row;
				System.out.print(pattern);
				if(col < (startSub + compare)){
					pattern = pattern - 1;
				}
				else if(col >(endAdd - compare)) {
					pattern = pattern + 1;
				}
			}
			System.out.println();
		}
	}


}

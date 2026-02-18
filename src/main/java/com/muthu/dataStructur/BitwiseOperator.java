package com.muthu.dataStructur;

import java.util.Arrays;

public class BitwiseOperator {

	public static void main(String[] args) {
		int[][] arr = {{1,1,0},{1,0,1},{0,0,0}};
		System.out.println();

	}
	
	// &of1 with any number gives 1 if it is odd and even if 0
	public static boolean isEven(int n) {
		if((n&1)==1) {
			return false;
		}
		return true;
	}
	
	//^of 0 gives same number but ^ of any number by a number gives 0
	//only works with two duplicates not for more
	public static int uniqueNumberFromList(int[] arr) {
		int uniqueNum = 0;
		for(int n:arr) {
			uniqueNum ^=n;
		}
		return uniqueNum;
	}
	
	//find the nth bit of a value
	public static int nthBit(int n,int num) {
		
		return (num & (1<<(n-1)));
	}
	
	// set the ith bit to 1
	public static int setIthBit(int n,int num) {
		return (num |(1<<(n-1)));
	}
	
	public static int resetIthBit(int n,int num) {
		return (num &(~(1<<(n-1))));
	}
	
	public static int findSetBit(int n,int num) {
		if((num &(1<<(n-1))) != 0) {
			return n;
		}
		return findSetBit(n+1, num);
	}
	public static int findUniqueNumber(int repeatingTime,int[] arr) {
			int result = 0;
			for (int i = 0; i < 32; i++) {
			    int bitSum = 0;
			    for (int num : arr) {
			        if ((num & (1 << i)) != 0) {
			            bitSum++;
			        }
			    }
			    if (bitSum % repeatingTime != 0) {
			        result |= (1 << i);
			    }
			}

		return result;
	}
	
	public static int nthMagicNumber(int n) {
		int magicNumber = 0;
		for(int i=0;i<32;i++) {
			if((n & (1 << i)) != 0) {
				magicNumber += Math.pow(5, (i+1));
			}
			
		}
		return magicNumber;
	}
	
	public static int nthMagicNumberByKunal(int n , int basez) {
		int magicNumber = 0;
		int base = basez;
		while(n>0) {
			int bits = n&1;
			n=n>>1;
			magicNumber += bits*base;
			base= base*5;
		}
		return magicNumber;
	}
	
	public static int noOfDigitInAnyForm(int number,int base) {
		return (int) ((Math.log(number)/Math.log(base)) +1);
	}
	
	/*1   = 1
	 *11  = 2
	 *131 = 4
	 */
	public static int pascaltrigleFindingTheNthNumber(int n) {
		return 1<<(n-1);
	}
	
	// findOut the number is power of 2
	public static boolean findingPowerOfTwo(int n) {
		int bitsAdded = 0;
		while(n>0) {
			bitsAdded = bitsAdded + (1&n);
			n = n>>1;
		}
		if(bitsAdded > 1) {
			return false; 
		}
		return true;
		
	}
	
	public static int findingPowerOfTwoByKunal(int n) {
		return (n & (n-1));
		
	}
	
	public static int findAofB(int b,int n) {
		int base = b;
		int ans = 1;
		 while(n>0) {
			if((n&1)!=0) {
				ans*=base;
			}
			base *= base;
			n= n>>1;
		 }
		 return ans;
	}
	//1001 -> n =2
	public static int findTheNoOfSetBits(int n) {
		int setBits = 0;
		while(n>0) {
			if((n&1)==1) {
				setBits +=1;
			}
			n= n>>1;
		}
		return setBits;
	}
	
	public static int findTheNoOfSetBitsByKunal(int n) {
		int setBits = 0;
		while(n>0) {
			setBits +=1;
			n= n & (n-1);
		}
		return setBits;
	}
	
	public static int findTheExorFrom0ToA(int a) {
		int bitsFromExor = 0;
		for(int i=1;i<=a;i++) {
			bitsFromExor = bitsFromExor ^ i;
		}
		return bitsFromExor;
	}
	
	public static int findTheExorFrom0ToAByKunal(int a) {
		int bits = a%4;
		return bits == 0 ? a : bits == 1 ? a : bits == 2 ? a+1 : 0;
	}
	
	public static int findTheExorBetweenRange(int a,int b) {
		int bitsFromExor = 0;
		for(int i=a;i<=b;i++) {
			bitsFromExor = bitsFromExor ^ i;
		}
		return bitsFromExor;
	}
	
	public static int findTheExorBetweenRangeByKunal(int a,int b) {
		int bits = b%4;
		bits = bits == 0 ? b : bits == 1 ? b : bits == 2 ? b+1 : 0;
		return bits ^ findTheExorFrom0ToAByKunal(a-1);
	}
	
	public static int[][]  flipAndInvertImage(int[][] image){
		int[][] revertedImage = new int[image.length][image[0].length];
		for(int i = 0;i < image.length;i++) {
			int incre = 0;
			for(int j = image[i].length -1;j >= 0;j--) {
				revertedImage[i][incre] = image[i][j] ^1;
				incre +=1;
			}
		}
		
		return revertedImage;
	}
	
}

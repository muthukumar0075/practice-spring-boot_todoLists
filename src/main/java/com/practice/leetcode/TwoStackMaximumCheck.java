package com.practice.leetcode;

import java.util.Arrays;
import java.util.Stack;

public class TwoStackMaximumCheck {

	public static void main(String[] args) {
		Stack<Integer> a = new Stack<>();
		Stack<Integer> b = new Stack<>();
		a.add(1);
		a.add(6);
		a.add(4);
		a.add(2);
		a.add(4);
		b.add(5);
		b.add(8);
		b.add(1);
		b.add(2);
		System.out.println(maximumMovesByKrunal(new int[] {4,2,4,6,1},new int[] {1,8,5}, 10,0,0));
	}
	
	public static int maximumMoves(Stack<Integer> a,Stack<Integer> b,int max) {
		int moves = 0;
		int total = 0;
		while(total < max) {
			if(((a.getLast() + total) < max) || ((b.getLast() + total) < max)) {
				if((a.getLast() + total) < max) {
					total += a.getLast();
					a.pop();
					moves += 1;
				}
				if((b.getLast() + total) < max) {
					total += b.getLast();
					b.pop();
					moves += 1;
				}
			}
			else {
				break;
			}
		}
		return moves;
	}
	
	public static int maximumMovesByKrunal(int[] a, int[] b,int max,int count,int currentTotal) {
		if(currentTotal > max) {
			return count;
		}
		int takeA = maximumMovesByKrunal(Arrays.copyOfRange(a, 1, a.length),b, max,count + 1,currentTotal + a[0]);
		int takeB = maximumMovesByKrunal(a, Arrays.copyOfRange(b, 1, b.length), max,count + 1,currentTotal + b[0]);
		if(takeA > takeB) {
			return takeA;
		}
		else {
			return takeB;
		}
	}

}

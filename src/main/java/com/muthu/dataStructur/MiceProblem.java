package com.muthu.dataStructur;

import java.util.ArrayList;
import java.util.List;

public class MiceProblem {

	public static void main(String[] args) {
//		mice("00", "22", "");
// 		System.out.println(miceCount("00", "22", ""));
//		System.out.println(miceList("00", "22", ""));
		boolean [][] miceBoard= {{true,true,true},
				{true,false,true},
				{true,true,true}
		};
		miceWithObj(0, 0, "", miceBoard);

	}
	
	public static void mice(String processed,String unprocessed,String pattern) {
		if(processed.equals(unprocessed)) {
			System.out.println(pattern);
			return;
		}
		if(Integer.parseInt(processed.substring(1))+1 <= 2) {
			//Go right 
			mice(processed.substring(0,1) + (Integer.parseInt(processed.substring(1))+1), unprocessed,pattern+"R");
		}
		if(Integer.parseInt(processed.substring(1))+1 <= 2 && Integer.parseInt(processed.substring(0,1))+1 <= 2 ) {
			//Go diagonal
			mice((Integer.parseInt(processed.substring(0,1))+1) + "" + (Integer.parseInt(processed.substring(1))+1), unprocessed,pattern+"DI");
		}
		if(Integer.parseInt(processed.substring(0,1))+1 <= 2) {
			//Go DOWN
			mice((Integer.parseInt(processed.substring(0,1))+1) + processed.substring(1),unprocessed,pattern+"D");
		}
		
		
		
	}
	
	public static int miceCount(String processed,String unprocessed,String pattern) {
		if(processed.equals(unprocessed)) {
			return 1;
		}
		int count = 0;
		if(Integer.parseInt(processed.substring(1))+1 <= 2) {
			//Go right 
			count += miceCount(processed.substring(0,1) + (Integer.parseInt(processed.substring(1))+1), unprocessed,pattern+"R");
		}
		if(Integer.parseInt(processed.substring(1))+1 <= 2 && Integer.parseInt(processed.substring(0,1))+1 <= 2 ) {
			//Go diagonal
			count += miceCount((Integer.parseInt(processed.substring(0,1))+1) + "" + (Integer.parseInt(processed.substring(1))+1), unprocessed,pattern+"DI");
			
		}
		if(Integer.parseInt(processed.substring(0,1))+1 <= 2) {
			//Go left
			count += miceCount((Integer.parseInt(processed.substring(0,1))+1) + processed.substring(1),unprocessed,pattern+"D");
		}
		return count;
		
		
		
	}
	
	public static List<String> miceList(String processed,String unprocessed,String pattern) {
		if(processed.equals(unprocessed)) {
			List<String> path = new ArrayList<>();
			path.add(pattern);
			return path;
		}
		List<String> finaValue = new ArrayList<>();
		if(Integer.parseInt(processed.substring(1))+1 <= 2) {
			//Go right 
			List<String> rightPathList = miceList(processed.substring(0,1) + (Integer.parseInt(processed.substring(1))+1), unprocessed,pattern+"R");
			finaValue.addAll(rightPathList);
		}
		if(Integer.parseInt(processed.substring(1))+1 <= 2 && Integer.parseInt(processed.substring(0,1))+1 <= 2 ) {
			//Go diagonal
			List<String> DiagonalPathList = miceList((Integer.parseInt(processed.substring(0,1))+1) + "" + (Integer.parseInt(processed.substring(1))+1), unprocessed,pattern+"DI");
			finaValue.addAll(DiagonalPathList);
		}
		if(Integer.parseInt(processed.substring(0,1))+1 <= 2) {
			//Go left
			List<String> DownPathList = miceList((Integer.parseInt(processed.substring(0,1))+1) + processed.substring(1),unprocessed,pattern+"D");
			finaValue.addAll(DownPathList);
		}
		return finaValue;
		
		
		
	}
	// now changing the (00) to row and column approach
	public static  void miceWithObj(int row,int column,String pattern,boolean[][] mice) {
		if(row == 2 && column == 2) {
			System.out.println(pattern);
			return;
		}
		if(mice[row][column] != false && row + 1 <=2) {
			//Moving Down
			miceWithObj(row +1, column, pattern+"D", mice);
		}
		if(mice[row][column] != false && column + 1 <=2) {
			//Moving right
			miceWithObj(row , column + 1, pattern+"R", mice);
		}
		if(mice[row][column] != false && column + 1 <=2 && row + 1 <=2) {
			//Moving diagonal
			miceWithObj(row+1 , column + 1, pattern+"DI", mice);
		}
	}

}

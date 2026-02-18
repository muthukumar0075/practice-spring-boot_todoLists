package com.muthu.dataStructur;

import java.util.Arrays;

public class BackTracking {
	public static void main(String[] args) {
//		boolean [][] miceBoard= {{true,true,true},
//				{true,true,true},
//				{true,true,true}
//		};
//		int[][] patternMice = {{0,0,0},
//				{0,0,0},
//				{0,0,0}
//		};
////		miceProblem(0, 0, 2, 2,miceBoard,"");
//		miceProblemWithMatrix(0, 0, 2, 2, miceBoard, "", patternMice, 1);
		char[][] Board = {  {'.', '.', '9', '7', '4', '8','.','.', '.'},   
		          {'7', '.', '.', '.', '.', '.', '.', '.','.'},   
		          {'.', '2', '.', '1', '.', '9', '.', '.', '.'},   
		          {'.', '.', '7', '.', '.', '.', '2', '4', '.'},   
		          {'.', '6', '4', '.', '1', '.', '5','9', '.'},   
		          {'.', '9', '8', '.', '.', '.', '3', '.', '.'},   
		          {'.', '.', '.', '8', '.', '3', '.', '8', '.'},   
		          {'.', '.', '.', '.', '.', '.', '.', '.', '6'},   
		          {'.', '.', '.', '2', '7', '5', '9', '.', '.'}   
		       }; 
		pseudoSolver(Board, 0, 0);
		//display(Board);
		
	}
	public static void miceProblem(int row, int column,int targetRow,int targetColumn,boolean[][] board,String pattern) {
		if(row == targetRow && column == targetColumn) {
			System.out.println(pattern);
			return;
		}
		if(!board[row][column]) {
			return;
		}
		
		board[row][column] = false; // marking the cell as visited (######back tracking#####)
		//Moving right
		if(column < board[row].length - 1) {
			miceProblem(row, column + 1, targetRow, targetColumn, board, pattern+"R");
		}
		//Moving Down
		if(row < board[column].length - 1) {
			miceProblem(row + 1, column, targetRow, targetColumn, board, pattern+"D");
		}
		//Moving Up
		if(row > 0) {
			miceProblem(row - 1, column, targetRow, targetColumn, board, pattern+"U");
		}
		if(column > 0) {
			miceProblem(row, column - 1, targetRow, targetColumn, board, pattern+"L");
		}
		
		board[row][column] = true; // removing the marked cell as non visited for future recursion to followup (######back tracking#####)
	}
	
	public static void miceProblemWithMatrix(int row, int column,int targetRow,int targetColumn,boolean[][] board,String pattern,int[][] patternMatric,int count) {
		
		if(row == targetRow && column == targetColumn) {
			patternMatric[row][column] = count; // marking the cell as visited (######back tracking#####)
			System.out.println(pattern);
			for(int i = 0;i < patternMatric.length;i++) {
				for(int j = 0;j < patternMatric[i].length;j++) {
					System.out.print(patternMatric[i][j]);
				}
				System.out.println();
			}
			return;
		}
		if(!board[row][column]) {
			return;
		}
		board[row][column] = false; // marking the cell as visited (######back tracking#####)
		patternMatric[row][column] = count; // marking the cell as visited (######back tracking#####)
		
		//Moving right
		if(column < board[row].length - 1) {
			miceProblemWithMatrix(row, column + 1, targetRow, targetColumn, board, pattern+"R",patternMatric,count+1);
		}
		//Moving Down
		if(row < board[column].length - 1) {
			miceProblemWithMatrix(row + 1, column, targetRow, targetColumn, board, pattern+"D",patternMatric,count+1);
		}
		//Moving Up
		if(row > 0) {
			miceProblemWithMatrix(row - 1, column, targetRow, targetColumn, board, pattern+"U",patternMatric,count+1);
		}
		if(column > 0) {
			miceProblemWithMatrix(row, column - 1, targetRow, targetColumn, board, pattern+"L",patternMatric,count+1);
		}
		
		board[row][column] = true; // removing the marked cell as non visited for future recursion to followup (######back tracking#####)
		patternMatric[row][column] = 0;
	
	}
	
	public static void nQueens(String[][] board,int row , int column,int counter) {
		if(board.length == row || board[row].length == column) {
			return;
		}
		board[row][column] = "Q"; // marking cell
		for(int i = row ; i < board.length ; i++) {
			if(row > 0) {
				for(int j = 0 ; j < row; j++) {
					if(row - j > 1) {
						if(board[j][column] == "Q") {
							board[row][column] = "";
							nQueens(board, row, column + 1, counter);
						}
						if(board[j][row] == "Q" && column == row) {
							board[row][column] = "";
							nQueens(board, row, column + 1, counter);
						}
					}
					else {
						if(column - 1 >= 0) {
							if(board[j][column - 1] =="Q") {
								board[row][column] = "";// back tracing removal
								nQueens(board, row, column+1,counter);
							}
						}
						if(board[j][column] == "Q") {
							board[row][column] = "";// back tracing removal
							nQueens(board, row, column+1,counter);
						}
						if(column + 1 < board[row].length) {
							if(board[j][column + 1] == "Q") {
								board[row][column] = "";// back tracing removal
								nQueens(board, row, column+1,counter);
							}
						}
					}
					
//					if(row-j>= 1) {
//						if(column - 1 >= 0) {
//							if(board[j][column - 1] =="Q") {
//								board[row][column] = "";// back tracing removal
//								nQueens(board, row, column+1,counter);
//							}
//						}
//						if(board[j][column] == "Q") {
//							board[row][column] = "";// back tracing removal
//							nQueens(board, row, column+1,counter);
//						}
//						if(column + 1 < board[row].length) {
//							if(board[j][column + 1] == "Q") {
//								board[row][column] = "";// back tracing removal
//								nQueens(board, row, column+1,counter);
//							}
//						}
//						if(row > 1) {
//							if(board[row][column] == "Q") {
//								board[row][column] = "";// back tracing removal
//								nQueens(board, row, column+1,counter);
//							}
//						}
//						
//					}
//					else {
//						if(column - 1 >= 0) {
//							if(board[j][column - 1] =="Q") {
//								board[row][column] = "";// back tracing removal
//								nQueens(board, row, column+1,counter);
//							}
//						}
//						if(board[j][column] == "Q") {
//							board[row][column] = "";// back tracing removal
//							nQueens(board, row, column+1,counter);
//						}
//						if(column + 1 < board[row].length) {
//							if(board[j][column + 1] == "Q") {
//								board[row][column] = "";// back tracing removal
//								nQueens(board, row, column+1,counter);
//							}
//						}
//						
//					}
				}
				if(board[row][column] == "") {
					String[][] newBoard = {{"","","",""},
							{"","","",""},
							{"","","",""},
							{"","","",""}
					};
					
					nQueens(newBoard, 0, counter + 1, counter+1);
				}
			}
			nQueens(board, row + 1,0, counter);
		}
		
		
	}
	
	public static void nQueenUpdated(int row,String[][] queenBoard) {
		if(row == queenBoard.length) {
			System.out.println("");
			for(String[] arr : queenBoard) {
				for(String value : arr) {
					if(value.isEmpty()) {
						System.out.print("X");
					}
					else {
						System.out.print(value);
					}
					System.out.print(" ");
				}
				System.out.println();
			}
			return;
		}
		
		for(int col = 0;col < queenBoard.length;col++) {
			if(row==0) {
				queenBoard[row][col] = "Q";
				nQueenUpdated(row+1, queenBoard);
				queenBoard[row][col] = "";
			}
			else {
				if(!checkQueen(queenBoard, row, col)) {
					queenBoard[row][col] = "Q";
					nQueenUpdated(row+1, queenBoard);
					queenBoard[row][col] = "";
				}
			}
		}
	}
	
	public static void display(String[][] board) {
		for(String[] arr : board) {
			for(String value : arr) {
				if(value.isEmpty()) {
					System.out.print("XX");
				}
				else {
					System.out.print(value);
				}
				System.out.print(" ");
			}
			System.out.println();
		}
		System.out.println();
	}
	
	public static void display(char[][] board) {
		for(char[] arr : board) {
			for(char value : arr) {
				System.out.print(value);
			}
			System.out.println();
		}
		System.out.println();
	}
	
	public static boolean checkQueen(String[][] board,int row,int col) {
		int counter = 1;
		while(row - counter >= 0 && col >= 0) {
			//left check
			if(row - counter >= 0 && col - counter >= 0) {
				if(board[row - counter][col - counter] =="Q") {
					return true;
				}
			}
			//mid check
			if(row - counter >=0) {
				if(board[row - counter][col] == "Q") {
					return true;
				}
			}
			//right check
			if(row - counter >= 0 && col + counter < board[row - counter].length) {
				if(board[row - counter][col + counter] == "Q") {
					return true;
				}
			}
			counter += 1;
		}
		return false;
	}
	
	public static int nKnight(String[][] board,int row,int col,int target) {
		if(target == 0) {
			display(board);
			return 1;
		}
		
		if(row == board.length) {
			return 0;
		}
		int count = 0;
		for(int i = col;i < board.length;i++) {
			if(row == 0) {
				board[row][i] = "KN";
				count += nKnight(board, row,i +1, target - 1);
				board[row][i] = "";
			}
			if(row > 0) {
				if(!checkForKnight(board, row, i)) {
					board[row][i] = "KN";
					count += nKnight(board, row,i +1, target - 1);
					board[row][i] = "";
				}
			}
		}
		count += nKnight(board, row+1, 0, target);
		
		return count;
		
	}
	
	public static boolean checkForKnight(String[][] board, int row ,int col) {
		if(row - 1 >= 0) {
			if(col - 2 >= 0) {
				if((board[row - 1][col - 2]).equals("KN")) {
					return true;
				}
			}
			if(col + 2 < board[row].length) {
				if((board[row - 1][col + 2]).equals("KN")) {
					return true;
				}
			}
		}
		if(row - 2 >= 0) {
			if(col - 1 >= 0) {
				if((board[row - 2][col - 1]).equals("KN")) {
					return true;
				}
			}
			if(col + 1 < board[row].length) {
				if((board[row - 2][col + 1]).equals("KN")) {
					return true;
				}
			}
		}
		return false;
	}
	
	public static void pseudoSolver(char[][] board,int row,int col) {
		if(row == board.length ) {
			display(board);
			return;
		}
		if(col == board[row].length && board[row][col - 1] != '.') {
			pseudoSolver(board, row+1, 0);
		}
		if(col != board[row].length) {
			if(board[row][col] == '.') {
				for(int i = 1;i < 10;i++){
					char value = (char) (48 + i);
					if(isAllowed(board,row,col,value)) {
						board[row][col] = value;
						pseudoSolver(board, row, col+1);
						board[row][col] = '.';
					}
				}
				if(col == board.length || board[row][col] == '.') {
					return;
				}	
			}
			else if(board[row][col] != '.') {
				pseudoSolver(board, row, col+1);
			}
		}
		else {
			return;
		}
		
	}
	
	public static boolean isAllowed(char[][] board,int row,int col,char value) {
		//left check
		for(int i = 0;i < board.length;i++) {
			if(board[row][i] == value) {
				return false;
			}
		}
		// down check
		for(int j = 0;j < board.length;j++) {
			if(board[j][col] == value) {
				return false;
			}
		}
		
		//for 3x3 check 
		int startCol = (col / 3) * 3;
		int endCol = startCol + 3;
		int startRow = (row / 3) * 3;
		int endRow = startRow + 3;
		for(int i = startRow; i < endRow;i++) {
			for(int j = startCol; j < endCol;j++) {
				if(i == row && j == col) {
					continue;
				}
				else {
					if(board[i][j] == value) {
						return false;
					}
				}
			}
		}
		return true;
	}

}

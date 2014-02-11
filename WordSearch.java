package leetcode;

import java.util.ArrayList;
import java.util.HashMap;

public class WordSearch {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public boolean exist(char[][] board, String word) {
		if (board == null) {
			return false;
		}
		if (board.length == 0) {
			return false;
		}

		if (board[0].length == 0) {
			return false;
		}

		// the first word.
		for (int i = 0; i < board.length; i++) {
			for (int m = 0; m < board[0].length; m++) {
				if (board[i][m] == word.charAt(0)) {
					
				}
			}
		}

		return false;
	}

	private boolean dfs(int index, String word,char[][] board) {
		if(index==word.length()-1){
			return true;
		}
	
		
		
		return false;
	}
}

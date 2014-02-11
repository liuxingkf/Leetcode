package leetcode;

import java.util.Stack;

public class SurroundedRegions {


	public static void main(String[] args) {

		char[][] board = new char[5][4];
		
		for (int i = 0; i < board.length; i++) {
			for (int m = 0; m < board[0].length; m++) {
				board[i][m] = 'X';
			}
		}	
		
		board[0][1] = 'O'; 
		board[1][1] = 'O'; 
		board[2][2] = 'O';
		solve(board);
		
		
		for (int i = 0; i < board.length; i++) {
			System.out.print('\n');
			for (int m = 0; m < board[0].length; m++) {
			System.out.print(board[i][m]);
			System.out.print(' ');
			}
		}
		
		
		
		
	}

	public static void solve(char[][] board) {
		if(board==null){
			return;
		}
		
		if(board[0]==null){
			return;
		}
		
		for (int i = 0; i < board.length; i++) {
			for (int m = 0; m < board[0].length; m++) {
				if(board[i][m]!='O' ||board[i][m]!='X' ){
					return;
				}
			}
		}	
		
		
		boolean[][] visited = new boolean[board.length][board[0].length];

		for (int i = 0; i < board.length; i++) {
			if (board[i][0] == 'O' && visited[i][0] == false) {
				visited[i][0] = true;
				findClique(i, 0, board, visited);
			}
			if (board[i][board[0].length - 1] == 'O'
					&& visited[i][board[0].length - 1] == false) {
				visited[i][board[0].length - 1] = true;
				findClique(i, board[0].length - 1, board, visited);
			}

		}

		for (int i = 0; i < board[0].length; i++) {
			if (board[0][i] == 'O'&&visited[0][i] ==false) {
				visited[0][i] = true;
				findClique(0, i, board, visited);
			}
			if (board[board.length - 1][i] == 'O'&&visited[board.length - 1][i] == false) {
				visited[board.length - 1][i] = true;
				findClique(board.length - 1, i, board, visited);
			}
			
		}
		
		
		for (int i = 0; i < board.length; i++) {
			for (int m = 0; m < board[0].length; m++) {
				if(board[i][m]=='O'&& visited[i][m]==false){
					board[i][m] = 'X'; 
				}
			}
		}

		return;
	}//

	private static void findClique(int x, int y, char[][] board,
			boolean[][] visited) {

		visited[x][y] = false;

		Stack<Integer> stx = new Stack<Integer>();
		Stack<Integer> sty = new Stack<Integer>();
		stx.push(x);
		sty.push(y);

		int xtmp = 0;
		int ytmp = 0;
		while (!stx.isEmpty()) {
			xtmp = stx.pop();
			ytmp = sty.pop();
			visited[xtmp][ytmp] = true;

			if (xtmp > 0) {
				if (board[xtmp - 1][ytmp] == 'O'
						&& visited[xtmp - 1][ytmp] == false) {
					stx.push(xtmp - 1);
					sty.push(ytmp);
				}
			}

			if (xtmp < board.length - 1) {
				if (board[xtmp + 1][ytmp] == 'O'
						&& visited[xtmp + 1][ytmp] == false) {
					stx.push(xtmp + 1);
					sty.push(ytmp);
				}
			}

			if (ytmp > 0) {
				if (board[xtmp][ytmp - 1] == 'O'
						&& visited[xtmp][ytmp - 1] == false) {
					stx.push(xtmp);
					sty.push(ytmp - 1);
				}
			}

			if (ytmp < board[0].length - 1) {
				if (board[xtmp][ytmp + 1] == 'O'
						&& visited[xtmp][ytmp + 1] == false) {
					stx.push(xtmp);
					sty.push(ytmp + 1);
				}
			}

		}

	}

}

package leetcode;

import java.util.HashMap;
import java.util.Map.Entry;

public class ScrambleString {

	public static void main(String[] args) {

		String s1 = "aaa";
		String s2 = "acc";

		System.out.println(isScramble(s1, s2));

	}

	public static boolean isScramble(String s1, String s2) {

		if(s1==null||s2==null){
			return false;
		}
		if (s1.equals(s2)) {
			return true;
		}
		
		
		preProcess(s1.toCharArray());
		return false;

	}

	// return whether a partial string is a scramble.

	private static HashMap<Character, int[][]> preProcess(char[] s1) {


		HashMap<Character, int[][]> count1 = new HashMap<Character, int[][]>();

		int[][] temp = null;
		for (int i = 0; i < s1.length; i++) {
			if (count1.get(s1[i]) == null) {
				count1.put(s1[i], new int[s1.length][s1.length]);
				temp = count1.get(s1[i]);
				temp[i][i] = 1;
			} else {
				temp = count1.get(s1[i]);
				temp[i][i] = 1;
			}

		}

		
		for (int[][] e : count1.values()) {
			for (int i = 0; i < s1.length; i++) {
				for (int m = i + 1; m < s1.length; m++) {
					if(e[m][m]==1){
						e[i][m] = e[i][m-1] + 1;
					}else{
						e[i][m] = e[i][m-1];
					}
				}

				for (int m = i - 1; m >= 0; m--) {
					if(e[m][m]==1){
						e[i][m] = e[i][m+1] + 1;
					}else{
						e[i][m] = e[i][m+1] ;
					}
				}

			}
		}
		
		
		
		return count1;

	}

	
	
	private boolean match(HashMap<Character, int[][]> count1,HashMap<Character, int[][]>count2){
	
		// match count array of two strings.
	//	boolean[] match = new boolean[s1.length];

		return false;
	}
	
	
	
	
	
}

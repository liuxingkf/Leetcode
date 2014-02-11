package leetcode;

import java.util.HashMap;
import java.util.HashSet;

public class DistinctSubsequences {

	public static void main(String[] args) {
		String S = "fff";
		String T = "ffff";
		System.out.println(numDistinct(S, T));
	}

	public static int numDistinct(String S, String T) {
		
		if (S == null || T == null) {
			return 0;
		}

		if(S.equals("")|| T.equals("")){
			return 0;
		}
		
		if(T.length()>S.length()){
			return 0 ;
		}
		
		char[] s = S.toCharArray();
		char[] t = T.toCharArray();

		HashMap<Character, Integer> h = new HashMap<Character, Integer>();
		int[][] a = new int[t.length][s.length];

		// generate index array for each char in T.
		int[] temp = null;
		Integer atemp = null;

		for (int m = 0; m < t.length; m++) {

			// process when char c is new.
			if (h.get(t[m]) == null) {
				h.put(t[m], m);

				for (int i = 0; i < S.length(); i++) {
					if (s[i] == t[m]) {
						a[m][i] = 1;
					}
				}

			} else {
				atemp = h.get(t[m]);
				for (int i = 0; i < S.length(); i++) {
					a[m][i] = a[atemp][i];
				}
			}

		}

		// generate accumulative array.
		int f = t.length - 1;
		while (f >= 0) {

			if (f < t.length - 1) {

				for (int i = s.length - 2; i >= 0; i--) {
					if (a[f][i] == 1) {
						a[f][i] = a[f + 1][i+1];
					}
				}

			}
			
			for (int i = s.length - 2  -( t.length -1 -f) ; i >= 0; i--) {
				a[f][i] = a[f][i + 1] + a[f][i];
			}

			f = f - 1;
		}

		return a[0][0];
	}

	public static int numDistinctRecurse(String S, String T) {
		if (S == null || T == null) {
			return 0;
		}

		return numR(S.toCharArray(), T.toCharArray(), 0, 0);

	}

	private static int numR(char[] S, char[] T, int sindex, int tindex) {

		// premitive case.

		if (tindex >= T.length) {
			return 1;
		}

		if (sindex >= S.length) {
			return 0;
		}

		int result = 0;

		for (int i = sindex; i < S.length; i++) {

			if (T[tindex] == S[i]) {
				result += numR(S, T, i + 1, tindex + 1);
			}

		}

		return result;
	}

}

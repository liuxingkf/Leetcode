package leetcode;

public class LongestPalindromicSubstring {

	public static void main(String[] args) {
		System.out.println(longestPalindrome("aaba"));
	}

	
	//possible O(N) algorithm.
	public static String longestPalindrome(String s) {
		if (s == null) {
			return null;
		}

		if (s.equals("")) {
			return null;
		}
		 
		
		
		return null;	
	}	
	
	
	
	//O(N^2) DP algorithm.
	public static String longestPalindromeDPSquare(String s) {

		if (s == null) {
			return null;
		}

		if (s.equals("")) {
			return null;
		}
		
		char[] ss = s.toCharArray();
		int[][] pa = new int[s.length()][s.length()];
		int max = 1;
		int start = 0;
		
		
		for(int i = 0;i<ss.length;i++){
			pa[i][i] = 1;
		}
		
		for(int i = 1;i<ss.length;i++){
			for(int m = 0;m<ss.length;m++){
				if(m-i-1>=0){
					if(ss[m] == ss[m-i-1]){
						pa[m-i-1][m] = 1;
						if(i+2> max){
							max = i+2;
							start = m - i - 1;
							
						}
					}
				}
				
			if(m>0){
				if(ss[m]==ss[m-1]){
					pa[m-1][m] = 0;
					if(2> max){
						max = 2;
						start = m -1;
						
					}
				}
			}
				
				
			}
		}	
		
	
		return s.substring(start, start + max);
	}
}

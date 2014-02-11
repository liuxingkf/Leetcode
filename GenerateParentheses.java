package leetcode;

import java.util.ArrayList;

public class GenerateParentheses {

	public static void main(String[] args) {

		ArrayList<String> result = generateParenthesis(4);
		for (String e : result) {
			System.out.println(e);
		}
	}

	public static ArrayList<String> generateParenthesis(int n) {
		
		int left = 0;
		int right = 0;

		char[] s = new char[2 * n];
		ArrayList<String> result = new ArrayList<String>();

		int i = 0;
		while (i < n + n) {


			if (left >= right && left < n) {
				s[i] = '(';
				left += 1;
			} else if (left == n) {
				s[i] = ')';
				right += 1;
			}

			i += 1;

			// add a result.
			if (i == n + n) {
				result.add(String.valueOf(s));

				// backtracking.
				i -= 1;
				while (i >= 0) {
					if (s[i] == ')') {
						s[i] = '1';
						right -= 1;
					} else if (s[i] == '(') {

						// can replace
						if (left - right >= 2) {
							s[i] = ')';
							right += 1;
							left -= 1;
							i += 1;
							break;
						}
						// cannot replace, so keep on backtracking.
						else {
							s[i] = '1';
							left -= 1;
							i-=1;
							continue;
						}
					
					}

					i--;
				}
				
				if(i==-1){
					return result;
				}
			
			}

		}

		return result;
	}

}

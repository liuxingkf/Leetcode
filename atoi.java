package leetcode;

import java.util.Stack;

public class atoi {

	public static void main(String[] args) {
		// System.out.println(Math.abs(Integer.MIN_VALUE));
		// System.out.println(atoi("-00134"));
		System.out.println(atoi("2147483648"));
	}

	public static int atoi(String str) {

		if (str == null) {
			return 0;
		}
		if (str.equals("")) {
			return 0;
		}
		char[] s = str.trim().toCharArray();

		int neg = 1;
		if (s[0] == '-') {
			neg = -1;
			s = str.trim().substring(1).toCharArray();
		}
		if (s[0] == '+') {
			s = str.trim().substring(1).toCharArray();
		}

		int result = 0;

		for (int i = 0; i < s.length; i++) {
			if (s[i] > '9' || s[i] < '0') {
				break;
			}

			if (neg == -1) {
				if (result == ((Integer.MIN_VALUE)) / 10) {
					if (Integer.valueOf(String.valueOf(s[i])) >= 8) {
						return Integer.MIN_VALUE;
					}
				} else if (result < (Integer.MIN_VALUE) / 10) {
					return Integer.MIN_VALUE;
				}

			} else {
				if (result == (Integer.MAX_VALUE)/10) {
					if (Integer.valueOf(String.valueOf(s[i])) >= 7) {
						return Integer.MAX_VALUE;
					}
				} else if (result > (Integer.MAX_VALUE) / 10) {
					return Integer.MAX_VALUE;
				}
			}

			result = result * 10 + neg * Integer.valueOf(String.valueOf(s[i]));

		}

		return result;
	}

}

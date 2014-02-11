package leetcode;

import java.util.Stack;

public class IntegertoRoman {

	public static void main(String[] args) {
		System.out.println(intToRoman(2000));
	}

	public static String intToRoman(int num) {
		StringBuffer str = new StringBuffer();
		Stack<Integer> st = new Stack<Integer>();
		int temp = num;
		int t = 0;

		if (temp >= 1000) {
			for (int i = 0; i < temp / 1000 ; i++) {
				str.append('M');
			}
		}

		temp = temp % 1000;

		if (temp >= 900) {
			str.append("CM");
			temp = temp % 900;
		} else if (temp >= 400) {
			if (temp / 100 == 4) {
				str.append("CD");
				temp = temp % 100;

			} else if (temp / 100 >= 5) {
				str.append('D');
				for (int i = 0; i < temp / 100 - 5; i++) {
					str.append('C');
				}
				temp = temp % 100;
			}
		} else if (temp >= 100) {
			for (int i = 0; i < temp / 100; i++) {
				str.append('C');
			}
			temp = temp % 100;
		}

		if (temp >= 90) {
			str.append("XC");
			temp = temp % 10;
		} else if (temp >= 50) {
			str.append('L');
			for (int i = 0; i < temp / 10 - 5; i++) {
				str.append('X');
			}
			temp = temp % 10;
		} else if (temp >= 40) {

			str.append('X');
			str.append('L');
			temp = temp % 10;
		}else if (temp >= 10) {
			for (int i = 0; i < temp / 10; i++) {
				str.append('X');
			}
			temp = temp % 10;

		}

		if (temp >= 9) {
			str.append('I');
			str.append('X');
		} else if (temp >= 5) {
			str.append('V');
			for (int i = 0; i < temp - 5; i++) {
				str.append('I');
			}
		} else if (temp == 4) {
			str.append('I');
			str.append('V');
		} else {
			for (int i = 0; i < temp; i++) {
				str.append('I');
			}
		}

		return str.toString();
	}

}

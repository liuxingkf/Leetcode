package leetcode;

import java.util.ArrayList;

public class PalindromeNumber {

	public static void main(String[] args) {

		System.out.println(isPalindrome(1));
	}

	public static boolean isPalindrome(int x) {

		if (x < 0) {
			return false;
		}
		if (x == 0) {
			return true;
		}

		int d = 1;
		int temp = x;
		while (temp / 10 != 0) {
			temp = temp / 10;
			d += 1;
		}

		if (d == 1) {
			return true;
		}

		int digit = 1;
		for (int i = 0; i < d - 1; i++) {
			digit *= 10;
		}

		temp = x;

		while (digit>=1) {

			
			if (((x / digit) %10)!= temp % 10) {
				return false;
			}

			digit = digit / 10;
			
			temp /= 10;
		}

	
		return true;
	}
}

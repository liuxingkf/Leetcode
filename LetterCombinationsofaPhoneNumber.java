package leetcode;

import java.util.ArrayList;

public class LetterCombinationsofaPhoneNumber {

	public static void main(String[] args) {
		ArrayList<String> result = letterCombinations("23");
		for (String e : result) {
			System.out.println(e);
		}
		System.out.println("size = " + result.size());

	}

	public static ArrayList<String> letterCombinations(String digits) {

		if (digits == null) {
			return null;
		}

		ArrayList<String> result = new ArrayList<String>();
		result.add("");

		if (digits.equals("")) {
			return result;
		}

		return lcR(result, 0, digits.toCharArray());
	}

	private static ArrayList<String> lcR(ArrayList<String> in, int index,
			char[] s) {

		if (index >= s.length) {
			return in;
		}

		ArrayList<String> temp = new ArrayList<String>();
		ArrayList<String> result = new ArrayList<String>();

		int c = Integer.valueOf(String.valueOf(s[index]));

		if (c == 1) {
			return (lcR(temp, index + 1, s));

		} else {
			int i = 0;
			int f = 3;
			char start = 0;
			if (c >= 2 && c <= 6) {
				start = (char) ('a' + (c - 2) * 3);
				f = 3;
			} else if (c == 7) {
				start = 'p';
				f = 4;
			} else if (c == 8) {
				start = 't';
				f = 3;
			} else if (c == 9) {
				start = 'w';
				f = 4;
			}

			while (i < f) {
			
				if(in.size()==0){
				temp.add(String.valueOf((char) (start + i)));	
				}else{
					for (String e : in) {
						temp.add(e + (char) (start + i));
					}
					
				}
				result.addAll(lcR(temp, index + 1, s));
				temp.clear();
				
			 i+=1;
			}

		}

		return result;
	}

}

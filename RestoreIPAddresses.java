package leetcode;

import java.util.ArrayList;

public class RestoreIPAddresses {

	public static void main(String[] args) {
		String s = "010010";

		ArrayList<String> result = restoreIpAddresses(s);
		for (String e : result) {
			System.out.println(e);
		}
	}

	public static ArrayList<String> restoreIpAddresses(String s) {
		
		ArrayList<String> result = new ArrayList<String>();
		
		if (s == null) {
			return result;
		}
		if (s.equals("")) {
			return null;
		}
		
		if(s.length()>12){
			return null;
		}
		ArrayList<Integer[]> r = new ArrayList<Integer[]>();
		restoreIpRecurse(s.toCharArray(), 0, 0, null, r);

		// generate result.
		StringBuffer temp = new StringBuffer();
		
		for (Integer[] a : r) {
			temp.append(a[0]);
			temp.append(".");
			temp.append(a[1]);
			temp.append(".");
			temp.append(a[2]);
			temp.append(".");
			temp.append(a[3]);

			result.add(temp.toString());
			temp = new StringBuffer();
		}

		return result;
	}

	private static void restoreIpRecurse(char[] s, int index, int sec,
			Integer[] ip, ArrayList<Integer[]> result) {

		if (sec >= 4) {
			if (index == s.length) {
				result.add(ip);
			}
			return;
		}

		if (s.length < index) {
			return;
		}

		Integer[] tempip = new Integer[4]; // a copy to use to next recursion.

		if (ip == null) {
			ip = new Integer[4];
		}
		for (int i = 0; i < sec; i++) {
			tempip[i] = ip[i];
		}


		if (s.length - index >= 1) {
			tempip[sec] = Integer.valueOf(String.valueOf(s[index]));
			restoreIpRecurse(s, index + 1, sec + 1, tempip, result);
		}		
		if (s.length - index >= 2 && s[index]!='0') {
			tempip[sec] = Integer.valueOf(String.valueOf(s[index])) * 10
					+ Integer.valueOf(String.valueOf(s[index + 1]));
			restoreIpRecurse(s, index + 2, sec + 1, tempip, result);
		}

		if (s.length - index >= 3 && s[index]!='0') {
			tempip[sec] = Integer.valueOf(String.valueOf(s[index])) * 100
					+ Integer.valueOf(String.valueOf(s[index + 1])) * 10
					+ Integer.valueOf(String.valueOf(s[index + 2]));
			if (tempip[sec] <= 255 && tempip[sec] >= 0) {
				restoreIpRecurse(s, index + 3, sec + 1, tempip, result);
			}

		}

	}

}

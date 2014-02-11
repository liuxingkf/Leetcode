package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

public class ThreeSum {

	public static void main(String[] args) {
		int[] num = { 0, 0, 0 };
		ArrayList<ArrayList<Integer>> result = threeSum(num);

	}

	public static ArrayList<ArrayList<Integer>> threeSum(int[] num) {

		if (num == null) {
			return null;
		}
		ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();

		if (num.length == 0) {
			return result;
		}

		HashSet<ArrayList<Integer>> hr = new HashSet<ArrayList<Integer>>();
		HashMap<Integer, Integer> h1 = new HashMap<Integer, Integer>();

		for (int i = 0; i < num.length; i++) {
			h1.put(num[i], i);
		}

		Integer temp = null;
		ArrayList<Integer> tmp = null;
		int[] r = new int[3];
		for (int i = 0; i < num.length; i++) {
			for (int m = 0; m < i; m++) {

				temp = h1.get(-(num[i] + num[m]));
				if (temp == null) {
					continue;
				}

				if (i<temp) {
					r[0] = -(num[i] + num[m]);
					r[1] = num[i];
					r[2] = num[m];
					tmp = sortResult(r);
					if (!hr.contains(tmp)) {
						hr.add(tmp);
					}

				} 
			}
		}
		result.addAll(hr);
		return result;
	}

	private static ArrayList<Integer> sortResult(int[] r) {
		Arrays.sort(r);
		ArrayList<Integer> result = new ArrayList<Integer>();
		result.add(r[0]);
		result.add(r[1]);
		result.add(r[2]);

		return result;

	}

}

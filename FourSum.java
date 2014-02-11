package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map.Entry;

public class FourSum {

	public static void main(String[] args) {
		int[] num = {1,2,3,4,4};
		System.out.println(fourSum(num,11));
	}

	public static ArrayList<ArrayList<Integer>> fourSum(int[] num, int target) {

		if (num == null) {
			return null;
		}

		HashSet<ArrayList<Integer>> result = new HashSet<ArrayList<Integer>>();

		if (num.length == 0) {
			return new ArrayList<ArrayList<Integer>>();
		}

		Arrays.sort(num);
		HashMap<Integer, ArrayList<Integer>> h = new HashMap<Integer, ArrayList<Integer>>();
		int[][] twosum = new int[num.length][num.length];

		// hashmap preprocessing.
		for (int i = 0; i < num.length; i++) {
			for (int m = 0; m < i; m++) {
				if (h.get(num[i] + num[m]) == null) {
					h.put(num[i] + num[m], new ArrayList<Integer>());
				}
				h.get(num[i] + num[m]).add(m);
				h.get(num[i] + num[m]).add(i);
				// twosum[m][i] = num[i] + num[m];
			}
		}

		ArrayList<Integer> tmp = null;
		ArrayList<Integer> item = null;

		for (int i = 0; i < num.length; i++) {
			for (int m = 0; m < i; m++) {
				tmp = h.get(target - num[i] - num[m]);

				if (tmp != null) {

					for (int n = 0; n < tmp.size(); n = n + 2) {
						if (i < tmp.get(n)) {
							item = new ArrayList<Integer>();
							item.add(num[m]);
							item.add(num[i]);
							item.add(num[tmp.get(n)]);
							item.add(num[tmp.get(n + 1)]);
						
							result.add(item);
						}
					}
				}

			}
		}

		
		return new ArrayList<ArrayList<Integer>>(result) ;
	}
}

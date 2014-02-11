package leetcode;

import java.util.HashMap;
import java.util.Map.Entry;

/*
 *  Given an unsorted array of integers, find the length of the longest consecutive elements sequence.

 For example,
 Given [100, 4, 200, 1, 3, 2],
 The longest consecutive elements sequence is [1, 2, 3, 4]. Return its length: 4.

 Your algorithm should run in O(n) complexity. */

public class LongestConsecutiveSequence {

	public static void main(String[] args) {
		int[] num = {0,-1};
		int[] c = {};
	
		System.out.println(longestConsecutive(num));
	}

	// use hash map to record the consecutive info of each number.
	// only start and end in a sequence has the length info.

	public static int longestConsecutive(int[] num) {

		if(num==null){
			return 0;
		}
		if(num.length ==0){
			return 0 ;
		}
		
		// hash table, <num[i], consecutive length>
		HashMap<Integer, Integer> hm = new HashMap<Integer, Integer>();

		Integer pre = null;
		Integer pos = null;
		int temp = 0;
		int temp1 = 0;
		for (int i = 0; i < num.length; i++) {

			if (hm.get(num[i]) != null) {
				continue;
			}

			pre = hm.get(num[i] - 1);
			pos = hm.get(num[i] + 1);

			// the number is a solo number.
			if (pre == null && pos == null) {
				hm.put(num[i], 1);
			}

			// the number is a starting point.
			if (pre == null && pos != null) {
				temp = hm.get(num[i] + 1);
				hm.put(num[i], temp + 1);
				hm.put(num[i]+temp, temp + 1);
			}

			// the number is a ending point.
			if (pre != null && pos == null) {
				temp = hm.get(num[i] - 1);
				hm.put(num[i], temp + 1);
				hm.put(num[i ]- temp, temp + 1);
			}
		
			// the number is a intermedian node.
			if (pre != null && pos != null) {
				temp = hm.get(num[i] - 1);
				temp1 = hm.get(num[i] + 1);
				
				hm.put(num[i], 0);
				hm.put(num[i ]- temp, temp + temp1 + 1);
				hm.put(num[i ]+ temp1, temp + temp1 + 1);
				
			}

		}
		
		//search the hashmap to find the longest sequence.
		int max = 0;
		for(Entry<Integer,Integer> e :hm.entrySet()){
			if(e.getValue()>max){
				max = e.getValue();
			}
		}
		
		

		return max;
	}
}

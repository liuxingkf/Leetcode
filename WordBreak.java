package leetcode;

import java.util.HashSet;
import java.util.Set;
import java.util.Stack;
import java.util.Vector;

public class WordBreak {

	/*
	 * Given a string s and a dictionary of words dict, determine if s can be
	 * segmented into a space-separated sequence of one or more dictionary
	 * words.
	 * 
	 * For example, given s = "leetcode", dict = ["leet", "code"].
	 * 
	 * Return true because "leetcode" can be segmented as "leet code".
	 */

	/*
	 * 
	 * Recursive search will cause TLE, use DP to sovle the problem.
	 */

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		HashSet<String> dict = new HashSet<String>();

		String s = "aaaaaaa";

		String[] temp = {  "aaa","aaaa"};
		for (String e : temp) {
			dict.add(e);
		}

		System.out.println(wordBreak(s, dict));
	}

	
	public static boolean wordBreak(String s, Set<String> dict) {

		if (dict == null) {
			return false;
		}

		if (dict.size() == 0) {
			return false;
		}

		boolean[][] record = new boolean[s.length()][s.length() + 1];
		String[] dicts = dict.toArray(new String[dict.size()]);
		for (String ss : dicts) {
			int temp = 0;

			while (s.indexOf(ss, temp) != -1) {
				record[s.indexOf(ss, temp)][s.indexOf(ss, temp) + ss.length()] = true;
				temp = s.indexOf(ss, temp)+1 ;
			}

		}

		// System.out.println("==");

		// process the record.
		Vector<Integer> v1 = new Vector<Integer>();
		Vector<Integer> v2 = new Vector<Integer>();
		
		for(int i = 0;i<record.length;i++){
			
			for(int m = 0;m<=record.length;m++){
				if(m<i){
					if(record[m][i]==true){
						v1.add(m);
					}
				}else if(m>i){
					if(record[i][m]==true){
						v2.add(m);
					}
				}
			}	
		
		for(Integer e: v1){
			for(Integer ee:v2){
				record[e][ee] = true;
			}
		}	
			
			
		
		v1.clear();
		v2.clear();
		}
		
		//printRecord(record);
		return record[0][record.length];
	}

	private static void printRecord(boolean[][] record) {

		System.out.println("Printing record...");

		for (int i = 0; i < record.length; i++) {

			for (int m = 0; m <= record.length; m++) {
				System.out.println("record[" + i + "][" + m + "] = "
						+ record[i][m]);
			}
		}

	}

}

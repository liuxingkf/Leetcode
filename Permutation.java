package leetcode;

import java.util.*;

public class Permutation {

	public static ArrayList<ArrayList<Integer>> permute(int[] num) {
		// Note: The Solution object is instantiated only once and is reused by
		// each test case.
		ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();

	
		permuteRecursion(num, 0,result);
		
		return result;

	}
	
	private static void permuteRecursion(int[] num, int pos ,ArrayList<ArrayList<Integer>>result) {
		 
		
		if(pos> num.length) return;
		if(pos == num.length){
			ArrayList<Integer> subresult = new ArrayList<Integer>();
			for(int e: num){
				subresult.add(e);
			}
			result.add(subresult);
			return;
		}
		
		
		
		for(int i= pos;i<num.length;i++){
			int temp = num[i];
			num[i] = num[pos];
			num[pos] = temp;
			
			permuteRecursion(num, pos+1,result);
			
			temp = num[i];
			num[i] = num[pos];
			num[pos] = temp;
			
		}
		
		return;
	}
	

	public static  ArrayList<ArrayList<Integer>> permuteUnique(int[] num) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
		ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();

		
		UniquepermuteRecursion(num, 0,result);
		return result;
    }
	

	private static void UniquepermuteRecursion(int[] num, int pos ,ArrayList<ArrayList<Integer>>result) {
		 
		
		if(pos> num.length) return;
		if(pos == num.length){
			ArrayList<Integer> subresult = new ArrayList<Integer>();
			for(int e: num){
				subresult.add(e);
			}
			result.add(subresult);
			return;
		}
		
		
		//not end yet, keep on recursion.
		for(int i= pos;i<num.length;i++){
			boolean isDuplicate = false ;
			for(int m = pos;m<i;m++){
				if(num[m]==num[i]){
					isDuplicate = true;
				
				}
			}
			
			if(!isDuplicate){
				
				int temp = num[i];
				num[i] = num[pos];
				num[pos] = temp;
				
				UniquepermuteRecursion(num, pos+1,result);
				
				temp = num[i];
				num[i] = num[pos];
				num[pos] = temp;
					
			}
			
		}
		
		return;
	}
	
	
	
}

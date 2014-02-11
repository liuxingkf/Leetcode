package leetcode;

import java.util.ArrayList;

public class PalindromePartitioning {

	
	private static void printResult(ArrayList<ArrayList<String>>result){
		for(ArrayList<String> e: result){
			System.out.println("==");
			for(String ee: e){
				System.out.println(ee);
			}
			
		}
		
	}
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "abcc";
		char[] ss = s.toCharArray();
		
		//System.out.println(isPld(ss,0,1));
		ArrayList<ArrayList<String>> result = 	partition(s);
	
	
		printResult(result);
	
	}

	
	
	
	public static ArrayList<ArrayList<String>> partition(String s) {
		if(s== null){
			return null;
		}
		
		return findPld(s.toCharArray(),0);
	
	}

	// find palindrome recursion.
	// return all possible next palindrome word.
	private static ArrayList<ArrayList<String>> findPld(char[] s, int start) {
	
		
	
		ArrayList<ArrayList<String>> result = new ArrayList<ArrayList<String>>();
		if(start==s.length){
			return result;
		}

		
		
		for(int i = start+1 ; i <= s.length; i ++){
			if(isPld(s,start, i)){
				String temp = String.valueOf(s).substring(start, i);
				//System.out.println(temp + "; start = " + start);
				
				ArrayList<ArrayList<String>> result2 = findPld(s,i);
				
				ArrayList<String> result1 = new ArrayList<String>();
				
				if(result2.size()==0){
					result1.add(temp);
					result.add(result1);
					result1 = new ArrayList<String>();;
					
				}else{
					for(ArrayList<String> e	: result2){
						
						
						result1.add(temp);
						result1.addAll(e);
						result.add(result1);
						result1 = new ArrayList<String>();;
						
					}
					
				}
				
			
			}
		
		}
		
		//System.out.println("findPld: start = " + start);
		//printResult(result);
		
		
		return result;
	}

	
	
	private static boolean isPld(char[] s, int start, int end){
	
		int t = end-1;
		for(int i  = start; i < end ; i++){
			if(s[i]!= s[t]){
				return false;
			}
			t = t-1;
		}
		
		return true;
	}
	
	
	
}

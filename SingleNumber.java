package leetcode;

import java.util.HashMap;

public class SingleNumber {
	
	
	public static int singleNumber(int[] A) {
	        // Note: The Solution object is instantiated only once and is reused by each test case.
		HashMap<Integer, Integer> hash = new HashMap<Integer, Integer> ();
		for(int e: A){
		if(hash.get(e)==null){
			hash.put(e, 1);
		}else{
			hash.put(e, hash.get(e)+1);
		}
		}
		
		for(int e:A){
			if(hash.get(e)==1){
				return e;
			}
		}
		
		return 0;
	    }
	
	public static int singleNumberWithOutExtraMemory(int[] A) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
	
		
		
		
		return 0;
	}
	
	
	
	
}

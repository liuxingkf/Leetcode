package leetcode;

import java.util.HashMap;
import java.util.HashSet;

public class TwoSum {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int[] twoSum(int[] numbers, int target) {
		
		HashMap<Integer,Integer> set = new HashMap<Integer,Integer>();
		int[] result  = new int[2];
		for(int i=0;i<numbers.length;i++){
			set.put(numbers[i], i);
		}
		
		
		Integer temp = null;
		for(int i=0;i<numbers.length;i++){
			temp =set.get(target-numbers[i]); 
			if(temp!=null&&temp!=i){
				if(temp<= i){
					result[0]= temp+1;
					result[1] = i+1;
				}else{
					result[1]= temp+1;
					result[0] = i+1;
					
				}
			
			return result;
			}
		}
		return null;
	}

}

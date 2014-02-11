package leetcode;

import java.util.ArrayList;

public class PascalsTriangle {

	public static void main(String[] args) {
		ArrayList<ArrayList<Integer>>result = generate(4);
		for(ArrayList<Integer> e: result){
		
			for(Integer ee: e){
				System.out.print(ee);
				System.out.print(' ');
				
			}
			System.out.print('\n');
			
		}
	}

	public static ArrayList<ArrayList<Integer>> generate(int numRows) {
	
		
		ArrayList<ArrayList<Integer>>result = new ArrayList<ArrayList<Integer>>();
		
		if(numRows <=0){
			return result;
		}
		
		ArrayList<Integer> temp = null;
		ArrayList<Integer> pre = null;

		result.add(new ArrayList<Integer>());	
		result.get(0).add(1);
		
		for(int i =1;i<numRows;i++){
		result.add(new ArrayList<Integer>());	
		
		pre = result.get(i-1);
		temp = result.get(i);	
		
		temp.add(pre.get(0));
		
		for(int m = 1;m<i;m++){
			temp.add(pre.get(m-1)+ pre.get(m));
			
		}
	
		temp.add(pre.get(pre.size()-1));
		
		}
		
		return result;

	}

}

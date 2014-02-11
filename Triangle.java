package leetcode;
import java.util.ArrayList;

public class Triangle {

	public static void main(String[] args) {
	
		ArrayList<ArrayList<Integer>> triangle = new ArrayList<ArrayList<Integer>>();
		triangle.add(new ArrayList<Integer>());
		triangle.add(new ArrayList<Integer>());
		triangle.get(0).add(1);
		triangle.get(1).add(3);
		triangle.get(1).add(2);
		
		System.out.println(minimumTotal(triangle));
	}

	public static int minimumTotal(ArrayList<ArrayList<Integer>> triangle) {
		ArrayList<ArrayList<Integer>> mins = new ArrayList<ArrayList<Integer>>();
		
		ArrayList<Integer> temp  = null;
		ArrayList<Integer> temp1  = null;
		ArrayList<Integer> work  = null;
			
		mins.add(new ArrayList<Integer>());
		for (Integer e : triangle.get(triangle.size() - 1)) {
			mins.get(0).add(e);
		}

		int r = 1;
		for (int i = triangle.size() - 2; i >= 0; i--) {
			mins.add(new ArrayList<Integer>());
			temp  = triangle.get(i);
			temp1 = mins.get(r-1);
			work = mins.get(r);
			for(int m = 0;m<temp.size();m++){
				if(temp1.get(m)<=temp1.get(m+1)){
					work.add(temp.get(m)+temp1.get(m));
				}else{
					work.add(temp.get(m)+temp1.get(m+1));
				}
			}
			r = r + 1;
		}

		return  mins.get(triangle.size()-1).get(0) ;
	}
}

package leetcode;

import java.util.ArrayList;


//including subset I and Subsets II problems.
public class Subsets {

	public static void main(String[] args) {

		int S[] = { 3,2, 2, 1 };
		ArrayList<ArrayList<Integer>> result = subsetsWithDup(S);

		for (ArrayList<Integer> e : result) {
			for (Integer ee : e) {
				System.out.print(ee);
				System.out.print(" ");

			}
			System.out.println();
		}

	}

	public static ArrayList<ArrayList<Integer>> subsets(int[] S) {

		if (S == null) {
			return null;
		}

		// sort the input array. use insertion sort here.
		int[] sort = new int[S.length];
		for (int i = 0; i < S.length; i++) {
			sort[i] = S[i];
		}
		int tmp = 0;

		for (int i = 1; i < sort.length; i++) {
			int m = i;

			while (sort[m] < sort[m - 1]) {

				tmp = sort[m - 1];
				sort[m - 1] = sort[m];
				sort[m] = tmp;
				m = m - 1;
				if (m == 0) {
					break;
				}
			}

		}

		// generate the result.
		ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
		ArrayList<ArrayList<Integer>> add = new ArrayList<ArrayList<Integer>>();

		ArrayList<Integer> entry = null;
		result.add(new ArrayList<Integer>());

		for (int i = 0; i < sort.length; i++) {

			for (ArrayList<Integer> e : result) {
				entry = new ArrayList<Integer>();
				entry.addAll(e);
				entry.add(sort[i]);
				add.add(entry);
			}

			result.addAll(add);
			add.clear();
		}

		return result;
	}


	public static ArrayList<ArrayList<Integer>> subsetsWithDup(int[] num) {

		if (num == null) {
			return null;
		}

		// sort the input array. use insertion sort here.
		int[] sort = new int[num.length];
		for (int i = 0; i < num.length; i++) {
			sort[i] = num[i];
		}
		int tmp = 0;

		for (int i = 1; i < sort.length; i++) {
			int m = i;

			while (sort[m] < sort[m - 1]) {

				tmp = sort[m - 1];
				sort[m - 1] = sort[m];
				sort[m] = tmp;
				m = m - 1;
				if (m == 0) {
					break;
				}
			}

		}

		// generate the result.
		ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
		ArrayList<ArrayList<Integer>> add = new ArrayList<ArrayList<Integer>>();
		ArrayList<Integer> entry = null;
		int count = 1; //count of the previous char.
		int countentry = 0;
		result.add(new ArrayList<Integer>());

		for (int i = 0; i < sort.length; i++) {
			
			if(i>0){
				if(sort[i-1] ==sort[i]){
					count += 1;
				}else{
					count = 1;
				}
			}
			
			for (ArrayList<Integer> e : result) {
				entry = new ArrayList<Integer>();
				countentry = 0;
				
				if(count!=1){
					for(Integer ee: e){
						if(ee==sort[i]){
							countentry += 1;
						}
					}
					
					if(countentry==count-1){
						entry.addAll(e);
						entry.add(sort[i]);
						add.add(entry);
					}
					
				}else if(count ==1){
					entry.addAll(e);
					entry.add(sort[i]);
					add.add(entry);
				}
				
			}

			result.addAll(add);
			add.clear();
		}

		return result;
	
	}

}

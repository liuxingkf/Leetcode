package leetcode;

import java.util.Arrays;

public class ThreeSumClosest {

	public static void main(String[] args) {
		int[] num = {-3,-2,-5,3,-4};
		System.out.println(threeSumClosest(num,-1));
	}

	public static int threeSumClosest(int[] num, int target) {

		if (num == null) {
			return 0;
		}
		if (num.length == 0) {
			return 0;
		}

		Arrays.sort(num);

		int next = 0;// binary search index.
		
		int nearest = num[0] + num[1] + num[2];
		int diff = Math.abs(num[0] + num[1] + num[2] - target);

		int tmp = 0;

		for (int i = 0; i < num.length; i++) {
			for (int m = 0; m < i; m++) {

				next = Arrays.binarySearch(num, target - num[i] - num[m]);


				if(next >=0){

					if (next >= m) {
					
					}else{
						return target;
					}

				}else{
					next = -next - 1;
				}
				
				
				if (next >= m) {
					if(m>0){
						next = m-1;
					}else{
						continue;
					}
				}

				assert(next!=num.length);
				
				tmp = Math.abs((num[next] + num[i] + num[m] - target));
					

				
				
				if (tmp < diff) {
					diff = tmp;
					nearest = num[next] + num[i] + num[m];
				}
				
				if(next>0){
					tmp = Math.abs((num[next-1] + num[i] + num[m] - target));
					if (tmp < diff) {
						diff = tmp;
						nearest = num[next-1] + num[i] + num[m];
					}
				}
			}

		}

		return nearest;
	}
}

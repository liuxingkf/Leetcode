package leetcode;

/*
 There are N children standing in a line. Each child is assigned a rating value.

 You are giving candies to these children subjected to the following requirements:

 Each child must have at least one candy.
 Children with a higher rating get more candies than their neighbors.

 What is the minimum candies you must give? 
 */

public class Candy {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] ratings = {1,3,2,1};

		System.out.println(Candy.candy(ratings));
	}

	public static int candy(int[] ratings) {

		if (ratings.length == 1) {
			return 1;
		}

		int[] d = new int[ratings.length];

		int steps = 0;

		for (int i = 1; i < ratings.length; i++) {

			System.out.println("steps = "+steps +" ; index = "+ i);
			
			if (ratings[i] > ratings[i - 1]) {
				d[i] = d[i - 1] + 1;
				
				
				if (steps > 0) {
					if (steps >= d[i-1 - steps]) {
						d[i-1 - steps] = Math.abs(steps);
					}
					
					int temp = 0;
					for (int m = i-1; m >= i - steps; m--) {
						d[m] = temp;
						temp = temp + 1;
					}

				}

				steps = 0;
			} else if (ratings[i] == ratings[i - 1]) {
				d[i] = 0;

				if (steps > 0) {
					if (steps >= d[i-1 - steps]) {
						d[i-1 - steps] = Math.abs(steps);
					}
					
					int temp = 0;
					for (int m = i-1; m >= i - steps; m--) {
						d[m] = temp;
						temp = temp + 1;
					}

				}
				steps = 0;
			} else if (ratings[i] < ratings[i - 1]) {
				d[i] = 0;
				steps = steps + 1;
			}

			
		}

		

		if (steps > 0) {
			if (steps >= d[d.length-1 - steps]) {
				d[d.length-1 - steps] = Math.abs(steps);
			}
			
			int temp = 0;
			for (int m = d.length-1; m > d.length-1 - steps; m--) {
				d[m] = temp;
				temp = temp + 1;
			}

		}
		
		System.out.println("====");
		for (int dd : d) {
			System.out.println(dd);
		}

		System.out.println("====");
		
		int result = 0;

		for (int i = 0; i < ratings.length; i++) {
			result = result + Math.abs(d[i]);
		}

		return result + ratings.length;
	}
}

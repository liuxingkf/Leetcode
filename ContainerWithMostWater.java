package leetcode;

import java.util.ArrayList;

public class ContainerWithMostWater {

	public static void main(String[] args) {

	}

	public int maxArea(int[] height) {
		if (height == null) {
			return 0;
		}
		if (height.length == 0) {
			return 0;
		}

		ArrayList<Integer> left = new ArrayList<Integer>();
		ArrayList<Integer> right = new ArrayList<Integer>();
		
		for (int i = 0; i < height.length-1; i++) {
			if(height[i]>height[i+1]){
				left.add(i);
			}
		}

		for (int i = height.length-1; i >0; i--) {
			if(height[i]>height[i-1]){
				right.add(i);
			}
		}

		
		return 0;
	}

	public int maxAreaONSquare(int[] height) {
		if (height == null) {
			return 0;
		}
		if (height.length == 0) {
			return 0;
		}
		int max = 0;
		int temp = 0;
		for (int i = 0; i < height.length; i++) {
			for (int m = 0; m < height.length; m++) {
				if (i < m) {
					temp = (height[i] > height[m]) ? height[m] : height[i];
					if (max < temp * (m - i)) {
						max = temp * (m - i);
					}
				}
			}
		}
		return max;
	}

}

package leetcode;

import java.util.HashMap;
import java.util.Map.Entry;

class Point {
	int x;
	int y;

	Point() {
		x = 0;
		y = 0;
	}

	Point(int a, int b) {
		x = a;
		y = b;
	}
}

public class MaxPointOnALine {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Point[] points = { new Point(0, 0), new Point(1, 1), new Point(0, 0) };

		MaxPointOnALine test = new MaxPointOnALine();
		System.out.println(test.maxPoints(points));
	}

	public static int maxPoints(Point[] points) {

		if ((points.length < 2)) {
			return points.length;
		}

		int maximum = 0;
		double temp = 0;
		int identical = 0;
		int max = 0;
		for (Point p : points) {
			HashMap<Double, Integer> hm = new HashMap<Double, Integer>();

			for (Point pp : points) {
				if (pp.equals(p))
					continue;

				if (pp.x == p.x && pp.y == p.y) {
					identical = identical + 1;
					continue;
				}

				temp = ((double) (pp.y - p.y)) / ((double) (pp.x - p.x));
				if (hm.get(temp) == null) {
					hm.put(temp, 1);
					if (max < 2)
						max = 1;

				} else {
					hm.put(temp, hm.get(temp) + 1);
					if (max < hm.get(temp))
						max = hm.get(temp);
				}

				temp = 0;

			}

		
			if (max == 0) {
				max =  identical + 1;
			} else {
				max =  max + identical + 1;
			}

			if(max> maximum ){
				maximum = max;
			}
			identical = 0;
			max = 0;
		}
		
		return maximum;
		
	}
}
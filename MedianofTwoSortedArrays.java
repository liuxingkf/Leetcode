package leetcode;

public class MedianofTwoSortedArrays {

	public static void main(String[] args) {

		int[] A = {2,3};
		int[] B = {};
		System.out.println(findMedianSortedArrays(A,B));
		
	}

	public static double findMedianSortedArrays(int A[], int B[]) {

		int[] sort = new int[A.length + B.length];

		int i = 0;
		int a = 0;
		int b = 0;

		while (a < A.length || b < B.length) {
			if (a >= A.length) {
				sort[i] = B[b];
				b += 1;
			} else if (b >= B.length) {
				sort[i] = A[a];
				a += 1;
			} else {
				if (A[a] <= B[b]) {
					sort[i] = A[a];
					a += 1;
				} else {
					sort[i] = B[b];
					b += 1;
				}
			}

			i += 1;
		}

		
		if((A.length+B.length)%2==0){
			return ((double)sort[sort.length/2]+ (double)sort[sort.length/2 - 1])/2;
		}else{
			return sort[sort.length/2];
		}
		
	}

}

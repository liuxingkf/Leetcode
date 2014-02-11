package leetcode;

public class MergeSortedArray {

	public static void main(String[] args) {
		int[] A = { 3, 5, 0, 0, 0 };
		int[] B = { 1, 2, 4 };
		merge(A, 2, B, 3);
		for (int e : A) {
			System.out.println(e);
		}
	}

	public static void merge(int A[], int m, int B[], int n) {

		int a = m - 1;
		int b = n - 1;
		int i = m+n-1;
		while (a >=0  && b >=0) {

			if (A[a] >= B[b]) {
				A[i] = A[a];
				a -= 1;
			} else {
				A[i] = B[b];
				b -= 1;
			}
			i -= 1;
		}

		
		if (a < 0) {
			while (b >=0) {
				A[i] = B[b];
				b -= 1;
				i -= 1;
			}
		} else if (b < 0) {
			while (a >=0) {
				A[i] = A[a];
				a -= 1;
				i -= 1;
			}

		}

		
		
		
	}

	public static void merge1(int A[], int m, int B[], int n) {

		int[] result = new int[m + n];

		int a = 0;
		int b = 0;
		int i = 0;
		while (a < m && b < n) {

			if (A[a] <= B[b]) {
				result[i] = A[a];
				a += 1;
			} else {
				result[i] = B[b];
				b += 1;
			}
			i = i + 1;
		}

		if (a == m) {
			while (b < n) {
				result[i] = B[b];
				b += 1;
				i += 1;
			}
		} else if (b == n) {
			while (a < m) {
				result[i] = A[a];
				a += 1;
				i += 1;
			}

		}

		for (int t = 0; t < A.length; t++) {
			A[t] = result[t];
		}

	}
}

package leetcode;

public class DecodeWays {

	public static void main(String[] args) {

		System.out.println(numDecodings("1212"));
	}

	public static int numDecodings(String s) {

		if (s == null) {
			return 0;
		}
		if (s.equals("")) {
			return 0;
		}

		char[] ss = s.toCharArray();

		if (ss[0] == '0') {
			return 0;
		}

		int sum = 1;
		int[] result = new int[ss.length];
		result[0] = 1;
		for (int i = 1; i < ss.length; i++) {

			if (ss[i - 1] == '0' && ss[i] == '0') {
				return 0;
			} else if (ss[i - 1] > '2' && ss[i] == '0') {
				return 0;
			} else if (ss[i] == '0') {
				if(i-2>=0){
					sum = result[i-2];
					result[i]  =sum;
				}
				else{
					sum = result[i-1];
					result[i]  =sum;
					
				}
			} else if (Integer.valueOf(String.valueOf(ss[i - 1])) * 10
					+ Integer.valueOf(String.valueOf(ss[i])) <= 26
					&& ss[i - 1] != '0'&& ss[i]!='0') {

				if(i-2>=0){
					sum = sum +   result[i - 2];
					result[i] = sum;
				}else{
					sum = 2;
					result[i] = sum;
 				}
			}

			else {
				result[i] = sum;
			}

		}

		return sum;
	}

	public static int numDecodingsRecursive(String s) {

		if (s == null) {
			return 0;
		}
		if (s.equals("")) {
			return 0;
		}
		return numDecodeRecurse(s.toCharArray(), 0);
	}

	private static int numDecodeRecurse(char[] ss, int pos) {

		if (pos > ss.length - 1) {
			return 1;
		}

		if (ss[pos] == '0') {
			return 0;
		}
		int result = 0;
		result = result + numDecodeRecurse(ss, pos + 1);

		if (pos < ss.length - 1) {
			if (Integer.valueOf(String.valueOf(ss[pos])) * 10
					+ Integer.valueOf(String.valueOf(ss[pos + 1])) <= 26) {
				result = result + numDecodeRecurse(ss, pos + 2);
			}
		}
		return result;
	}
}

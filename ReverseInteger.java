package leetcode;

import java.util.Stack;

public class ReverseInteger {

	public static void main(String[] args) {
		System.out.println(reverse(102));
	}

	public static  int reverse(int x) {

		Stack<Integer> st = new Stack<Integer>();
		
		int num = x;
		while(num!=0){
			st.push(num%10);
			num = num/10;
		}
		
		int digit = 1;
		while(!st.isEmpty()){
			
		num  = num +  digit*st.pop();
		digit*=10;
		}
		
		return num;

	}
}

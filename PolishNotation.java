package leetcode;

import java.util.Stack;

public class PolishNotation {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String[] in = {"0","3","-"  };
	
		System.out.println(PolishNotation.evalRPN(in));

	}

	public static int evalRPN(String[] tokens) {
		Stack<Integer> st = new Stack<Integer>();
		String[] operators = { "+", "-", "*", "/" };
		boolean flag = false;
		int temp = 0;
		
		for (String t : tokens) {

			for (String o : operators) {
				if (o.equals(t))
					flag = true;
			}

			if (!flag) {
				st.push(Integer.valueOf(t));
			} else {
				if (t.equals("+")) {
					st.push(st.pop() + st.pop());
				} else if (t.equals("-")) {
					
					st.push(-(st.pop() - st.pop()));

				} else if (t.equals("*")) {
					st.push(st.pop() * st.pop());

				} else if (t.equals("/")) {
					temp = st.pop();
					st.push(st.pop() /temp );
					temp = 0;
				}
			}

			flag = false;
		}
		return st.pop();

	}

}

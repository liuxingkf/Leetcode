package leetcode;

import java.util.*;

public class test {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		int[] a = { 1, 2, 3 };
		testarray(a);
		
	}

	private static int[] testarray(int[] a){
		a[0] = 0 ;
		return a;
	}
	
	public static void printResult(ArrayList<ArrayList<String>> result) {

		for (ArrayList<String> e : result) {
			StringBuffer str = new StringBuffer();
			for (String s : e) {
				str.append(' ');
				str.append(s);

			}
			System.out.println(str.toString());
		}

	}

	public static void printResultInt(ArrayList<ArrayList<Integer>> result) {

		for (ArrayList<Integer> e : result) {
			StringBuffer str = new StringBuffer();
			for (Integer s : e) {
				str.append(' ');
				str.append(s);

			}
			str.append('#');
			System.out.println(str.toString());
		}

	}

	private static void testZigZag() {
		TreeNode node = new TreeNode(1);
		node.left = new TreeNode(2);
		node.right = new TreeNode(3);
		node.left.left = new TreeNode(4);
		node.right.right = new TreeNode(5);
		// preorderTraversal(node);

		ArrayList<ArrayList<Integer>> result = ZigZag.zigzagLevelOrder(node);
		printResultInt(result);
	}

	private static void preorderTraversal(TreeNode root) {
		if (root == null) {
			return;
		}
		System.out.println(root.val);
		preorderTraversal(root.left);
		preorderTraversal(root.right);

	}

	private static void testTreeNodeSerialize() {
		String in = "{1,#,2,3}";
		TreeNode root = TreeNode.leetcodeSerialize(in);
		// preorderTraversal(root);
	}
}

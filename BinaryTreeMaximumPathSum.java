package leetcode;

import java.util.HashMap;
import java.util.Map.Entry;

public class BinaryTreeMaximumPathSum {

	public static void main(String[] args) {

		TreeNode n1 = new TreeNode(-1);
		TreeNode n2 = new TreeNode(8);
		TreeNode n3 = new TreeNode(2);
		TreeNode n4 = new TreeNode(-9);
		TreeNode n5 = new TreeNode(0);
		TreeNode n6 = new TreeNode(-3);
		TreeNode n7 = new TreeNode(-9);
		TreeNode n8 = new TreeNode(2);
		n1.left = n2;
		n1.right = n3;
		n2.right = n4;
		n3.left = n5;
		n5.left = n6;
		n6.right = n7;
		n7.right = n8;
		
		
		System.out.println(maxPathSum(n1));
	}

	
	
	public static int maxPathSum(TreeNode root) {

		if (root == null) {
			return 0;
		}

		HashMap<TreeNode, Integer> h = new HashMap<TreeNode, Integer>();

		maxR(root, h);

		int max = root.val;

		Integer left = null;
		Integer right = null;
		int temp = 0;
		int temp1 = 0;

		for (Entry<TreeNode, Integer> e : h.entrySet()) {
			left = null;
			right = null;
			temp = 0;
			temp1 = 0;
			if (e.getKey().left != null) {
				left = h.get(e.getKey().left);
			}
			if (e.getKey().right != null) {
				right = h.get(e.getKey().right);
			}

			// 1.leaf.
			if (left == null && right == null) {
				if (max < e.getKey().val) {
					max = e.getKey().val;
				}
				continue;
			}
			// 2.one child node
			if (left == null || right == null) {
				if (left == null) {
					temp = (right + e.getKey().val > e.getKey().val) ? (right + e
							.getKey().val) : e.getKey().val;
				} else {
					temp = (left + e.getKey().val > e.getKey().val) ? (left + e
							.getKey().val) : e.getKey().val;
				}

				if (max < temp) {
					max = temp;
				}

				continue;
			}

			// 3.node with two children.

			temp = e.getKey().val;
			if(left+ e.getKey().val> temp){
				temp = left + e.getKey().val;
			}
			if(right + e.getKey().val > temp){
				temp = right + e.getKey().val;
			}
			if(left + right + e.getKey().val > temp){
				temp = left + right + e.getKey().val;
			}
			
			if(temp > max){
				max = temp;
			}
			
		}

		return max;
	}

	private static int maxR(TreeNode root, HashMap<TreeNode, Integer> h) {

		if (root == null) {
			return 0;
		}

		int left = 0;
		int right = 0;
		
		if (root.left != null) {
			left = maxR(root.left, h);
		}
		if (root.right != null) {
			right = maxR(root.right, h);
		}

		int max = (left >= right) ? left : right;
		if (max <= 0) {
			h.put(root, root.val);
			return root.val;
		} else {
			h.put(root, root.val + max);
			return root.val + max;
		}
	}

}

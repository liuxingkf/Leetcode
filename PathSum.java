package leetcode;

import java.util.ArrayList;
import java.util.HashMap;

public class PathSum {

	public static void main(String[] args) {
	}

	public boolean hasPathSum(TreeNode root, int sum) {

		HashMap<TreeNode, Integer> hm = new HashMap<TreeNode, Integer>();
		ArrayList<TreeNode> leaves = new ArrayList<TreeNode>();
		sumRecurse(root, 0, hm, leaves);

		for (TreeNode e : leaves) {
			if (sum == hm.get(e)) {
				return true;
			}
		}

		return false;
	}

	private void sumRecurse(TreeNode root, int sum,
			HashMap<TreeNode, Integer> hm, ArrayList<TreeNode> leaves) {
		if (root == null) {
			return;
		}
		sum = sum + root.val;
		hm.put(root, sum);
		if (root.left == null && root.right == null) {
			leaves.add(root);
		}
		sumRecurse(root.left, sum, hm, leaves);
		sumRecurse(root.right, sum, hm, leaves);

	}

}

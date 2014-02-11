package leetcode;

import java.util.ArrayList;

public class FlattenBinaryTreetoLinkedList {

	public static void main(String[] args) {
		TreeNode n1 = new TreeNode(1);
		TreeNode n2 = new TreeNode(2);
		TreeNode n3 = new TreeNode(3);

		n1.left = n2;
		n1.right = n3;
		flatten(n1);

		System.out.println("==");

	}

	public static void flatten(TreeNode root) {

		if (root == null) {
			return;
		}

		ArrayList<TreeNode> result = new ArrayList<TreeNode>();
		preorderFlatten(root, result);

		TreeNode pre = null;
		for (TreeNode e : result) {
			if (pre == null) {
				pre = e;
				pre.left = null;
				pre.right = null;

			} else {
				pre.left = null;
				pre.right = e;
				e.left = null;
				e.right = null;
				pre = e;
			}
		}

	}

	private static void preorderFlatten(TreeNode root,
			ArrayList<TreeNode> result) {
		if (root == null) {
			return;
		}

		result.add(root);

		preorderFlatten(root.left, result);
		preorderFlatten(root.right, result);

	}

}

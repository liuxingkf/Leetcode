package leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class MinimumDepthofBinaryTree {

	public static void main(String[] args) {
		TreeNode n1 = new TreeNode(1);
		TreeNode n2 = new TreeNode(2);
		TreeNode n3 = new TreeNode(2);
		
		n1.left = n2;
		n2.right = n3;
		System.out.println(minDepth(n1));
	}

	public static  int minDepth(TreeNode root) {
		if (root == null) {
			return 0;
		}

		int level = 1;
		Queue<TreeNode> q = new LinkedList<TreeNode>();
		ArrayList<TreeNode> temp = new ArrayList<TreeNode>();
		TreeNode node = null;
		q.offer(root);

		while (!q.isEmpty()) {

			while (!q.isEmpty()) {
				node = q.poll();
				if (node.left != null) {
					temp.add(node.left);
				}

				if (node.right != null) {
					temp.add(node.right);
				}

				if (node.left == null && node.right == null) {
					return level;
				}

			}

			for (TreeNode e : temp) {
				q.offer(e);
			}

			temp.clear();
			level += 1;
		}

		return -1;
	}

}

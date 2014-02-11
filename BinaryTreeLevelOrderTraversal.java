package leetcode;

import java.util.ArrayList;

public class BinaryTreeLevelOrderTraversal {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public ArrayList<ArrayList<Integer>> levelOrder(TreeNode root) {

		ArrayList<TreeNode> nodes = new ArrayList<TreeNode>();
		ArrayList<TreeNode> nodes1 = new ArrayList<TreeNode>();

		ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();

		if (root == null) {
			return result;
		}

		nodes.add(root);
		ArrayList<Integer> record = null;
	
		while (!nodes.isEmpty()) {
			record = new ArrayList<Integer>();
			
			for (TreeNode e : nodes) {
				record.add(e.val);
				if (e.left != null) {
					nodes1.add(e.left);
				}
				if (e.right != null) {
					nodes1.add(e.right);
				}
			}

			result.add(record);
			nodes.clear();
			nodes.addAll(nodes1);
			nodes1.clear();
			
		}
		
		
		return result;
	}

}

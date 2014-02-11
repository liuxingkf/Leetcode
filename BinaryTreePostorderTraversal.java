package leetcode;

import java.util.ArrayList;
import java.util.Stack;

public class BinaryTreePostorderTraversal {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		TreeNode root = TreeNode.leetcodeSerialize("{1,#,2,3}");
		ArrayList<Integer> nodes = postorderTraversal(root);
		for(Integer e: nodes){
			System.out.println(e);
		}
	}

	
	public static ArrayList<Integer> postorderTraversalIterative(TreeNode root) {
		ArrayList<Integer> result = new ArrayList<Integer>();
		
		if(root==null){
			return result;
		}
		
		
		
		TreeNode node = null;
		TreeNode temp = null;
		
		Stack<TreeNode> st = new Stack<TreeNode>();
		st.push(root);
		
		
		
		while(!st.isEmpty()){
			
			node  = st.pop();
			result.add(node.val);
		
			if(node.left!=null){
				st.push(node.left);
			}
		
			if(node.right!=null){
				st.push(node.right);
			}
			
		}
		
		ArrayList<Integer> result2 = new ArrayList<Integer>();
		for(int  i = result.size() ;  i >0;i--){
		result2.add(result.get(i-1));
		}
		
		return result2;
		
	}

	
	
	
	public static ArrayList<Integer> postorderTraversal(TreeNode root) {
		
		return postorderT(root, new ArrayList<Integer>());
	}

	private static ArrayList<Integer> postorderT(TreeNode root,
			ArrayList<Integer> result) {

		if (root == null) {
			return result;
		}
		
		
		postorderT(root.left, result);
		postorderT(root.right, result);
		
		result.add(root.val);
		return result;
	}

}

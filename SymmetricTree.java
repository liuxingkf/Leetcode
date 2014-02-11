package leetcode;

import java.util.ArrayList;
import java.util.Stack;

public class SymmetricTree {

	public static void main(String[] args) {

	}

	public boolean isSymmetric(TreeNode root) {

		if (root == null) {
			return true;
		}

		TreeNode l = root.left;
		TreeNode r = root.right;
		
		if(l==null&& r==null){
			return true;
		}
		
		Stack<TreeNode> lst = new Stack<TreeNode>();
		Stack<TreeNode> rst = new Stack<TreeNode>();

		if (l != null) {
			lst.push(l);
		}
		if (r != null) {
			rst.push(r);
		}

		if(lst.size()!=rst.size()){
			return false;
		}
		
		if(l.val!=r.val){
			return false;
		}
		
		
		while (!lst.isEmpty()) {
			if(rst.isEmpty()){
				return false;
			}
			
			l = lst.pop();
			r = rst.pop();

			// compare value.
			if (l.val != r.val) {
				return false;
			}

			// compare number of children.
			if (l.left != null) {
				lst.push(l.left);
				if(r.right==null){
					return false;
				}else{
					rst.push(r.right);
				}
			}else{
				if(r.right!=null){
					return false;
				}
			}

			if (l.right != null) {
				lst.push(l.right);
				if(r.left==null){
					return false;
				}else{
					rst.push(r.left);
				}
			}else{
				if(r.left!=null){
					return false;
				}
			}

		}
		return true;
	}

}

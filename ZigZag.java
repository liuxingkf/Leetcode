package leetcode;

import java.util.*;

public class ZigZag {

	public static ArrayList<ArrayList<Integer>> zigzagLevelOrder(TreeNode root) {
		ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
		if(root==null){return result ;}
			
			Stack<TreeNode> st = new Stack<TreeNode>();
			Stack<TreeNode> st1= new Stack<TreeNode>();
			int level  = 0;
			TreeNode temp = null;
			TreeNode temp1 = null;
			st.push(root);
			ArrayList<Integer> resultroot = new ArrayList<Integer>();
			resultroot.add(root.val);
			result.add(resultroot);
			
			while(!st.isEmpty()){
				
				level = level+1;
				
				while(!st.isEmpty()){
					temp = st.pop();
					
					if(level%2==0){
						if(temp.right!=null) 	st1.push(temp.right);
						if(temp.left!=null)	st1.push(temp.left);
					}else{
						if(temp.left!=null)	st1.push(temp.left);
						if(temp.right!=null) 	st1.push(temp.right);
					}
					
					}
				
				//st1 has the result.
				ArrayList<Integer> subresult = new ArrayList<Integer>();
				st.addAll(st1);
					while(!st1.isEmpty()){
						temp1=(st1.pop());
						subresult.add(temp1.val);
					}
					if(!subresult.isEmpty()){
						result.add(subresult);
					}
			}
			
			return result;
	}
}

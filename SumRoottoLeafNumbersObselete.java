package leetcode;

import java.util.ArrayList;
import java.util.Stack;

public class SumRoottoLeafNumbersObselete {


	public static void main(String[] args) {

		TreeNode root = new TreeNode(1);
		TreeNode n1 = new TreeNode(2);
		TreeNode n2 = new TreeNode(3);
		TreeNode n3 = new TreeNode(4);
		
		root.left = n1;
		root.right = n2;
		//root.left.left = n3;
		System.out.println("Result  = "+sumNumbers(root));
		
		
	}

	public static int sumNumbers(TreeNode root) {

		if (root == null) {
			return 0;
		}

		ArrayList<ArrayList<Integer>> result  = new ArrayList<ArrayList<Integer>>();
		result = sum(root, result, new ArrayList<Integer>());
		//System.out.println("result.size = "+result.size());
		
		
		int sum = 0;
		int s = 0;
		for(ArrayList<Integer> e : result){
			//System.out.println("====");
			s = 0;
			
			for(Integer ee: e){
				//System.out.println(ee);
			s = s*10 + ee;
			
			}

		sum+=s;
		
		}
		
		
		
		
		return sum;
		
	}

	private static ArrayList<ArrayList<Integer>> sum(TreeNode node, 
			ArrayList<ArrayList<Integer>>result,
			ArrayList<Integer> oldpath
			){

		ArrayList<ArrayList<Integer>> returns = new ArrayList<ArrayList<Integer>>();
		ArrayList<Integer> path = new ArrayList<Integer>();
		path.addAll(oldpath);
		path.add(node.val);
		returns.addAll(result);
		
		if(node.left==null &&node.right==null){
			returns.add(path);
			return returns;
		}
		
		
		if(node.left!=null){
		returns.addAll(sum(node.left, result,path));
		}
		if(node.right!=null){
			returns.addAll(sum(node.right, result,path));
		}
		
		return returns;
		
	}
	
	
}

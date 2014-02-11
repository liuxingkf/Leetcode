package leetcode;

import java.util.Stack;

public class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;

	TreeNode(int x) {
		val = x;
	}



	public static TreeNode leetcodeSerialize(String in){
		TreeNode node = null;
		TreeNode root = null;
		Stack<TreeNode> st = new Stack<TreeNode>();
		Stack<TreeNode> st1 = new Stack<TreeNode>();
		
		if(in.indexOf('{')==-1 ||in.indexOf('}')==-1){return null;}
		
		in= in.substring(in.indexOf('{'),in.indexOf('}')).trim();
		in =in + ", ";
		in = in.replace('{', '\0');
		in = in.replace('}', '\0');
		
		String temp  = null;
		Integer val = null;
		while(in.indexOf(',')!=-1){
			temp = in.substring(0, in.indexOf(','));
			temp = temp.replace(',', '\0').trim();
		
			
			if(temp.equals("#")){
				val = null;
			}else{
			val = Integer.valueOf(temp);
			node  =  new TreeNode(val);
			}
			
			
			System.out.println(val);
			 in = in.substring(in.indexOf(',')+1);
				
		}
		return null;
	}
	
	
}

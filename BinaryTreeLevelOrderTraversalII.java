package leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class BinaryTreeLevelOrderTraversalII {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		TreeNode t1 = new TreeNode(1);
		TreeNode t2 = new TreeNode(2);
		t1.left = t2;
		levelOrderBottom(t1);
	}

	
	
	public static  ArrayList<ArrayList<Integer>> levelOrderBottom(TreeNode root) {
	       
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        if(root==null){
            return result;
        }
        
        Stack<ArrayList<Integer>> st = new Stack<ArrayList<Integer>> ();
        
         Queue<TreeNode> q = new LinkedList<TreeNode>();
         Queue<TreeNode> q1 = new LinkedList<TreeNode>();
         
         TreeNode tmp = null;
         q.offer(root);
         ArrayList<Integer> record = null;
         
         while(!q.isEmpty()){
            record  = new ArrayList<Integer>();   
            
            while(!q.isEmpty()){
            tmp = q.poll();
            record.add(tmp.val);
            
            
            
            if(tmp.left!=null){
            q1.offer(tmp.left);             
            }
       
            if(tmp.right!=null){
            q1.offer(tmp.right);             
            }
       
            }  
         

         while(!q1.isEmpty()){
             q.offer(q1.poll());
         }
         
         st.push(record);
         record = null;
         }
        
         
        while(!st.isEmpty()){
            result.add(st.pop());
        }
        
        return result;
    }
}

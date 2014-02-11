package leetcode;

import java.util.ArrayList;

public class ConvertSortedListtoBinarySearchTree {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		ListNode l1 = ListNode.serialize(new int []{-10,-3,0,5,9});
		sortedListToBST(l1);
	
	}

	
	 public static  TreeNode sortedListToBST(ListNode head) {
	        
	        ArrayList<TreeNode> al  =new ArrayList<TreeNode>();
	        
	        while(head!=null){
	            al.add(new TreeNode(head.val));
	            head = head.next;
	        }
	        
	        
	        return makeBST(al, 0, al.size()-1);
	    }
	    
	    private static TreeNode makeBST(ArrayList<TreeNode> al, int start, int end){
	        
	    	//System.out.println(start+ " ; " + end);
	    	
	    	
	        if(end<0 || start>=al.size()||end<start){
	            return null;
	        }
	        
	        if(start==end){
	        	return al.get(start);
	        }
	        
	        TreeNode root = al.get(start + (end-start+1)/2);
	        root.left =makeBST(al,start, start + (end-start+1)/2-1);
	        root.right =makeBST(al,start +(end-start+1)/2 + 1, end);
	        
	        return root;
	    }
	
}

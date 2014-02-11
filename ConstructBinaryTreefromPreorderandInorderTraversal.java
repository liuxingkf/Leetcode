package leetcode;

import java.util.HashMap;

public class ConstructBinaryTreefromPreorderandInorderTraversal {

	public static void main(String[] args) {

			int[] preorder = {1,2,3};
			int[] inorder = {1,2,3};
			buildTree(preorder,inorder);
			
	}

	
public static TreeNode buildTree(int[] preorder, int[] inorder) {
        
        if(preorder==null || inorder==null){
        return null;
        }
        
        if(preorder.length==0||inorder.length==0){
            return null;
        }
        
        TreeNode root = null;
        HashMap<Integer, Integer> h  = new HashMap<Integer,Integer>();
        //ArrayList<TreeNode> list = new ArrayList<TreeNode>();
    
        for(int i =0;i< preorder.length;i++){
        h.put(inorder[i],i);    
        }
        
        TreeNode tmp = null;
        
        
        root = makeTree(0, preorder.length-1,0,preorder,h);
        return root;
    }


    //start,end are the index range in inorder traversal. 
    //index is the index in preorder traversal.
    private static TreeNode makeTree(int start, int end, int index,int[] preorder,HashMap<Integer,Integer>h){
       
    	if(index>= preorder.length){
    		return null;
    	}
    	int i = h.get(preorder[index]);
        
        if(i<start || i> end){
            return null;
        }
        
        
        TreeNode root = new TreeNode(preorder[index]);
        root.left = makeTree(start, i-1,index+1,preorder,h);
        root.right = makeTree(i+1,end,index+i-start+1,preorder,h);
        
        return root;
    }

	
	
	
}

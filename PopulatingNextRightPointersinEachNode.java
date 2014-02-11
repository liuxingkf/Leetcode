package leetcode;

import java.util.LinkedList;
import java.util.Stack;

public class PopulatingNextRightPointersinEachNode {

	public static void main(String[] args) {

	}

	public void connect(TreeLinkNode root) {

		if (root == null) {
			return;
		}

		LinkedList<TreeLinkNode> q = new LinkedList<TreeLinkNode>();
		LinkedList<TreeLinkNode> q1 = new LinkedList<TreeLinkNode>();

		TreeLinkNode temp = null;
		TreeLinkNode pre = null;

		q.offer(root);

		while(!q.isEmpty()){
			pre = null;
			
			while(!q.isEmpty()){
				
				temp = q.poll();
				temp.next = pre;
				pre = temp;
				q1.offer(temp);
			}
			
			q.clear();
			while(!q1.isEmpty()){
				temp = q1.poll();
				if(temp.right!=null){
					q.offer(temp.right);
				}
				if(temp.left!=null){
					q.offer(temp.left);
				}
			
			}
			
		}
		return;
		
	}

}

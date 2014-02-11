package leetcode;

import java.util.HashSet;
import java.util.Vector;

public class LinkedListCycle {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public static boolean hasCycle(ListNode head) {

		if(head==null){
			return false;
		}
		
		HashSet<ListNode> ls = new HashSet<ListNode>();
		while(head!=null){
			if(ls.contains(head)){
			return true;	
			}else{
				ls.add(head);
			}
			
		head = head.next;
		}
		
		
		return false;
	}

}

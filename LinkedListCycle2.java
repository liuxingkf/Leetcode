package leetcode;

import java.util.HashSet;
import java.util.Vector;

public class LinkedListCycle2 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	
	
	//without using extra space, trade space with time.
	public ListNode detectCycle(ListNode head) {
		if(head==null){
			return null;
		}
		ListNode ite2 = head;
		ListNode ite = head;
		int len = 0;
		int i = 0;
		while(ite!=null){
			
			for(i = 0;i<len;i++){
				
				if(ite2 == ite){
					return ite;
				}
				ite2=  ite2.next;
			}

			ite = ite.next;
			len = len + 1;
			ite2 = head;
		}
		
		return null;
	}

}

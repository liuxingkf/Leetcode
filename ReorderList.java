package leetcode;

public class ReorderList {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ListNode ls = new ListNode(1);
		ListNode head = ls;

		ls.next = new ListNode(2);
		ls = ls.next;
		ls.next = new ListNode(3);
		ls = ls.next;
		ls.next = new ListNode(4);
		ls = ls.next;
		ls.next = new ListNode(5);
		ls = ls.next;
	
		head.print();

		reorderList(head);

		head.print();

	}

	public static void reorderList(ListNode head) {

		if (head == null) {
			return;
		}
		if (head.next == null) {
			return;
		}

		
		ListNode temp = null;
		
		
		// split the linked list to two.

		ListNode l1 = head;
		ListNode l2 = null;
		ListNode lhead = head;
		int n = 0;
		
		while(lhead!=null){
			n = n+1;
			lhead = lhead.next;
		}
		lhead = head;
		n = n/2 + n%2;
		
		while(n!=0){
		n = n-1;
		temp = lhead;
		lhead = lhead.next;
		
		}
		
		temp.next = null;
		l1 = head;
		l2 = lhead;
	
		// l1.print();
		// l2.print();
		
	

		// inverse l2. result is l2head;

		 temp = null;
		ListNode temp1 = null;

		while (l2 != null) {

			temp = l2.next;

			l2.next = temp1;
			
			temp1 = l2;
			
			l2 = temp;
		}

		l2 = temp1;
		
		
		
		// merge two list.

		ListNode result = l1;
		l1 = l1.next;
		result.next = null;
		boolean f = false;
		while (l1!= null && l2!= null) {
			//System.out.println("111");
			if (f) {
				result.next = l1;
				result = result.next;
				l1 = l1.next;
				result.next = null;
			} else {
				result.next = l2;
				result = result.next;
				l2 = l2.next;
				result.next = null;

			}
			f = !f;

		}

		if(l1==null){
			result.next = l2;
			result = result.next;
			result.next = null;
		}else{
			result.next = l1;
			result = result.next;
			result.next = null;
			
		}
		
		
	//	head.print();
		
	}

}

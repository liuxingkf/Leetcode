package leetcode;

public class SortList {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		// ListNode head = new ListNode(5);
		ListNode ls = new ListNode(6);
		ListNode head = ls;
		
		ls.next = new ListNode(8);
		ls = ls.next;
		
		// head.print();

		sortList(null);
	}

	private static ListNode[] splitList(ListNode head) {
		ListNode[] result = new ListNode[2];

		if (head == null) {
			return null;
		}

		if (head.next == null) {
			result[0] = head;

			return result;
		}

		boolean temp = true;

		ListNode h1 = head;
		ListNode h2 = head.next;
		ListNode head1 = h1;
		ListNode head2 = h2;

		head = head.next.next;

		h1.next = null;
		h2.next = null;
		
		while (head != null) {

			if (temp) {
				h1.next = head;
				head = head.next;

				h1 = h1.next;
				h1.next = null;
			} else {
				h2.next = head;
				head = head.next;

				h2 = h2.next;
				h2.next = null;
			}

			temp = !temp;
		}

		result[0] = head1;
		result[1] = head2;

		return result;
	}

	private static ListNode merge(ListNode l1, ListNode l2) {
		if (l1 == null && l2 == null) {
			return null;
		}

		
		ListNode result = null;
		if (l1.val <= l2.val) {
			result = l1;
			l1 = l1.next;
		} else {
			result = l2;
			l2 = l2.next;
		}


		ListNode rhead =  result;
		
		while(l1 != null && l2 != null) {

			if (l1.val <= l2.val) {
				result.next = l1;
				l1 = l1.next;
				result = result.next;
				result.next = null;

			} else {
				result.next = l2;
				l2 = l2.next;
				result = result.next;
				result.next = null;

			}

			
			
		} 

		if (l1 == null) {
			result.next = l2;
		} else if (l2 == null) {
			result.next = l1;
		}

		return rhead;
	}

	public static ListNode sortList(ListNode head) {

		if(head==null){
			return null;
		}
		
		ListNode[] splits = splitList(head);

		// only have one element in the list.
		if (splits[1] == null) {
			return head;
		}

		ListNode l1 = sortList(splits[0]);
		ListNode l2 = sortList(splits[1]);

		return merge(l1, l2);
	}

}

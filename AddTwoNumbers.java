package leetcode;

import java.util.LinkedList;
import java.util.Queue;

public class AddTwoNumbers {

	public static void main(String[] args) {

		int[] a1 = { 9, 8  };
		int[] a2 = { 1, 2};

		ListNode result = addTwoNumbers(ListNode.serialize(a1),
				ListNode.serialize(a2));
		result.print();

	}

	public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {

		if (l1 == null || l2 == null) {
			return null;
		}

		ListNode f1 = l1;
		ListNode f2 = l2;
		ListNode result = null;
		ListNode r = null;
		int up = 0;
	
		int v1 = 0;
		int v2 = 0;
		result = new ListNode((f1.val + f2.val) % 10);
		r = result;
		if (f1.val + f2.val >= 10) {
			up = 1;
		}

		f1 = f1.next;
		f2 = f2.next;

		while (f1 != null || f2 != null) {

			v1 = 0;
			v2 = 0;
			if (f1 != null) {
				v1 = f1.val;
			}
			if (f2 != null) {
				v2 = f2.val;
			}

			if (v1 + v2 + up >= 10) {
				r.next = new ListNode(v1 + v2 + up - 10);
				up = 1;
			} else {
				r.next = new ListNode(v1 + v2 + up);
				up = 0;
			}
			if(f1!=null){
				f1 = f1.next;
			}
			if(f2!=null){
				f2 = f2.next;
			}
			r = r.next;
		}

		if (up == 1) {
			r.next = new ListNode(1);
			r = r.next;
		}
		return result;

	}

}

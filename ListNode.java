package leetcode;

//used in SortList.

public class ListNode {
	int val;
	ListNode next;

	ListNode(int x) {
		val = x;
		next = null;
	}

	public void print() {
		ListNode head = this;

		System.out.println("======");

		do {
			System.out.println(head.val);
			head = head.next;
		} while (head != null);

		System.out.println("======");

	}

	public static ListNode serialize(int[] in) {
		ListNode head = new ListNode(in[0]);
		ListNode r = head;
		for(int i = 1;i< in.length;i++){
			r.next = new ListNode(in[i]);
			r = r.next;
		}
		return head;
	}

}

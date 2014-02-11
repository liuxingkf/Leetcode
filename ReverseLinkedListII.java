package leetcode;

public class ReverseLinkedListII {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ListNode n1 = new ListNode(1);
		ListNode n2 = new ListNode(2);
		ListNode n3 = new ListNode(3);
		ListNode n4 = new ListNode(4);

		n1.next = n2;
		n2.next = n3;
		n3.next = n4;
		// n1.print();
		ListNode head = reverseBetween(n1, 1, 4);
		head.print();

	}

	public static ListNode reverseBetween(ListNode head, int m, int n) {
		if(head==null){
			return null;
		}
		
		int p = 1;
		ListNode node = head;
		ListNode nodem = null;
		ListNode first = null;
		ListNode noden = null;
		ListNode temp = null;
		ListNode pre = null;

		while (node != null) {

			if (p == m - 1) {
				nodem = node;
			}
			if (p == m) {
				first = node;
			}
			if (p == n) {
				noden = node;
			}

			temp = node.next;

			if (p > m && p <= n) {

				node.next = pre;
				first.next = temp;
			}
			pre = node;
			node = temp;
			p += 1;
		}

		if (nodem != null) {
			nodem.next = noden;
		}

		if (m > 1) {
			return head;
		} else {
			return noden;
		}

	}
}

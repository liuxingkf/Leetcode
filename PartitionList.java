package leetcode;

public class PartitionList {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		ListNode n1 = new ListNode(5);
		ListNode n2 = new ListNode(3);
		ListNode n3 = new ListNode(1);
		n1.next = n2;
		n2.next = n3;
		partition(n1, 1).print();

	}

	public static ListNode partition(ListNode head, int x) {

		if(head==null){
			return null;
		}
		
		ListNode node = head;
		ListNode temp = null;
		ListNode temp1 = null;
		ListNode h1 = null;
		ListNode h2 = null;
		ListNode h2h = null;

		boolean isFirst = true;

		while (node != null) {
			temp = node.next;

			if(node.val<x){
				if(h1==null){
					head = node;
					h1 = node;
					node.next = null;
				}else{
					h1.next  = node;
					h1 = node;
					node.next = null;
				}
			}else{
				if(h2==null){
					h2h = node;
					h2 = node;
					node.next = null;
				}else{
					h2.next  = node;
					h2 = node;
					node.next = null;
				}
				
			}

			node = temp;
		}

		if(h2h!=null){
			if(h1!=null){
				h1.next  = h2h;
			}
		}
		
		
		return head;

	}

}

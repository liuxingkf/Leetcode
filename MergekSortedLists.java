package leetcode;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

public class MergekSortedLists {

	public static void main(String[] args) {
		ListNode l1 = new ListNode(1);
		ListNode l12 = new ListNode(5);
		l1.next = l12;
		ListNode l2 = new ListNode(3);
		
		ArrayList<ListNode> lists = new ArrayList<ListNode>();
		lists.add(l1);
		lists.add(l2);
		
		mergeKLists(lists).print();
	}

	public static ListNode mergeKLists(ArrayList<ListNode> lists) {
		if (lists == null) {
			return null;
		}
		ListNode head = null;
		ListNode result = null;
		ListNode node = null;

		PriorityQueue<ListNode> q = new PriorityQueue<ListNode>(50,
				new Comparator<ListNode>() {
					public int compare(ListNode a, ListNode b) {
						if (a.val > b.val)
							return 1;
						if (a.val == b.val)
							return 0;
						return -1;
					}
				});

		for (int i = 0; i < lists.size(); i++) {
			 if(lists.get(i)!=null){
					q.add(lists.get(i));
			 }
		}

		if(q.isEmpty()){
			return null;
		}
		do {
			node = q.poll();

			if (head == null) {
				head = node;
				result = node;
			} else {
				result.next = node;
				result = result.next;
			}

			if(node!=null){
				if(node.next!=null){
					q.offer(node.next);
				}
			}
			
			
		} while (node != null);

		
		return head;

	}

}

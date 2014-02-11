package leetcode;

public class InsertionSortList {

	public static void main(String[] args) {

		// ListNode head = new ListNode(5);
		ListNode ls = new ListNode(3);
		ListNode head = ls;
		
		ls.next = new ListNode(2);
		ls = ls.next;
		ls.next = new ListNode(1);
		ls = ls.next;
		
		head.print();
		insertionSortList(head).print();
		
	}
	
	
	public static ListNode insertionSortList(ListNode head) {
		if (head == null) {
			return null;
		}

		if (head.next == null) {
			return head;
		}

		ListNode ls = head; // traverser of the list.
		ListNode in = head; // traverser for insertion.
		ListNode temp = null; // the node to be inserted.
		
		while (ls.next != null) {
			
			//System.out.println("ls = " + ls.val);
			
			
			if (ls.next.val < ls.val) {
			
				//detach the node to be inserted.
				temp = ls.next;
				ls.next = ls.next.next;
				//ls = ls.next;
				temp.next = null;
				//System.out.println("temp = " + temp.val);
				
		
				// do insertion.
				if (in.val > temp.val) {
					temp.next = in;
					head = temp;
					in  = head ;
				} else {

					while (in.next != null) {

						if (in.next.val > temp.val) {
							temp.next = in.next;
							in.next = temp;
							break;
						}
						in = in.next;
					}
					in  = head;
				}

				
				
			}else{
				ls = ls.next;	
			}

			if(ls==null){
				break; //the list reach the end.
			}
			
			
			
		}//while loop.

		return head;
	}
}

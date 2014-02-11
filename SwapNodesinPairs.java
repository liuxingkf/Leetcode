package leetcode;

public class SwapNodesinPairs {

	public static void main(String[] args) {
		swapPairs(ListNode.serialize(new int[]{1,2}));
	}

	
	 public  static ListNode swapPairs(ListNode head) {
	        if(head==null){
	            return null;
	        }
	        ListNode result = (head.next==null)?head:head.next;
	        ListNode node = head;
	        ListNode pre = null;
	        ListNode tmp = null;
	        while(node!=null){
	            tmp = node;
	            if(node.next!=null){
	                node = node.next.next;
	            }else{
	                node =null;
	                continue;
	            }
	            
	            if(tmp.next!=null){
	               
	            	if(pre!=null){
	            		pre.next  =tmp.next;
		            }
	            	tmp.next.next = tmp;
	                tmp.next = node;
	            }else{
	                if(pre!=null){
	                   	pre.next = tmp;
	       	        }
	            }
	            pre = tmp;
	        }
	        
	        
	        return result;
	    }

}

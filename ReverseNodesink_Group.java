package leetcode;

import java.util.Stack;

public class ReverseNodesink_Group {

	public static void main(String[] args) {
		ListNode head = ListNode.serialize(new int[]{1,2,3,4,5});
		reverseKGroup(head,3).print();
	}

public static ListNode reverseKGroup(ListNode head, int k) {
        
        if(head==null){
            return null;
        }
        
        ListNode node = head;
        ListNode tmp = null;
        ListNode tmp1 = null;
        
        int i = 0;
        
        //set up the head.
        tmp = head;
        while(i<k-1&& tmp!=null){
                tmp = tmp.next;
                i++;
        }
        
        if(tmp!=null){
            head = tmp;
        }
        
        ListNode next = null;
        ListNode pre = null;
        
        Stack<ListNode> st = new Stack<ListNode>();
        while(node!=null){
            
            tmp = node;
            i=0;
            while(i<k-1&& tmp!=null){
                tmp = tmp.next;
                i++;
            }
        
            //if it is last k elements, and donot need to swap , return.
            if(tmp==null || i<k-1 ){
                return head;
            }else{
               next = tmp.next ; //set up the next element for current k elements. 
            }
            
            i = 0;    
            tmp = node;
           
            
            while(tmp!=null&& i<k){
            	st.push(tmp);
            	tmp = tmp.next;
            	i++;
            }
        
            
            if(pre!=null){
            	pre.next = st.peek();
            }
            
            while(st.size()>1){
            	tmp = st.pop();
            	tmp.next = st.peek();
            }
            
            tmp = st.pop();
            tmp.next = next;
            st.clear();
            pre = tmp;
            node = next;
            
        
        }
        
        
        return head;
    }

}

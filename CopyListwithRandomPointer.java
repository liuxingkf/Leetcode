package leetcode;

import java.util.HashMap;
import java.util.Vector;

public class CopyListwithRandomPointer {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		RandomListNode head = new RandomListNode(1);
		RandomListNode node = new RandomListNode(-1);
		head.next = node;
		head.random = null;
		node.random = null;
		node.next = null;
		copyRandomList(head).print();
		
	}

	
	  public static RandomListNode copyRandomList(RandomListNode head) {
		
		  if(head==null){
			  return null;
		  }
		  
		  HashMap<RandomListNode,Integer> hm = new HashMap<RandomListNode,Integer> ();
		  Vector<Integer> v = new Vector<Integer>();
		  RandomListNode ite = head;
		  
		  //build a directory of nodes.
		  int x = 0;
		  while(ite!=null){
			  hm.put(ite, x);
			  x = x + 1;
			  ite = ite.next;
		  }
		  
		  //tag the position of each additional pointer into a vector.
		  ite = head;
		  x = 0 ;
		  while(ite!=null){
			  if(ite.random==null){
				  v.add(-1);
			  }else{
				  
				  v.add(hm.get(ite.random));
			  }
			  
			  x = x + 1;
			  ite = ite.next;
		  }
		  hm.clear();
		  
		  //System.out.println(v.size());
		  
		  
		  
		HashMap<Integer, RandomListNode>  hm1 = new HashMap<Integer, RandomListNode>();
		  
		  
		  
		  RandomListNode result = null;
		  result = new RandomListNode(head.label);
		  ite = head;
		  RandomListNode resulthead = result;
		  hm1.put(0,result);
		  x = 1;
		  ite = ite.next;
		  while(ite!=null){
			  result.next = new RandomListNode(ite.label);
			  result = result.next;
			  hm1.put(x,result);
			  result.random = null;
			  result.next = null;
			  
			  x = x + 1;
			  ite = ite.next;
		  }
		  
		  
		  //use the tag vector to build random pointers.
		  ite = resulthead;
		  x = 0;
		  while(ite!=null){
			 // System.out.println(ite.label);
			  if(v.get(x)==-1){
				  ite.random = null;
			  }else{
				  ite.random = hm1.get(v.get(x));
			  }
			  x=  x + 1;
			  ite = ite.next;
		  }
		  
		  
		  return resulthead;
	    }
	
}

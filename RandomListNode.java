package leetcode;

class RandomListNode {
	int label;
	RandomListNode next, random;

	RandomListNode(int x) {
		this.label = x;
	}
	
	public void print(){
		RandomListNode ite = this;
		while(ite!=null){
			
			System.out.print("Node: " );
			System.out.print(ite.label );
			System.out.print("  " );
			if(ite.next!=null){
				System.out.print(ite.next.label );
				System.out.print(" = next. " );
			}else{
				System.out.print("null" );
				System.out.print(" = next. " );
							
			}
			if(ite.random!=null){
				System.out.print(ite.random.label );
				System.out.print(" = random. " );
			}else{
				System.out.print("null" );
				System.out.print(" = random. " );
			}
			
			
			
			
			ite = ite.next;
		}
		
	}
};
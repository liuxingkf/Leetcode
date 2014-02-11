package leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Stack;

public class CloneGraph {

	/*
	 * Clone an undirected graph. Each node in the graph contains a label and a
	 * list of its neighbors.
	 * 
	 * OJ's undirected graph serialization:
	 * 
	 * Nodes are labeled uniquely. We use # as a separator for each node, and ,
	 * as a separator for node label and each neighbor of the node.
	 * 
	 * As an example, consider the serialized graph {0,1,2#1,2#2,2}.
	 * 
	 * The graph has a total of three nodes, and therefore contains three parts
	 * as separated by #.
	 * 
	 * First node is labeled as 0. Connect node 0 to both nodes 1 and 2. Second
	 * node is labeled as 1. Connect node 1 to node 2. Third node is labeled as
	 * 2. Connect node 2 to node 2 (itself), thus forming a self-cycle.
	 */

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		UndirectedGraphNode	n1 = new UndirectedGraphNode(1);
		UndirectedGraphNode	n2 = new UndirectedGraphNode(2);
		UndirectedGraphNode	n3 = new UndirectedGraphNode(3);
		n1.neighbors.add(n1);
		n1.neighbors.add(n1);
		UndirectedGraphNode copy  = cloneGraph(n1);
		System.out.println(copy.neighbors.size());
	
		
		
		
	}

	public  static UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {

		if(node==null){
			return null;
		}
		
		
		//visited nodes in old graph.
		HashSet<UndirectedGraphNode> set = new HashSet<UndirectedGraphNode>();
		//directory of nodes in new graph.
		HashMap<Integer,UndirectedGraphNode> map = new HashMap<Integer,UndirectedGraphNode>();
		//traverse graph util stack for DFS.
		Stack<UndirectedGraphNode> st = new Stack<UndirectedGraphNode>();
		UndirectedGraphNode temp = null;
		
		st.push(node);
		
		while (!st.isEmpty()) {
			temp = st.pop();
			
			if(map.get(temp.label)==null){
				map.put(temp.label, new UndirectedGraphNode(temp.label));
			}
			

			if(!set.contains(temp)){
				set.add(temp);
			}else{
				temp = null;
				continue;
			}
		
				
			for (UndirectedGraphNode e : temp.neighbors) {
				if(!set.contains(e)){
					st.push(e);
				}
			
				if(map.get(e.label)==null){
					map.put(e.label, new UndirectedGraphNode(e.label));
				}
				
				map.get(temp.label).neighbors.add(map.get(e.label));
				
			}
		
			
			
			
			temp = null;
		}

		return map.get(node.label);
	}

}

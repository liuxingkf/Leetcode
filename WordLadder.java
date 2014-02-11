package leetcode;

import java.util.*;

public class WordLadder {

	public static void main(String[] args) {
		String start = "hit";
		String end = "cog";
		
		String[] dictarray = {"hot","dot","dog","lot","log"};
		System.out.println(dictarray.length);
		
		HashSet<String> dict  = new HashSet<String>();
		
		for(String e: dictarray){
		dict.add(e);
		}
		
		
		System.out.println(ladderLength(start,end,dict));
	}
	
	//BFS.
	public static int ladderLength(String start, String end, HashSet<String> dict) {
		
		if(start == null || end ==null || dict==null){
			return 0 ;
		}
		if(dict.size()==0){
			return 0;
		}
		
		HashMap<String, Integer> distance = new HashMap<String, Integer>();
		HashSet<String> visited = new HashSet<String>();
		HashSet<String> dicts = new HashSet<String>();
		dicts.addAll(dict);
		dicts.add(end);
		
		LinkedList<String> q = new LinkedList<String>();
		
		
		
		q.offer(start);
		distance.put(start, 0);
		String temp = null;
		
		while (!q.isEmpty()) {
			
		
			temp = q.poll();
			visited.add(temp);
			
			//System.out.println("Queue polled : "+ temp);
			
			
				for(String s: generateAdj(temp.toCharArray())){
				
					if(!dicts.contains(s)){
						continue;
					}
					
					if(distance.get(s)==null){
						if(!visited.contains(s)){
							q.offer(s);	
						}
						distance.put(s, distance.get(temp)+1);
					}else{
						if(distance.get(s)>distance.get(temp)+1){
							
						//	System.out.println("relaxing: " + s);
							
							distance.put(s, distance.get(temp)+1);
						}
					}
				}
					
		
		}

		
		
		
		if(distance.get(end)==null){
			return 0;
		}else{
			return distance.get(end)+1;
		}
		
	}

	
	private static String[] generateAdj(char[] c){
		int temp = 0;
		
		ArrayList<String> result = new ArrayList<String>();
		for(int i = 0;i<c.length;i++){
			
			for(int m = 'a';m<='z'; m++){
				if(m!=c[i]){
					temp = c[i];
					c[i] = (char) m;
				result.add(String.valueOf(c));
					c[i] =  (char) temp;
				}
			}
			
		}
		
		String[] resultstr= new String[result.size()];
		int i = 0;
		for(String e: result){
		resultstr[i] = e;
		i +=1;
		}
		
		return resultstr;
	}
	
	
	
	
}

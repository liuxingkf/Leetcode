package leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.Map;

public class LRUCache {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		LRUCache c = new LRUCache(2);
		c.set(2, 1);
		c.set(1, 1);
		System.out.println(c.get(2));
		c.set(4, 1);
		System.out.println(c.get(1));
		System.out.println(c.get(2));

	}

	private LinkedHashMap<Integer, Integer> hm = null;
	private int capacity;


	
	public LRUCache(int capacity) {
		this.capacity = capacity;
		hm =  new LinkedHashMap<Integer, Integer>(this.capacity,0.75f,true){
			
			 protected boolean removeEldestEntry(Map.Entry eldest) {
			        return size() > LRUCache.this.capacity;
			     }

			
		};
		
		
	}

	
	
	public int get(int key) {

		Integer temp = hm.get(key);
		// System.out.println(temp);
		if (temp != null) {
			return (int) temp;
		} else 	return -1;

	}

	public void set(int key, int value) {

		// if the key is present, change the value.
		if (hm.get(key) != null) {
			hm.put(key, value);
			return;
		}

		// System.out.println(hm.keySet().size());

		hm.put(key, value);
	}

}

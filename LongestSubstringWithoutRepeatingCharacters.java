package leetcode;

import java.util.HashMap;

public class LongestSubstringWithoutRepeatingCharacters {

	public static void main(String[] args) {
		String s = "wlrbbmqbhcdarzowkkyhiddqscdxrjmowfrxsjybldbefsarcbynecdyggxxpklorellnmpapqfwkhopkmco";
		System.out.println(lengthOfLongestSubstring(s));
	}

	public static int lengthOfLongestSubstring(String s) {
	
		if(s==null){
			return 0;
		}
		if(s.equals("")){
			return 0;
		}
		
		char[] ss = s.toCharArray();
		int i = 0;
		int max = 0;
		int start = 0;
		HashMap<Character,Integer> h = new HashMap<Character,Integer> (); //<char, position> hashmap.
		
		
		while(i< ss.length){
			
			if(h.get(ss[i])==null){
			
				h.put(ss[i], i);
				if(max < i-start +1){
					max  = i - start+1;
				}
				
			}else{
			
				for(int m = start ;m< h.get(ss[i]);m++){
					h.remove(ss[m]);
				}
				
				start  = h.get(ss[i])+1;
				h.put(ss[i], i);
			}
			
			
			
			i++;
		}
		return max;
	}

}

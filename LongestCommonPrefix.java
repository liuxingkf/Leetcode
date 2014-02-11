package leetcode;

public class LongestCommonPrefix {

	public static void main(String[] args) {
		String[] strs = {"aa","a"};
		System.out.println(longestCommonPrefix(strs));
	
	}

	public static String longestCommonPrefix(String[] strs) {
	
		if(strs==null){
			return null;
		}
		if(strs.length==0){
			return "";
		}
		
		int len = strs[0].length();
		
		for(int i =1 ;i< strs.length;i++){
			
			
			for(int m = 0;m<len;m++){
			
				if(m>= strs[i].length()){
					len = strs[i].length();
					break;
				}
				
				if(strs[i].charAt(m)!=strs[i-1].charAt(m)){
					len = m; 
					break;
				}
			}
			
		}
		
		
		return strs[0].substring(0,len);
	}
}

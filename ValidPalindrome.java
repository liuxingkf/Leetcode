package leetcode;

/*
 Given a string, determine if it is a palindrome, considering only alphanumeric characters and ignoring cases.

 For example,
 "A man, a plan, a canal: Panama" is a palindrome.
 "race a car" is not a palindrome.

 Note:
 Have you consider that the string might be empty? This is a good question to ask during an interview.

 For the purpose of this problem, we define empty string as valid palindrome. 
 */

public class ValidPalindrome {

	public static void main(String[] args) {
		String s = " 3?8044''0''tt08?3";
	System.out.println(isPalindrome(s));
	}

	public static  boolean isPalindrome(String s) {
		if(s==null){
			return false;
		}
		//empty string is palindrome.
		if(s.equals("")){
			return true;
		}
		
		
		char[] c = s.toCharArray();
		int m = c.length-1;
		
		for(int i = 0;i<c.length;i++){
			if(!(c[i]<='9'&& c[i]>='0' ||c[i]<='z'&& c[i]>='a' ||c[i]<='Z'&& c[i]>='A' )){
				continue;
			}
			while(!(c[m]<='9'&& c[m]>='0' ||c[m]<='z'&& c[m]>='a' ||c[m]<='Z'&& c[m]>='A' )){
				m = m-1;
			}
			
			
			if(c[i]>'9'&&c[m]>'9'){
				if((c[i] - c[m])%32 != 0 ){
					return false;	
				}
			}else{
				if(c[i]!=c[m]){
					return false;
				}
			}
			
			
			m= m-1;
			
		}
	
		
		return true;
	}

}

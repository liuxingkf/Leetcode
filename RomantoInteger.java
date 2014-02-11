package leetcode;

import java.util.Stack;

public class RomantoInteger {

	public static void main(String[] args) {
		System.out.println(romanToInt("L"));
	}

	public static int romanToInt(String s) {

		if (s == null) {
			return 0;
		}

		if (s.equals("")) {
			return 0;
		}
		int result = 0;
		int i = 0;
		char pre = '\0';
		char post = s.charAt(0);
		char temp = '\0';
		
		
		while (i < s.length()) {
			temp = post;//current char.
			if(i<s.length()-1){
				post = s.charAt(i+1);
			}else{
				post = '\0';
			}
			if (pre == 'C' && temp == 'M') {
				result += 900;
			} else if (pre != 'C' && temp == 'M') {
				result += 1000;
			} else if(pre =='C' && temp=='D'){
				result += 400;
			}else if(pre!='C' && temp=='D'){
				result+= 500;
			}else if(pre == 'X' && temp=='C'){
				result+= 90;
			}else if(pre!= 'X' && temp=='C'&& post!='M'&& post!='D'){
				result +=100;
			}else if(pre=='X'&& temp =='L'){
				result+= 40;
			}else if(temp=='L'){
				result+=50;
			}else if(pre=='I' && temp == 'X'){
				result+=9;
			}else if(temp=='X'&& post!='L'&&post!='C'){
				result+=10;
			}else if(temp=='V'&& pre=='I'){
				result += 4;
			}else if(temp=='V'){
				result+=5;
			}else if(temp=='I'&& post!='X' &&post!='V'){
				result+=1;
			}	
			

			pre = s.charAt(i);
			i += 1;
		}

		return result;
	}
}

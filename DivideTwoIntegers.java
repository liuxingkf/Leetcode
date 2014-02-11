package leetcode;

public class DivideTwoIntegers {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(divide(2147483647,3));
	}

	
	public static  int divide(int dividend, int divisor) {
        int result = 0;
        boolean neg = false;
        if(divisor ==0){
            return 0; //to be discussed.
        }
        
        
        //set up sign.
        if(dividend>0 && divisor<0 || dividend< 0 && divisor>0){
            neg = true;
        }
        dividend = dividend>0?-dividend:dividend;
        divisor = divisor>0?-divisor:divisor;
        
        //quick process.
        if(dividend> divisor){
        	return 0;
        }
        
        int div = divisor;
        int dnum = 1;
       
        int pre = dividend;
        int preresult = result ;
        
        while(true){
        	if(dividend==0){
        		return neg?(-result):result;
        	}
        	else if(dividend>0 && dividend <= - divisor){
                result-=1;
        		return neg?(-result):result;
            }
            
            else if(dividend < 0 && dividend> divisor){
                return neg?(-result):result;
            }
            else if(dividend < 0 && dividend== divisor){
                return neg?(-result-1):result+1;
            }
        
        	
        	
        	   //if cross the boundary a lot, backtrack and start from divisor.
            if(dividend > -divisor ){
            	result = preresult ;
                dividend = pre;
                div = divisor;
                dnum = 1;
                continue;
            }
          
            preresult = result;
            pre = dividend;
        	dividend = dividend - div;
            result+=dnum;
        	div  = div + div;
           
            dnum+=dnum;
           
      
        }
    }
	
}

package leetcode;

public class BestTimetoBuyandSellStock {

	public static void main(String[] args) {
		
		int[] prices = {1,1,1,1};
		System.out.println(maxProfit(prices));
	}
	
	public static  int maxProfit(int[] prices) {
	
		if(prices==null){
			return 0 ;
		}
		if(prices.length==0){
			return 0 ;
		}
		int[] low = new int[prices.length];
		int[] high = new int[prices.length];
		
		int min = prices[0];
		low[0]  = min;
		int max = prices[prices.length-1];
		high[prices.length-1] = prices[prices.length-1];
		for(int i = 0;i<prices.length;i++){
			if(prices[i] < min){
				min = prices[i];
			}
			low[i] = min;
			
			if(prices[prices.length-1-i]>max){
				max = prices[prices.length-1-i];
			}
			high[prices.length-1-i] = max;
		}
		
		int result = high[0]-low[0];
		for(int i=0;i<prices.length;i++){
			if(high[i]-low[i]>result){
				result = high[i]-low[i];
			}
			
		}
	
		/*
		for(int i = 0;i<prices.length;i++){
			System.out.println(low[i] + " " + high[i]);
		}
		*/
		return result;
	}
}

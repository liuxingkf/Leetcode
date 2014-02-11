package leetcode;

public class BestTimetoBuyandSellStockIII {

	public static void main(String[] args) {
		int[] prices = {2,4,1};
	System.out.println(maxProfit(prices));
	}

	public static int maxProfit(int[] prices) {
		if(prices==null){
			return 0 ;
		}
		if(prices.length==0){
			return 0 ;
		}
		
		if(prices.length==1){
			return 0 ;
		}
		int[] low = new int[prices.length];
		int[] high = new int[prices.length];
		int[] lowr = new int[prices.length];
		int[] highr = new int[prices.length];
	
		int min = prices[0];
		low[0]  = min;
		int max = prices[prices.length-1];
		high[prices.length-1] = max;
		int minr = prices[prices.length-1];
		lowr[prices.length-1] = minr;
		int maxr = prices[0];
		highr[0] = maxr;
		
		for(int i = 0;i<prices.length;i++){
			if(prices[i] < min){
				min = prices[i];
			}
			low[i] = min;
			
			if(prices[i]> maxr){
				maxr = prices[i];
			}
			highr[i] = maxr;
			
			if(prices[prices.length-1-i]>max){
				max = prices[prices.length-1-i];
			}
			high[prices.length-1-i] = max;
		
			if(prices[prices.length-1-i]<minr){
				minr = prices[prices.length-1-i];
			}
			lowr[prices.length-1-i] = minr;
		
		}
		
		int result = 0;
		
		
		for(int i = 0;i<prices.length-1;i++){
			if(highr[i] - low[i] + high[i+1] - lowr[i+1]>result){
				result = highr[i] - low[i] + high[i+1] - lowr[i+1];
			};
		
		}
		
		for(int i = 0;i<prices.length;i++){
			if(high[i]-low[i]>result){
				result = high[i]-low[i];
			}
		}
		
		
		
		
		return result;

	}
}

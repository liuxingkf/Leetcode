package leetcode;

public class CopyOfBestTimetoBuyandSellStockIII {

	public static void main(String[] args) {

	int[] prices = {1,2};
	System.out.println(maxProfit(prices));
	}

	public static int maxProfit(int[] prices) {

		if(prices==null){
			return 0 ;
		}
		if(prices.length==0){
			return 0 ;
		}
		
		
		int p = 0;
		
		for(int i = 1;i<prices.length;i++){
			if(prices[i]>prices[i-1]){
			p = p + prices[i] - prices[i-1];
			}
			
		}
		
		return p;
	}
}

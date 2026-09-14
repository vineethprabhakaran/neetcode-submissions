class Solution {
    public int maxProfit(int[] prices) {
        
        int maxProfit = 0;
        int min = prices[0];
        for(int price : prices){
            min = Math.min(min, price);
            maxProfit = Math.max(maxProfit, price - min);
        }
        return maxProfit;
    }
}

class Solution {
    public int maxProfit(int[] prices) {
        int currProfit = 0, maxProfit = 0, currMin = prices[0];
        for (int i=1; i<prices.length; i++) {
            currProfit = prices[i] - currMin;
            maxProfit = Math.max(currProfit, maxProfit);
            currMin = Math.min(currMin, prices[i]);
        }
        return maxProfit;        
    }
}

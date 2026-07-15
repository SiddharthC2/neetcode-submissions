class Solution {
    public int maxProfit(int[] prices) {
        int currMax = 0, maxProfit = 0, currProfit;
        for (int i=prices.length-1; i>=0; i--) {
            currProfit = currMax - prices[i];
            maxProfit = Math.max(maxProfit, currProfit);
            currMax = Math.max(currMax, prices[i]);
        }
        return maxProfit;
    }
}

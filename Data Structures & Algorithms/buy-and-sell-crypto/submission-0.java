class Solution {
    public int maxProfit(int[] prices) {
        int[] suffixMax = new int[prices.length];
        suffixMax[prices.length-1] = 0;
        for (int i=prices.length-2; i>=0; i--) {
            suffixMax[i] = Math.max(suffixMax[i+1], prices[i+1]);
        }

        int maxProfit = 0;
        for (int i=0; i<prices.length; i++) {
            maxProfit = Math.max(suffixMax[i] - prices[i], maxProfit);
        }
        return maxProfit;
    }
}

class Solution {
    public int climbStairs(int n) {
        final int[] dp = new int[n+1];
        Arrays.fill(dp, -1);
        return topDown(n, dp);
    }

    private int topDown(final int n, final int[] dp) {
        if (n <= 0) return 0;
        if (n == 1 || n == 2) return n;
        if (dp[n] != -1) return dp[n];
        dp[n] = topDown(n-1, dp) + topDown(n-2, dp);
        return dp[n];
    }
}

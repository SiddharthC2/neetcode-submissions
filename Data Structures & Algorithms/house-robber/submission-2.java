class Solution {
    public int rob(int[] nums) {
        final int[] dp = new int[nums.length];
        Arrays.fill(dp, -1);
        return topDown(nums, dp, nums.length-1);
    }

    private int topDown(final int[] nums, final int[] dp, final int idx) {
        if (idx == 0) return nums[0];
        if (idx < 0) return 0;
        if (dp[idx] >= 0) return dp[idx];
        dp[idx] = Math.max(
            nums[idx]+topDown(nums, dp, idx-2), topDown(nums, dp, idx-1));
        return dp[idx];
    }
}

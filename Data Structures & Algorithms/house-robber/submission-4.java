class Solution {
    public int rob(int[] nums) {
        if (nums.length == 1) return nums[0];
        return bottomUp(nums);
    }

    int bottomUp(final int[] nums) {
        int prev2 = nums[0];
        int prev = Math.max(nums[1], prev2);
        int curr = prev;
        for (int i=2; i<nums.length; i++) {
            curr = Math.max(nums[i]+prev2, prev);
            prev2 = prev;
            prev = curr;
        }
        return curr;
    }
}

class Solution {
    public int missingNumber(int[] nums) {
        int missing_num = 0;
        for (int num: nums) {
            missing_num = missing_num ^ num;
        }
        for (int i=0; i<=nums.length; i++) {
            missing_num = missing_num ^ i;
        }
        return missing_num;
    }
}

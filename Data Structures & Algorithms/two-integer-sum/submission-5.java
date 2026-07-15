class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> numIdxMap = new HashMap<>();
        for (int i=0; i<nums.length; i++) {
            numIdxMap.put(nums[i], i);
        }
        Integer value;
        for (int i=0; i<nums.length; i++) {
            value = numIdxMap.get(target - nums[i]);
            if (value != null && value > i) {
                return new int[] {i, value};
            }
        }
        return null;
    }
}

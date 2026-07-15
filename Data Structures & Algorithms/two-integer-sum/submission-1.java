class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> visitedNumIdx = new HashMap<>();
        int diff, num;
        Integer remainder;
        for (int i=0; i<nums.length; i++) {
            num = nums[i];
            diff = target - num;
            if (visitedNumIdx.containsKey(diff)) {
                return new int[]{visitedNumIdx.get(diff), i};
            }
            if (!visitedNumIdx.containsKey(num)) {
                visitedNumIdx.put(num, i);
            }
        }
        return null;
    }
}

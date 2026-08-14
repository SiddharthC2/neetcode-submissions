class Solution {
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        Arrays.sort(nums);
        List<List<Integer>> combinations = new ArrayList<>();
        combinationSum(nums, target, 0, new ArrayList<>(), combinations);
        return combinations;
    }

    private void combinationSum(
        final int[] nums,
        final int rem,
        final int idx,
        final List<Integer> currlist,
        final List<List<Integer>> combinations
    ) {
        if (rem == 0) {
            combinations.add(new ArrayList<>(currlist));
            return;
        } else if (idx >= nums.length || rem < 0) {
            return;
        }
        currlist.add(nums[idx]);
        combinationSum(nums, rem-nums[idx], idx, currlist, combinations);
        currlist.remove(currlist.size()-1);
        combinationSum(nums, rem, idx+1, currlist, combinations);
    }
}

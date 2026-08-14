class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> subsets = new ArrayList<>();
        subsets(nums, 0, new ArrayList<>(), subsets);
        return subsets;
    }

    private void subsets(final int[] nums, final int idx,
        final List<Integer> currset, final List<List<Integer>> subsets) {
            if (idx == nums.length) {
                subsets.add(new ArrayList<>(currset));
                return;
            }
            subsets(nums, idx+1, currset, subsets);
            currset.add(nums[idx]);
            subsets(nums, idx+1, currset, subsets);
            currset.remove(currset.size()-1);
        }
}

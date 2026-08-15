class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> subsets = new ArrayList<>();
        subsetsWithDup(nums, 0, nums[0]-1, new ArrayList<>(), subsets);
        return subsets;
    }

    private void subsetsWithDup(
        final int[] nums,
        final int idx,
        final int prev,
        final List<Integer> currlist,
        final List<List<Integer>> subsets
    ) {
        if (idx == nums.length) {
            subsets.add(new ArrayList<>(currlist));
            return;
        }
        if (prev != nums[idx]) {
            subsetsWithDup(nums, idx+1, prev, currlist, subsets);
        }
        currlist.add(nums[idx]);
        subsetsWithDup(nums, idx+1, nums[idx], currlist, subsets);
        currlist.remove(currlist.size()-1);
    }
}

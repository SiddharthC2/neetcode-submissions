class Solution {
    public List<List<Integer>> permute(int[] nums) {
        final List<List<Integer>> permutations = new ArrayList<>();
        permute(nums, new HashSet<>(), new ArrayList<>(), permutations);
        return permutations;
    }

    private void permute(
        final int[] nums,
        final Set<Integer> set,
        final List<Integer> currlist,
        final List<List<Integer>> permutations
    ) {
        if (currlist.size() == nums.length) {
            permutations.add(new ArrayList<>(currlist));
            return;
        }
        for (int i=0; i<nums.length; i++) {
            if (set.contains(nums[i])) {
                continue;
            }
            set.add(nums[i]);
            currlist.add(nums[i]);
            permute(nums, set, currlist, permutations);
            set.remove(nums[i]);
            currlist.remove(currlist.size()-1);
        }
    }
}

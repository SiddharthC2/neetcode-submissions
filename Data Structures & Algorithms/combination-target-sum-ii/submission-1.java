class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> combinations = new ArrayList<>();
        combinationSum2(candidates, target, 0, new ArrayList<>(), combinations);
        return combinations;
    }

    private void combinationSum2(
        final int[] candidates,
        final int rem,
        final int idx,
        final List<Integer> currlist,
        final List<List<Integer>> combinations
    ) {
        if (rem == 0) {
            combinations.add(new ArrayList<>(currlist));
            return;
        } else if (idx >= candidates.length || rem < candidates[idx]) {
            return;
        }
        // System.out.println(idx+", "+rem+", "+currlist);
        currlist.add(candidates[idx]);
        combinationSum2(candidates, rem-candidates[idx], idx+1, currlist, combinations);
        currlist.remove(currlist.size()-1);

        int j = idx+1;
        while (j<candidates.length && candidates[j] == candidates[idx]) j++;
        combinationSum2(candidates, rem, j, currlist, combinations);
    }
}

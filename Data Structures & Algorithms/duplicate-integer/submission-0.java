class Solution {
    public boolean hasDuplicate(int[] nums) {
        Set<Integer> visitedNums = new HashSet<>();
        for (int num: nums) {
            if (visitedNums.contains(num)) {
                return true;
            }
            visitedNums.add(num);
        }
        return false;
    }
}
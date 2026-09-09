class Solution {
    public boolean hasDuplicate(int[] nums) {
        final Set<Integer> visited = new HashSet<>();
        for (int num: nums) {
            if (visited.contains(num)) {
                return true;
            }
            visited.add(num);
        }
        return false;
    }
}
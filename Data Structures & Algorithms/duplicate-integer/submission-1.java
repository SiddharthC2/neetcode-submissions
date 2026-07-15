class Solution {
    public boolean hasDuplicate(int[] nums) {
        Set<Integer> visited = new HashSet<Integer>();
        for (Integer num: nums) {
            if (visited.contains(num)) {
                return true;
            } else {
                visited.add(num);
            }
        }
        return false;        
    }
}
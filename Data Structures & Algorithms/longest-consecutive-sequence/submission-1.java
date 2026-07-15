class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> uniqueNums = new HashSet<>();
        for (int num: nums) {
            uniqueNums.add(num);
        }
        Set<Integer> uniqueStarters = new HashSet<>();
        for (int num: uniqueNums) {
            if (num == Integer.MIN_VALUE || !uniqueNums.contains(num-1)) {
                uniqueStarters.add(num);
            }
        }
        int maxConSeq = 0, currConSeq;
        for (int num: uniqueStarters) {
            currConSeq = 0;
            for (int currNum = num; 
                currNum<=Integer.MAX_VALUE && uniqueNums.contains(currNum);
                currNum++
            ) {
                currConSeq++;
            }
            maxConSeq = Math.max(maxConSeq, currConSeq);
        }
        return maxConSeq;
    }
}

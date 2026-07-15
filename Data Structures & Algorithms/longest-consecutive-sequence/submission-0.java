class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> presentNums = new HashSet<>();
        for (int num: nums) {
            presentNums.add(num);
        }

        int currCount, maxCount = 0, currNum;
        for (int num: nums) {
            if (!presentNums.contains(num-1)) {
                currCount = 0;
                currNum = num;
                do {
                    currCount++;
                    currNum++;
                } while (presentNums.contains(currNum));
                maxCount = Math.max(currCount, maxCount);
            }
        }
        return maxCount;
    }
}

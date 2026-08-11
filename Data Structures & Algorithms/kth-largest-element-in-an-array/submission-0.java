class Solution {
    public int findKthLargest(int[] nums, int k) {
        int[] numFreq = new int[2001];
        int maxNum = Integer.MIN_VALUE;
        for (int num: nums) {
            numFreq[num+1000]++;
            maxNum = Math.max(maxNum, num);
        }
        maxNum += 1000;
        while (k>0) {
            if (numFreq[maxNum] >= k) {
                return maxNum-1000;
            } else {
                k -= numFreq[maxNum];
            }
            maxNum--;
        }
        return -1;
    }
}

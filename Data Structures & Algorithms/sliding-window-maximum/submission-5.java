class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int[] maxWinNums = new int[nums.length-k+1];
        Deque<Integer> deque = new ArrayDeque<>();
        int left = 0, right = 0;
        while (right < nums.length) {
            while (!deque.isEmpty() && nums[deque.peekLast()] < nums[right]) {
                deque.pollLast();
            }
            deque.offerLast(right);
            
            if (right - left + 1 == k) {
                if (left > deque.peekFirst()) {
                    deque.pollFirst();
                }
                maxWinNums[left] = nums[deque.peekFirst()];
                left++;
            }
            right++;
        }
        return maxWinNums;
    }
}
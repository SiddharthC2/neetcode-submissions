class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int[] maxWinNums = new int[nums.length-k+1];
        Deque<Integer> deque = new LinkedList<>();
        int left = 0, right = 0;
        while (right < k) {
            while (!deque.isEmpty() && nums[deque.getLast()] < nums[right]) {
                deque.removeLast();
            }
            deque.addLast(right);
            right++;
        }
        maxWinNums[left] = nums[deque.getFirst()];
        left++;
        if (left > deque.getFirst()) {
            deque.removeFirst();
        }
        while (right < nums.length) {
            while (!deque.isEmpty() && nums[deque.getLast()] < nums[right]) {
                deque.removeLast();
            }
            deque.addLast(right);
            right++;
            
            maxWinNums[left] = nums[deque.getFirst()];
            left++;
            if (left > deque.getFirst()) {
                deque.removeFirst();
            }
        }
        return maxWinNums;
    }
}
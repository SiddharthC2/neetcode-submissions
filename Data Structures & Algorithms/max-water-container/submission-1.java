class Solution {
    public int maxArea(int[] heights) {
        int left, right, currMax, maxValue=0, minHeight;
        left = 0;
        right = heights.length-1;
        while (left < right) {
            if (heights[left] < heights[right]) {
                currMax = heights[left]*(right-left);
                left++;
            } else {
                currMax = heights[right]*(right-left);
                right--;
            }
            maxValue = Math.max(maxValue, currMax);
        }
        return maxValue;
    }
}

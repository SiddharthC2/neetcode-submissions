class Solution {
    public int trap(int[] height) {
        int maxRainWater = 0, hlen = height.length, left = 0, right = hlen-1;
        int leftMax = height[left], rightMax = height[right];
        while (left < right) {
            if (leftMax < rightMax) {
                left++;
                leftMax = Math.max(leftMax, height[left]);
                maxRainWater += (leftMax - height[left]);
            } else {
                right--;
                rightMax = Math.max(rightMax, height[right]);
                maxRainWater += (rightMax - height[right]);
            }
        }
        return maxRainWater;
    }
}

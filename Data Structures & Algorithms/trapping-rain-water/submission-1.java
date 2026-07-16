class Solution {
    public int trap(int[] height) {
        int maxRainWater = 0, hlen = height.length;
        int[] leftMax = new int[hlen];
        int[] rightMax = new int[hlen];
        leftMax[0] = height[0];
        rightMax[hlen-1] = height[hlen-1];
        for (int i=1; i<hlen; i++) {
            leftMax[i] = Math.max(height[i], leftMax[i-1]);
            rightMax[hlen-i-1] = Math.max(height[hlen-i-1], rightMax[hlen-i]);
        }
        for (int i=0; i<hlen; i++) {
            maxRainWater += Math.min(leftMax[i], rightMax[i]) - height[i];
        }
        return maxRainWater;
    }
}

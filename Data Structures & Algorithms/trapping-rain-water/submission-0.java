class Solution {
    public int trap(int[] height) {
        int maxArea = 0;
        int[] prefixMax = new int[height.length];
        int[] suffixMax = new int[height.length];
        for (int i=1; i<height.length; i++) {
            prefixMax[i] = Math.max(prefixMax[i-1], height[i-1]);
            suffixMax[height.length-i-1] = Math.max(suffixMax[height.length-i], height[height.length-i]);
        }
        // System.out.println(Arrays.stream(prefixMax).boxed().toList());
        // System.out.println(Arrays.stream(suffixMax).boxed().toList());
        int minHeight;
        for (int i=0; i<height.length; i++) {
            minHeight = Math.min(prefixMax[i], suffixMax[i]);
            if (height[i] < minHeight) {
                maxArea += (minHeight - height[i]);
            }
        }
        return maxArea;
    }
}

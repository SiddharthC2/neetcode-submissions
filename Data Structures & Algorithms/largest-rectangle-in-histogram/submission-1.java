class Solution {

    private class HeightDetail {
        int height;
        int idx;

        HeightDetail(int height, int idx) {
            this.height = height;
            this.idx = idx;
        }
    }

    public int largestRectangleArea(int[] heights) {
        int maxArea = 0;
        HeightDetail[] heightStack = new HeightDetail[heights.length+1];
        int stackTop = 0;
        heightStack[stackTop] = new HeightDetail(0, -1);
        int currMaxArea; 
        for (int i=0; i<heights.length; i++) {
            currMaxArea = heights[i];
            for (int j=stackTop; j>0; j--) {
                currMaxArea = Math.max(
                    currMaxArea,
                    Math.min(heights[i], heightStack[j].height) * (i-heightStack[j-1].idx)
                );
            }
            while (heightStack[stackTop].height > heights[i]) {
                stackTop--;
            }
            stackTop++;
            heightStack[stackTop] = new HeightDetail(heights[i], i);
            maxArea = Math.max(maxArea, currMaxArea);
        }
        return maxArea;   
    }
}

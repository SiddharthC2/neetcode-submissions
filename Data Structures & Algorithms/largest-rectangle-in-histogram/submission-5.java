class Solution {

    public int largestRectangleArea(int[] heights) {
        int maxArea = 0;
        Deque<Integer> stack = new ArrayDeque<>();
        int j, k;
        for (int i=0; i<heights.length; i++) {
            while (!stack.isEmpty() && heights[i] <= heights[stack.peek()]) {
                j = stack.pop();
                k = -1;
                if (!stack.isEmpty()) k = stack.peek();
                maxArea = Math.max(maxArea, (heights[j]*(i-k-1)));
            }
            stack.push(i);
        }
        while (!stack.isEmpty()) {
            j = stack.pop();
            k = -1;
            if (!stack.isEmpty()) k = stack.peek();
            maxArea = Math.max(maxArea, (heights[j]*(heights.length-k-1)));
        }
        return maxArea;   
    }
}

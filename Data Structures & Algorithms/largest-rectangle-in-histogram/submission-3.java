class Solution {
    
    private int[] computeNextSmallestElementIdx(int[] heights) {
        int n = heights.length;
        int[] nextSmallestElementIdx = new int[n];
        Deque<Integer> stack = new ArrayDeque<>();
        for (int i=n-1; i>=0; i--) {
            if (stack.isEmpty()) {
                nextSmallestElementIdx[i] = n;
            } else if (heights[stack.peek()] < heights[i]) {
                nextSmallestElementIdx[i] = stack.peek();
            }
            else {
                while (!stack.isEmpty() && heights[stack.peek()] >= heights[i]) {
                    stack.pop();
                }
                if (!stack.isEmpty()) {
                    nextSmallestElementIdx[i] = stack.peek();
                } else {
                    nextSmallestElementIdx[i] = n;
                }
            }
            stack.push(i);
        }
        return nextSmallestElementIdx;
    }

    private int[] computePrevSmallestElementIdx(int[] heights) {
        int n = heights.length;
        int[] prevSmallestElementIdx = new int[n];
        Deque<Integer> stack = new ArrayDeque<>();
        for (int i=0; i<n; i++) {
            if (stack.isEmpty()) {
                prevSmallestElementIdx[i] = -1;
            } else if (heights[stack.peek()] < heights[i]) {
                prevSmallestElementIdx[i] = stack.peek();
            }
            else {
                while (!stack.isEmpty() && heights[stack.peek()] >= heights[i]) {
                    stack.pop();
                }
                if (!stack.isEmpty()) {
                    prevSmallestElementIdx[i] = stack.peek();
                } else {
                    prevSmallestElementIdx[i] = -1;
                }
            }
            stack.push(i);
        }
        return prevSmallestElementIdx;
    }

    public int largestRectangleArea(int[] heights) {
        int maxArea = 0;
        int[] nextSmallestElementIdx = computeNextSmallestElementIdx(heights);
        int[] prevSmallestElementIdx = computePrevSmallestElementIdx(heights);
        for (int i=0; i<heights.length; i++) {
            maxArea = Math.max(maxArea, (heights[i] * (nextSmallestElementIdx[i]-prevSmallestElementIdx[i]-1)));
        }
        return maxArea;   
    }
}

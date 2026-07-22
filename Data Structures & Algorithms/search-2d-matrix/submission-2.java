class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int n = matrix.length, m = matrix[0].length;
        int top = 0, bot = n-1, mid = 0;
        while (top <= bot) {
            mid = top + (bot-top)/2;
            if (matrix[mid][0] == target) {
                return true;
            } else if (matrix[mid][0] > target) {
                bot = mid-1;
                mid = -1;
            } else {
                if (matrix[mid][m-1] == target) {
                    return true;
                } else if (matrix[mid][m-1] > target) {
                    break;
                } else {
                    top = mid+1;
                    mid = -1;
                }
            }
        }
        // System.out.println(mid);
        if (mid == -1) {
            return false;
        }
        int left = 0, right = m-1, rowMid;
        while (left <= right) {
            rowMid = left + (right-left)/2;
            if (matrix[mid][rowMid] == target) {
                return true;
            } else if (matrix[mid][rowMid] < target) {
                left = rowMid+1;
            } else {
                right = rowMid-1;
            }
        }
        return false;
        
    }
}

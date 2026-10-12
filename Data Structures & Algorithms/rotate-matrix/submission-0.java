class Solution {
    public void rotate(int[][] matrix) {
        transpose(matrix);
        reverseCols(matrix);
    }

    private void transpose(final int[][] matrix) {
        final int rows = matrix.length, cols = matrix[0].length;
        int tmp;
        for (int row=0; row<rows; row++) {
            for (int col=row+1; col<cols; col++) {
                tmp = matrix[row][col];
                matrix[row][col] = matrix[col][row];
                matrix[col][row] = tmp;
            }
        }
    }

    private void reverseCols(final int[][] matrix) {
        final int rows = matrix.length, cols = matrix[0].length;
        int tmp;
        for (int col=0; col<cols/2; col++) {
            for (int row=0; row<rows; row++) {
                tmp = matrix[row][col];
                matrix[row][col] = matrix[row][cols-1-col];
                matrix[row][cols-1-col] = tmp;
            }
        }
    }
}

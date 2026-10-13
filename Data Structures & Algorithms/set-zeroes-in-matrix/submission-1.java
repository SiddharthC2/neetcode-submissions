class Solution {
    public void setZeroes(int[][] matrix) {
        final int rows = matrix.length, cols = matrix[0].length;
        boolean isFirstRowZero = false, isFirstColZero = false;
        for (int i=0; i<cols; i++) {
            if (matrix[0][i] == 0) {
                isFirstRowZero = true;
                break;
            }
        }
        for (int i=0; i<rows; i++) {
            if (matrix[i][0] == 0) {
                isFirstColZero = true;
                break;
            }
        }
        final boolean[] rowZero = new boolean[rows];
        final boolean[] colZero = new boolean[cols];
        for (int row=0; row<rows; row++) {
            for (int col=0; col<cols; col++) {
                if (matrix[row][col] == 0) {
                    rowZero[row] = true;
                    colZero[col] = true;
                }
            }
        }
        if (isFirstRowZero) rowZero[0] = true;
        for (int row=0; row<rows; row++) {
            if (rowZero[row]) {
                for (int col=0; col<cols; col++) {
                    matrix[row][col] = 0;
                }
            }
        }

        if (isFirstColZero) colZero[0] = true;
        for (int col=0; col<cols; col++) {
            if (colZero[col]) {
                for (int row=0; row<rows; row++) {
                    matrix[row][col] = 0;
                }
            }
        }      
        
    }
}

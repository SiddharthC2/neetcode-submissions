class Solution {
    public boolean exist(char[][] board, String word) {
        if (board.length == 0) return false;
        int rows = board.length, cols = board[0].length;
        boolean[][] visited = new boolean[rows][cols];
        for (int i=0; i<rows; i++) {
            for (int j=0; j<cols; j++) {
                if (board[i][j] == word.charAt(0)) {
                    visited = new boolean[rows][cols];
                    boolean exists = traverse(board, rows, cols, visited, i, j, word, 0);
                    if (exists == true) return true;
                }
            }
        }
        return false;
    }

    private boolean traverse(
        final char[][] board,
        final int rows,
        final int cols,
        final boolean[][] visited,
        final int row,
        final int col,
        final String word,
        final int idx
    ) {
        if (idx == word.length()) {
            return true;
        }
        if (row < 0 || row == rows || col < 0 || col == cols) {
            return false;
        }
        if (visited[row][col] == true || word.charAt(idx) != board[row][col]) {
            return false;
        }
        System.out.println(row+", "+col+", "+idx+", "+word.charAt(idx));
        visited[row][col] = true;
        boolean exists = traverse(board, rows, cols, visited, row-1, col, word, idx+1) 
            || traverse(board, rows, cols, visited, row+1, col, word, idx+1) 
            || traverse(board, rows, cols, visited, row, col-1, word, idx+1) 
            || traverse(board, rows, cols, visited, row, col+1, word, idx+1);
        if (exists == false) {
            visited[row][col] = false;
        }
        return exists;
    }
}

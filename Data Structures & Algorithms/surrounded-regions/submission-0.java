class Solution {

    private static final int[][] directions = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    public void solve(char[][] board) {
        final int ROWS = board.length, COLS = board[0].length;
        for (int i=0; i<COLS; i++) {
            if (board[0][i] == 'O') dfs(board, 0, i);
            if (board[ROWS-1][i] == 'O') dfs(board, ROWS-1, i);
        }
        for (int i=0; i<ROWS; i++) {
            if (board[i][0] == 'O') dfs(board, i, 0);
            if (board[i][COLS-1] == 'O') dfs(board, i, COLS-1);
        }

        for (int i=0; i<ROWS; i++) {
            for (int j=0; j<COLS; j++) {
                if (board[i][j] == 'O') board[i][j] = 'X';
                else if (board[i][j] == '#') board[i][j] = 'O';
            }
        }
        return;
    }

    private void dfs(
        final char[][] board,
        final int row,
        final int col
    ) {
        board[row][col] = '#';
        int nrow, ncol;
        for (int[] direction: directions) {
            nrow = row + direction[0];
            ncol = col + direction[1];
            if (nrow >= 0 && nrow < board.length &&
                ncol >= 0 && ncol < board[0].length &&
                board[nrow][ncol] == 'O'
            ) {
                dfs(board, nrow, ncol);
            }
        }
    }
}

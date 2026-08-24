class Solution {

    private static final int INF = 2147483647;

    private static final int[][] directions = {{0, -1}, {0, 1}, {-1, 0}, {1, 0}};

    public void islandsAndTreasure(int[][] grid) {
        final int m = grid.length, n = grid[0].length;
        final Queue<int[]> queue = new ArrayDeque<>();
        
        for (int i=0; i<m; i++) {
            for (int j=0; j<n; j++) {
                if (grid[i][j] == 0) {
                    queue.offer(new int[] {i, j});
                }
            }
        }

        int row, col, nrow, ncol;
        while (!queue.isEmpty()) {
            int[] node = queue.poll();
            row = node[0];
            col = node[1];
            for (int[] direction: directions) {
                nrow = row + direction[0];
                ncol = col + direction[1];
                if (nrow < 0 || nrow == grid.length ||
                    ncol < 0 || ncol == grid[0].length ||
                    grid[nrow][ncol] != INF
                ) {
                    continue;
                }
                grid[nrow][ncol] = grid[row][col]+1;
                queue.offer(new int[] {nrow, ncol});
            }
        }
    }
}

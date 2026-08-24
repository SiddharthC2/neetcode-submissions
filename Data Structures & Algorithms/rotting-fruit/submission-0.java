class Solution {

    private static final int INF = Integer.MAX_VALUE;
    private static final int[][] directions = {{0, -1}, {0, 1}, {-1, 0}, {1, 0}};

    public int orangesRotting(int[][] grid) {
        final int m = grid.length, n = grid[0].length;
        final int[][] grid2 = new int[m][n];
        final Queue<int[]> queue = new ArrayDeque<>();

        for (int i=0; i<m; i++) {
            for (int j=0; j<n; j++) {
                grid2[i][j] = grid[i][j];
                if (grid[i][j] == 0) {
                    grid2[i][j] = -1;
                } else if (grid[i][j] == 1) {
                    grid2[i][j] = INF;
                } else {
                    grid2[i][j] = 0;
                    queue.offer(new int[] {i, j});
                }
            }
        }
        
        int r, c, nr, nc;
        while (!queue.isEmpty()) {
            int[] node = queue.poll();
            r = node[0];
            c = node[1];
            for (int[] direction: directions) {
                nr = r + direction[0];
                nc = c + direction[1];
                if (nr < 0 || nr == m || nc < 0 || nc == n ||
                    grid2[nr][nc] != INF
                ) {
                    continue;
                }
                grid2[nr][nc] = grid2[r][c]+1;
                queue.offer(new int[] {nr, nc});
            }
        }

        int max = 0;
        for (int i=0; i<m; i++) {
            for (int j=0; j<n; j++) {
                // System.out.print(grid2[i][j] + ", ");
                if (grid2[i][j] == INF) {
                    return -1;
                }
                if (grid2[i][j] == -1 || grid2[i][j] == 0) {
                    continue;
                }
                max = Math.max(max, grid2[i][j]);
            }
            // System.out.println();
        }
        return max;
    }
}

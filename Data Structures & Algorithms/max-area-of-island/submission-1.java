class Solution {

    private static int[][] directions = {{0, -1}, {0, 1}, {-1, 0}, {1, 0}};

    public int maxAreaOfIsland(int[][] grid) {
        int maxArea = 0;
        final int rows = grid.length, cols = grid[0].length;
        final boolean[][] visited = new boolean[rows][cols];
        for (int row=0; row<rows; row++) {
            for (int col=0; col<cols; col++) {
                if (visited[row][col] == false && grid[row][col] == 1) {
                    int currArea = bfs(grid, row, col, visited);
                    maxArea = Math.max(currArea, maxArea);
                }
            }
        }
        return maxArea;
    }

    private int bfs(
        final int[][] grid,
        int row,
        int col,
        final boolean[][] visited
    ) {
        Queue<int[]> queue = new ArrayDeque<>();
        queue.offer(new int[] {row, col});
        visited[row][col] = true;

        int area = 0, nrow, ncol;
        while (!queue.isEmpty()) {
            int[] curr = queue.poll();
            row = curr[0];
            col = curr[1];
            for (int[] direction: directions) {
                nrow = row + direction[0];
                ncol = col + direction[1];
                if (nrow < 0 || nrow == grid.length ||
                    ncol < 0 || ncol == grid[0].length ||
                    grid[nrow][ncol] == 0 || visited[nrow][ncol] == true
                ) {
                    continue;
                }
                queue.offer(new int[] {nrow, ncol});
                visited[nrow][ncol] = true;  
            }
            area++;
        }
        return area;
    }
}

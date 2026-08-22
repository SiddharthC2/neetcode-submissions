class Solution {

    private static int[][] directions = {{0, -1}, {0, 1}, {-1, 0}, {1, 0}};

    public int maxAreaOfIsland(int[][] grid) {
        int maxArea = 0;
        final int rows = grid.length, cols = grid[0].length;
        final boolean[][] visited = new boolean[rows][cols];
        for (int row=0; row<rows; row++) {
            for (int col=0; col<cols; col++) {
                if (visited[row][col] == false && grid[row][col] == 1) {
                    int currArea = dfs(grid, row, col, visited);
                    maxArea = Math.max(currArea, maxArea);
                }
            }
        }
        return maxArea;
    }

    private int dfs(
        final int[][] grid,
        final int row,
        final int col,
        final boolean[][] visited
    ) {
        if (row < 0 || row == grid.length ||
            col < 0 || col == grid[0].length ||
            grid[row][col] == 0 || visited[row][col] == true
        ) {
            return 0;
        }
        visited[row][col] = true;
        int area = 1;
        for (int[] direction: directions) {
            area += dfs(grid, row+direction[0], col+direction[1], visited);
        }
        return area;
    }
}

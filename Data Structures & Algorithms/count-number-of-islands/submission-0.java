class Solution {
    public int numIslands(char[][] grid) {
        final int m = grid.length, n = grid[0].length;
        final boolean[][] visited = new boolean[m][n];
        int count = 0;
        for (int i=0; i<m; i++) {
            for (int j=0; j<n; j++) {
                if (grid[i][j] == '1' && visited[i][j] == false) {
                    count++;
                    dfs(grid, i, j, visited);
                }
            }
        }
        return count;
    }

    private void dfs(
        final char[][] grid,
        final int row,
        final int col,
        final boolean[][] visited
    ) {
        if (
            row < 0 || row == grid.length || 
            col < 0 || col == grid[0].length ||
            grid[row][col] == '0' || visited[row][col]
        ) {
            return;
        }
        visited[row][col] = true;
        dfs(grid, row, col-1, visited);
        dfs(grid, row, col+1, visited);
        dfs(grid, row-1, col, visited);
        dfs(grid, row+1, col, visited);
    }
}

class Solution {
    public int numIslands(char[][] grid) {
        final int m = grid.length, n = grid[0].length;
        final boolean[][] visited = new boolean[m][n];
        int count = 0;
        for (int i=0; i<m; i++) {
            for (int j=0; j<n; j++) {
                if (grid[i][j] == '1' && visited[i][j] == false) {
                    count++;
                    bfs(grid, i, j, visited);
                }
            }
        }
        return count;
    }

    private void bfs(
        final char[][] grid,
        int row,
        int col,
        final boolean[][] visited
    ) {
        Queue<int[]> queue = new ArrayDeque<>();
        int[] node = new int[] {row, col};
        queue.offer(node);
        visited[row][col] = true;

        while (!queue.isEmpty()) {
            node = queue.poll();
            row = node[0];
            col = node[1];
            if (isValidNode(grid, row, col-1, visited)) {
                queue.offer(new int[]{row, col-1});
                visited[row][col-1] = true;
            }
            if (isValidNode(grid, row, col+1, visited)) {
                queue.offer(new int[]{row, col+1});
                visited[row][col+1] = true;
            }
            if (isValidNode(grid, row-1, col, visited)) {
                queue.offer(new int[]{row-1, col});
                visited[row-1][col] = true;
            }
            if (isValidNode(grid, row+1, col, visited)) {
                queue.offer(new int[]{row+1, col});
                visited[row+1][col] = true;
            }
        }
    }

    private boolean isValidNode(
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
            return false;
        }
        return true;
    }
}

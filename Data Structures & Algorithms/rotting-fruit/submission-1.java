class Solution {

    private static final int[][] directions = {{0, -1}, {0, 1}, {-1, 0}, {1, 0}};

    public int orangesRotting(int[][] grid) {
        final int m = grid.length, n = grid[0].length;
        final Queue<int[]> queue = new ArrayDeque<>();
        
        int fresh = 0;
        for (int i=0; i<m; i++) {
            for (int j=0; j<n; j++) {
                if (grid[i][j] == 1) {
                    fresh++;
                } else if (grid[i][j] == 2) {
                    queue.offer(new int[] {i, j});
                }
            }
        }

        int mins = 0;
        int r, c, nr, nc, size;
        while (!queue.isEmpty() && fresh > 0) {
            size = queue.size();
            for (int i=0; i<size; i++) {
                int[] node = queue.poll();
                r = node[0];
                c = node[1];
                for (int[] direction: directions) {
                    nr = r + direction[0];
                    nc = c + direction[1];
                    if (nr < 0 || nr == m || nc < 0 || nc == n || grid[nr][nc] != 1) {
                        continue;
                    }
                    grid[nr][nc] = 2;
                    fresh--;
                    queue.offer(new int[] {nr, nc});
                }
            }
            mins++;
        }

        return (fresh == 0) ? mins : -1;
    }
}

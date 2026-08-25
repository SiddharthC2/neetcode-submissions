class Solution {

    private static final int[][] directions = {
        {1, 0}, {-1, 0}, {0, 1}, {0, -1}
    };

    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        final int ROWS = heights.length, COLS = heights[0].length;
        final boolean[][] pacific = new boolean[ROWS][COLS];
        final boolean[][] atlantic = new boolean[ROWS][COLS];

        final Queue<int[]> pacQueue = new ArrayDeque<>();
        final Queue<int[]> atlQueue = new ArrayDeque<>();

        for (int i=0; i<COLS; i++) {
            pacQueue.offer(new int[] {0, i});
            pacific[0][i] = true;

            atlQueue.offer(new int[] {ROWS-1, i});
            atlantic[ROWS-1][i] = true;
        }
        
        for (int i=0; i<ROWS; i++) {
            pacQueue.offer(new int[] {i, 0});
            pacific[i][0] = true;

            atlQueue.offer(new int[] {i, COLS-1});
            atlantic[i][COLS-1] = true;
        }

        bfs(heights, pacific, pacQueue);
        bfs(heights, atlantic, atlQueue);

        final List<List<Integer>> res = new ArrayList<>();
        for (int i=0; i<ROWS; i++) {
            for (int j=0; j<COLS; j++) {
                if (pacific[i][j] && atlantic[i][j]) {
                    res.add(List.of(i, j));
                }
            }
        }
        return res;        
    }

    private void bfs(
        final int[][] heights,
        final boolean[][] ocean,
        final Queue<int[]> oceanQ
    ) {
        int[] node;
        int r, c, nr, nc;
        while (!oceanQ.isEmpty()) {
            node = oceanQ.poll();
            r = node[0];
            c = node[1];
            for (int[] direction: directions) {
                nr = r + direction[0];
                nc = c + direction[1];
                if (nr >= 0 && nr < heights.length &&
                    nc >= 0 && nc < heights[0].length &&
                    !ocean[nr][nc] && heights[nr][nc] >= heights[r][c]
                ) {
                    oceanQ.offer(new int[] {nr, nc});
                    ocean[nr][nc] = true;
                }
            }
        }
    }
}

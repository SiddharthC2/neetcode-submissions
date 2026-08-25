class Solution {

    private static final int[][] directions = {
        {1, 0}, {-1, 0}, {0, 1}, {0, -1}
    };

    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        final int ROWS = heights.length, COLS = heights[0].length;
        final boolean[][] pacific = new boolean[ROWS][COLS];
        final boolean[][] atlantic = new boolean[ROWS][COLS];

        for (int i=0; i<COLS; i++) {
            dfs(0, i, pacific, heights);
            dfs(ROWS-1, i, atlantic, heights);
        }
        
        for (int i=0; i<ROWS; i++) {
            dfs(i, 0, pacific, heights);
            dfs(i, COLS-1, atlantic, heights);
        }

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

    private void dfs(
        final int row,
        final int col,
        final boolean[][] ocean,
        final int[][] heights
    ) {
        ocean[row][col] = true;
        for (int[] direction: directions) {
            int nrow = row + direction[0];
            int ncol = col + direction[1];
            if (
                nrow < 0 || nrow >= heights.length ||
                ncol < 0 || ncol >= heights[0].length ||
                ocean[nrow][ncol] == true || heights[nrow][ncol] < heights[row][col]
            ) {
                continue;
            }
            dfs(nrow, ncol, ocean, heights);
        }
    }
}

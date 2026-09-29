class Solution {
    public int minCostConnectPoints(int[][] points) {
        int cost = 0, n = points.length;
        if (n < 2) return 0;

        PriorityQueue<int[]> mst = new PriorityQueue<>(
            (a, b) -> Integer.compare(a[1], b[1]));
        mst.offer(new int[]{0, 0});

        final boolean[] visited = new boolean[n];
        int curr = 0;
        while (!mst.isEmpty()) {
            int[] nextMin = mst.poll();
            if (visited[nextMin[0]]) continue;
            visited[nextMin[0]] = true;
            curr = nextMin[0];
            cost += nextMin[1];
            for (int next = 0; next < n; next++) {
                if (visited[next] == true) continue;
                mst.offer(new int[]{next, dist(curr, next, points)});
            }
        }
        return cost;
    }

    private int dist(final int x, final int y, final int[][] points) {
        return Math.abs(points[x][0]-points[y][0]) + Math.abs(points[x][1]-points[y][1]);
    }
}

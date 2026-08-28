class Solution {
    public boolean validTree(int n, int[][] edges) {
        if (n == 1) return true;
        if (edges.length == 0) return false;

        final List<Integer>[] graph = new ArrayList[n];
        for (int[] edge: edges) {
            int node1 = edge[0];
            int node2 = edge[1];
            if (graph[node1] == null) {
                graph[node1] = new ArrayList<>();
            }
            graph[node1].add(node2);

            if (graph[node2] == null) {
                graph[node2] = new ArrayList<>();
            }
            graph[node2].add(node1);
        }

        final boolean[] visited = new boolean[n];
        if (bfsCycle(graph, edges[0][0], visited) == true) return false;

        for (int i=0; i<n; i++) {
            if (visited[i] == false) return false;
        }

        return true;
    }

    private boolean bfsCycle(
        final List<Integer>[] graph,
        int node,
        final boolean[] visited
    ) {
        final Queue<int[]> bfs = new ArrayDeque<>();
        bfs.offer(new int[] {node, -1});
        visited[node] = true;

        while (!bfs.isEmpty()) {
            int[] pair = bfs.poll();
            node = pair[0];
            int parent = pair[1];

            if (graph[node] == null) continue;
            for (int next: graph[node]) {
                if (visited[next] == false) {
                    bfs.offer(new int[] {next, node});
                    visited[next] = true;
                }
                else if (next != parent) {
                    return true;
                }
            }
        }
        return false;
    }


}

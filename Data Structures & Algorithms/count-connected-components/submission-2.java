class Solution {
    public int countComponents(int n, int[][] edges) {
        final List<Integer>[] graph = new ArrayList[n];
        final boolean[] visited = new boolean[n];
        for (int i=0; i<n; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int[] edge: edges) {
            int node1 = edge[0];
            int node2 = edge[1];
            graph[node1].add(node2);
            graph[node2].add(node1);
        }

        int res = 0;
        for (int i=0; i<n; i++) {
            if (!visited[i]) {
                bfs(graph, visited, i);
                res++;
            }
        }
        return res;
    }

    private void bfs(
        final List<Integer>[] graph,
        final boolean[] visited,
        int node
    ) {
        Queue<Integer> queue = new ArrayDeque<>();
        queue.offer(node);
        visited[node] = true;

        while (!queue.isEmpty()) {
            node = queue.poll();
            for (int next: graph[node]) {
                if (!visited[next]) {
                    queue.offer(next);
                    visited[next] = true;
                }
            }
        }
    }
}

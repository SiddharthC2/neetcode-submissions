class Solution {
    public int countComponents(int n, int[][] edges) {
        final List<Integer>[] graph = new ArrayList[n];
        final boolean[] visited = new boolean[n];
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

        int res = 0;
        for (int i=0; i<n; i++) {
            if (!visited[i]) {
                dfs(graph, visited, i);
                res++;
            }
        }
        return res;
    }

    private void dfs(
        final List<Integer>[] graph,
        final boolean[] visited,
        final int node
    ) {
        visited[node] = true;
        if (graph[node] == null) return;
        for (int next: graph[node]) {
            if (!visited[next]) {
                dfs(graph, visited, next);
            }
        }
    }
}

class Solution {
    public int[] findRedundantConnection(int[][] edges) {
        final int n = edges.length;
        final List<Integer>[] graph = new ArrayList[n+1];
        final boolean[] visited = new boolean[n+1];
        for (int i=1; i<=n; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int[] edge: edges) {
            graph[edge[0]].add(edge[1]);
            graph[edge[1]].add(edge[0]);
        }

        Set<Integer> cyclicSet = new HashSet<>();
        dfsCycle(graph, visited, 1, -1, cyclicSet, new int[] {-1});

        for (int i=n-1; i>=0; i--) {
            int[] edge = edges[i];
            if (cyclicSet.contains(edge[0]) && cyclicSet.contains(edge[1])) {
                return edge;
            }
        }
        return null;
    }

    private boolean dfsCycle(
        final List<Integer>[] graph,
        final boolean[] visited,
        final int curr,
        final int parent,
        final Set<Integer> cyclicSet,
        final int[] cycleStart
    ) {
        visited[curr] = true;
        for (int next: graph[curr]) {
            if (next == parent) continue;
            if (visited[next] == false) {
                if (dfsCycle(graph, visited, next, curr, cyclicSet, cycleStart)) {
                    if (cycleStart[0] != -1) cyclicSet.add(curr);
                    if (curr == cycleStart[0]) {
                        cycleStart[0] = -1;
                    }
                    return true;
                }
            } else {
                cyclicSet.add(curr);
                cycleStart[0] = next;
                return true;
            }
        }
        return false;
    }
    
}
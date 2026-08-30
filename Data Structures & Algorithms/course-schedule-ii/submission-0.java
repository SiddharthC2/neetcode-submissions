class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        final List<Integer>[] graph = new ArrayList[numCourses];
        final boolean[] visited = new boolean[numCourses];
        final boolean[] ispath = new boolean[numCourses];
        final int[] order = new int[numCourses];

        for (int i=0; i<numCourses; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int[] prerequisite: prerequisites) {
            graph[prerequisite[1]].add(prerequisite[0]);
        }

        
        int[] idx = new int[1];
        idx[0] = numCourses-1;
        for (int i=0; i<numCourses; i++) {
            if (!visited[i]) {
                if (dfsCycle(graph, i, visited, ispath, order, idx)) {
                    return new int[0];
                }
            }
        }
        return order;
    }

    private boolean dfsCycle(
        final List<Integer>[] graph,
        final int node,
        final boolean[] visited,
        final boolean[] ispath,
        final int[] order,
        int[] idx
    ) {
        visited[node] = true;
        ispath[node] = true;
        for (int next: graph[node]) {
            if (!visited[next]) {
                if (dfsCycle(graph, next, visited, ispath, order, idx)) {
                    return true;
                }
            } else if (ispath[next]) {
                return true;
            }
        }
        ispath[node] = false;
        order[idx[0]--] = node;
        return false;
    }
}

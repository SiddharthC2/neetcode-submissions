class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        final List<Integer>[] graph = new ArrayList[numCourses];
        for (int course = 0; course < numCourses; course++) {
            graph[course] = new ArrayList<>();
        }

        for (int[] prereq: prerequisites) {
            graph[prereq[1]].add(prereq[0]);
        }

        return !bfsCycle(numCourses, graph);
    }

    private boolean bfsCycle(
        final int n,
        final List<Integer>[] graph
    ) {
        final int[] indegree = new int[n];
        for (int i=0; i<n; i++) {
            for (Integer curr: graph[i]) {
                indegree[curr]++;
            }
        }
        int visited = 0;
        Queue<Integer> topoQ = new ArrayDeque<>();
        for (int i=0; i<n; i++) {
            if (indegree[i] == 0) {
                topoQ.offer(i);
                visited++;
            }
        }

        while (!topoQ.isEmpty()) {
            Integer curr = topoQ.poll();
            for (Integer next: graph[curr]) {
                indegree[next]--;
                if (indegree[next] == 0) {
                    topoQ.offer(next);
                    visited++;
                }
            }
        }
        return visited != n;
    }
}

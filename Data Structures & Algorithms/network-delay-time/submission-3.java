class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        final List<int[]>[] graph = new ArrayList[n];
        final int[] nodeTime = new int[n];
        for (int i=0; i<n; i++) {
            graph[i] = new ArrayList<>();
            nodeTime[i] = Integer.MAX_VALUE;
        }
        for (int[] time: times) {
            graph[time[0]-1].add(new int[] {time[1]-1, time[2]});
        }
        // printGraph(graph, n);

        dfs(graph, n, k-1, 0, nodeTime);
        
        int minTime = 0;
        for (int i=0; i<n; i++) {
            minTime = Math.max(minTime, nodeTime[i]);
        }
        return minTime == Integer.MAX_VALUE ? -1 : minTime;
    }

    private void dfs(
        final List<int[]>[] graph,
        final int n,
        final int k,
        final int delay,
        final int[] nodeTime
    ) {
        if (delay >= nodeTime[k]) return;
        nodeTime[k] = delay;
        for (int[] nextNode: graph[k]) {
            dfs(graph, n, nextNode[0], nodeTime[k]+nextNode[1], nodeTime);
        }
        return;
    }

    private void printGraph(final List<int[]>[] graph, final int n) {
        for (int i=0; i<n; i++) {
            System.out.print((i+1) + " : ");
            for (int[] next: graph[i]) {
                System.out.print("[" + (next[0]+1) + ", " + next[1] + "], ");
            }
            System.out.println();
        }

    }
}

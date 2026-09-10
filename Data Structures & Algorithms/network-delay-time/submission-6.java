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

        dijkstras(graph, n, k-1, 0, nodeTime);
        
        int minTime = 0;
        for (int i=0; i<n; i++) {
            minTime = Math.max(minTime, nodeTime[i]);
        }
        return minTime == Integer.MAX_VALUE ? -1 : minTime;
    }

    private void dijkstras(
        final List<int[]>[] graph,
        final int n,
        final int k,
        final int delay,
        final int[] nodeTime
    ) {
        final PriorityQueue<int[]> minHeap = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
        minHeap.offer(new int[] {0, k});
        nodeTime[k] = 0;

        while (!minHeap.isEmpty()) {
            int[] curr = minHeap.poll();
            int currTime = curr[0];
            int currNode = curr[1];
            for (int[] next: graph[currNode]) {
                int nextNode = next[0];
                int nextTime = next[1];
                int newTime = currTime + nextTime;
                if (newTime < nodeTime[nextNode]) {
                    nodeTime[nextNode] = newTime;
                    minHeap.offer(new int[] {newTime, nextNode});
                }
            }
        }
        
    }
}

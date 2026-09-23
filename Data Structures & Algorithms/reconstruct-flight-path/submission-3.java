class Solution {
    public List<String> findItinerary(List<List<String>> tickets) {
        final Map<String, PriorityQueue<String>> graph = new HashMap<>();
        for (List<String> ticket: tickets) {
            final String source = ticket.get(0);
            final String dest = ticket.get(1);
            graph.computeIfAbsent(source, k -> new PriorityQueue<>()).offer(dest);
        }

        final List<String> itinerary = new ArrayList<>();
        dfs("JFK", graph, itinerary);
        Collections.reverse(itinerary);
        return itinerary;
    }

    private void dfs(
        final String curr,
        final Map<String, PriorityQueue<String>> graph,
        final List<String> itinerary
    ) {
        final PriorityQueue<String> nexts = graph.get(curr);
        while(nexts != null && !nexts.isEmpty()) {
            dfs(nexts.poll(), graph, itinerary);
        }
        itinerary.add(curr);
    }
}

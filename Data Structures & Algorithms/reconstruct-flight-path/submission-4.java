class Solution {
    public List<String> findItinerary(List<List<String>> tickets) {
        final Map<String, PriorityQueue<String>> graph = new HashMap<>();
        for (List<String> ticket: tickets) {
            final String source = ticket.get(0);
            final String dest = ticket.get(1);
            graph.computeIfAbsent(source, k -> new PriorityQueue<>()).offer(dest);
        }

        final List<String> itinerary = new LinkedList<>();
        final Deque<String> stack = new ArrayDeque<>();
        stack.push("JFK");
        while (!stack.isEmpty()) {
            String current = stack.peek();
            if (!graph.containsKey(current) || graph.get(current).isEmpty()) {
                itinerary.addFirst(stack.pop());
            } else {
                stack.push(graph.get(current).poll());
            }
        }
        return itinerary;
    }
}

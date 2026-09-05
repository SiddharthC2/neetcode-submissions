class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        boolean exists = false;

        for (String word : wordList) {
            if (endWord.equals(word)) {
                exists = true;
                break;
            }
        }

        if (!exists) return 0;

        final Map<String, List<String>> graph = generateGraph(wordList);

        // Add beginWord to the graph if it isn't already present
        if (!graph.containsKey(beginWord)) {
            List<String> nextWords = new ArrayList<>();

            for (String word : wordList) {
                if (charDiff(beginWord, word) == 1) {
                    nextWords.add(word);
                    graph.get(word).add(beginWord);
                }
            }

            graph.put(beginWord, nextWords);
        }

        return bfsMinPath(beginWord, endWord, graph);
    }

    private int bfsMinPath(
        final String beginWord,
        final String endWord,
        final Map<String, List<String>> graph
    ) {
        final Queue<String> queue = new ArrayDeque<>();
        final Map<String, Boolean> visited = new HashMap<>();

        queue.offer(beginWord);
        visited.put(beginWord, true);

        int pathLength = 1;

        while (!queue.isEmpty()) {
            int size = queue.size();

            // Process one BFS level at a time
            for (int i = 0; i < size; i++) {
                String current = queue.poll();

                if (current.equals(endWord)) {
                    return pathLength;
                }

                for (String next : graph.get(current)) {
                    if (!visited.getOrDefault(next, false)) {
                        visited.put(next, true);
                        queue.offer(next);
                    }
                }
            }

            pathLength++;
        }

        return 0;
    }

    private Map<String, List<String>> generateGraph(
        final List<String> wordList
    ) {
        final Map<String, List<String>> graph = new HashMap<>();

        for (String word : wordList) {
            List<String> nextWords = new ArrayList<>();

            for (String next : wordList) {
                if (word.equals(next)) continue;

                if (charDiff(word, next) == 1) {
                    nextWords.add(next);
                }
            }

            graph.put(word, nextWords);
        }

        return graph;
    }

    private int charDiff(
        final String word,
        final String word2
    ) {
        int n = word.length();
        int diff = 0;

        for (int i = 0; i < n; i++) {
            if (word.charAt(i) != word2.charAt(i)) {
                diff++;
            }
        }

        return diff;
    }
}
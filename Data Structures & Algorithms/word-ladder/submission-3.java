class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        final Set<String> wordSet = new HashSet<>(wordList);
        if (!wordSet.contains(endWord)) {
            return 0;
        }
        Queue<String> bfsQ = new ArrayDeque<>();
        bfsQ.offer(beginWord);
        final Set<String> visited = new HashSet<>();
        visited.add(beginWord);
        int level = 1;

        while (!bfsQ.isEmpty()) {
            for (int i=bfsQ.size(); i>0; i--) {
                String curr = bfsQ.poll();
                if (curr.equals(endWord)) {
                    return level;
                }

                char[] chars = curr.toCharArray();
                for (int j=0; j<chars.length; j++) {
                    char original = chars[j];
                    for (char c='a'; c<='z'; c++) {
                        chars[j] = c;
                        String next = new String(chars);
                        if (!visited.contains(next) && wordSet.contains(next)) {
                            visited.add(next);
                            bfsQ.offer(next);
                        }
                    }
                    chars[j] = original;
                }
            }
            level++;
        }
        return 0;
    }
}

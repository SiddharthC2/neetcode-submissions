class WordDictionary {

    private static class Trie {
        Trie[] node = new Trie[26];
        boolean end;
    }

    private final Trie root;

    public WordDictionary() {
        root = new Trie();
    }

    public void addWord(String word) {
        Trie curr = root;
        for (char currchar: word.toCharArray()) {
            int idx = currchar - 'a';
            if (curr.node[idx] == null) {
                curr.node[idx] = new Trie();
            }
            curr = curr.node[idx];
        }
        curr.end = true;
    }

    public boolean search(String word) {
        return search(root, word, 0);
    }

    private boolean search(Trie curr, final String word, final int startIdx) {
        int len = word.length();
        for (int i=startIdx; i<len; i++) {
            char currchar = word.charAt(i);
            if (currchar == '.') {
                for (int j=0; j<26; j++) {
                    if (curr.node[j] == null) continue;
                    if (search(curr.node[j], word, i+1) == false) continue;
                    return true;
                }
                return false;
            } else {
                int idx = currchar - 'a';
                if (curr.node[idx] == null) return false;
                curr = curr.node[idx];
            }
        }
        return curr.end;
    }
}

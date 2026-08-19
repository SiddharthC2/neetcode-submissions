class PrefixTree {

    private static class Trie {
        Trie[] next = new Trie[26];
        boolean isLast;
    }

    private final Trie root;

    public PrefixTree() {
        root = new Trie();
    }

    public void insert(String word) {
        Trie curr = root;
        for (Character currchar: word.toCharArray()) {
            int idx = currchar - 'a';
            if (curr.next[idx] == null) curr.next[idx] = new Trie();
            curr = curr.next[idx];
        }
        curr.isLast = true;
    }

    public boolean search(String word) {
        Trie curr = root;
        for (Character currchar: word.toCharArray()) {
            int idx = currchar - 'a';
            if (curr.next[idx] == null) return false;
            else {
                curr = curr.next[idx];
            }
        }
        return curr.isLast;
    }

    public boolean startsWith(String prefix) {
        Trie curr = root;
        for (Character currchar: prefix.toCharArray()) {
            int idx = currchar - 'a';
            if (curr.next[idx] == null) return false;
            else {
                curr = curr.next[idx];
            }
        }
        return true;
    }
}

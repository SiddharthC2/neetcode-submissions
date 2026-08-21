class Solution {

    private static class Trie {
        Trie[] node = new Trie[26];
        String word = null;
    }

    public List<String> findWords(char[][] board, String[] words) {
        final Trie root = buildTrie(words);
        List<String> result = new ArrayList<>();
        final int m = board.length, n = board[0].length;
        final boolean[][] visited = new boolean[m][n];
        for (int i=0; i<m; i++) {
            for (int j=0; j<n; j++) {
                dfs(root, board, i, j, visited, result);
            }
        }
        return result;
    }

    private Trie buildTrie(final String[] words) {
        final Trie root = new Trie();
        for (final String word: words) {
            Trie curr = root;
            for (final char currchar: word.toCharArray()) {
                int idx = currchar - 'a';
                if (curr.node[idx] == null) curr.node[idx] = new Trie();
                curr = curr.node[idx];
            }
            curr.word = word;
        }
        return root;
    }

    private void dfs(
        final Trie curr,
        final char[][] board,
        final int row,
        final int col,
        final boolean[][] visited,
        final List<String> result
    ) {
        if (row < 0 || row == board.length
            || col < 0 || col == board[0].length 
            || visited[row][col] == true) {
            return;
        }

        Trie next = curr.node[board[row][col] - 'a'];
        if (next == null) {
            return;
        }
        
        visited[row][col] = true;
        if (next.word != null) {
            result.add(next.word);
            next.word = null;
        }
        dfs(next, board, row, col-1, visited, result);
        dfs(next, board, row, col+1, visited, result);
        dfs(next, board, row-1, col, visited, result);
        dfs(next, board, row+1, col, visited, result);
        visited[row][col] = false;
    }
}

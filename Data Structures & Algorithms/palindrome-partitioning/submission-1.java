class Solution {
    public List<List<String>> partition(String s) {
        final boolean[][] ispalindrome = new boolean[s.length()][s.length()];
        for (int len=0; len<s.length(); len++) {
            for (int i=0; i<s.length()-len; i++) {
                int j = i+len;
                ispalindrome[i][j] = (s.charAt(j) == s.charAt(i)) 
                    && ((i+1 >= j-1) || ispalindrome[i+1][j-1]);
            }
        }
        final List<List<String>> palindromes = new ArrayList<>();
        partition(s, ispalindrome, 0, new ArrayList<>(), palindromes);
        return palindromes;
    }

    private void partition(
        final String s,
        final boolean[][] ispalindrome,
        final int i,
        final List<String> currlist,
        final List<List<String>> palindromes
    ) {
        if (i >= s.length()) {
            palindromes.add(new ArrayList<>(currlist));
            return;
        }
        for (int j=i; j<s.length(); j++) {
            if (ispalindrome[i][j]) {
                currlist.add(s.substring(i, j+1));
                partition(s, ispalindrome, j+1, currlist, palindromes);
                currlist.remove(currlist.size()-1);
            }
        }
    }
}

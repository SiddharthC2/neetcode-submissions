class Solution {
    public boolean isAnagram(String s, String t) {
        int slen = s.length(), tlen = t.length();
        if (slen != tlen) {
            return false;
        }
        int[] s_freq = new int[26];
        int[] t_freq = new int[26];
        for (int i=0; i<slen; i++) {
            s_freq[s.charAt(i)-'a']++;
            t_freq[t.charAt(i)-'a']++;
        }
        for (int i=0; i<26; i++) {
            if (s_freq[i] != t_freq[i]) {
                return false;
            }
        }
        return true;
    }
}

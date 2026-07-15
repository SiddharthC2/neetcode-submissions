class Solution {
    public boolean isAnagram(String s, String t) {
        int[] charCount = new int[26];
        for (char sChar: s.toCharArray()) {
            charCount[sChar-'a']++;
        }
        for (char tChar: t.toCharArray()) {
            charCount[tChar-'a']--;
        }
        for (int i=0; i<26; i++) {
            if (charCount[i] != 0) {
                return false;
            }
        }
        return true;
    }
}

class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if (s1.length() > s2.length()) {
            return false;
        }
        int[] s1Count = new int[26];
        int[] s2Count = new int[26];
        for (int i=0; i<s1.length(); i++) {
            s1Count[s1.charAt(i)-'a']++;
            s2Count[s2.charAt(i)-'a']++;
        }
        int currMatches = 0;
        for (int i=0; i<26; i++) {
            if (s1Count[i] == s2Count[i]) {
                currMatches++;
            }
        }
        int left = 0, right = s1.length(), idx;
        while (right < s2.length()) {
            if (currMatches == 26) {
                return true;
            }
            
            idx = s2.charAt(right)-'a';
            s2Count[idx]++;
            if (s1Count[idx] == s2Count[idx]) {
                currMatches++;
            } else if (s1Count[idx] + 1 == s2Count[idx]) {
                currMatches--;
            }
            right++;

            idx = s2.charAt(left)-'a';
            s2Count[idx]--;
            if (s1Count[idx] == s2Count[idx]) {
                currMatches++;
            } else if (s1Count[idx] - 1 == s2Count[idx]) {
                currMatches--;
            }
            left++;

        }
        return currMatches == 26;        
    }
}

class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if (s1.length() > s2.length()) {
            return false;
        }
        int[] charFreq = new int[26];
        int[] charFreq2 = new int[26];
        for(int i=0; i<s1.length(); i++) {
            charFreq[s1.charAt(i)-'a']++;
            charFreq2[s2.charAt(i)-'a']++;
        }
        int left = 0, right = s1.length();
        while (right < s2.length()) {
            if (isEqual(charFreq, charFreq2))
                return true;
            charFreq2[s2.charAt(left)-'a']--;
            charFreq2[s2.charAt(right)-'a']++;
            left++;
            right++;
        }
        return isEqual(charFreq, charFreq2);
    }

    private boolean isEqual(int[] charFreq, int[] charFreq2) {
        for (int i=0; i<charFreq.length; i++) {
            if (charFreq[i] != charFreq2[i])
                return false;
        }
        return true;
    }
}

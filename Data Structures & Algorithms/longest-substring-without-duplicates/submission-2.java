class Solution {
    public int lengthOfLongestSubstring(String s) {
        if (s.length() <= 1) {
            return s.length();
        }
        int maxLen = 0, left = 0, right = 0;
        Map<Character, Integer> charIdxMap = new HashMap<>();
        Character currChar;
        while (right < s.length()) {
            currChar = s.charAt(right);
            if (charIdxMap.containsKey(currChar)) {
                left = Math.max(charIdxMap.get(currChar)+1, left);
            }
            charIdxMap.put(currChar, right);
            maxLen = Math.max(maxLen, right-left+1);
            right++;
        }
        return maxLen;
    }
}

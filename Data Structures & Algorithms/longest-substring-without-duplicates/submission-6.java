class Solution {
    public int lengthOfLongestSubstring(String s) {
        int left = 0, right = 0, slen = s.length(), maxLen = 0;
        Map<Character, Integer> charIdxMap = new HashMap<>();
        char currChar;
        Integer currIdx;
        while (right < slen) {
            currChar = s.charAt(right);
            currIdx = charIdxMap.get(currChar);
            if (currIdx == null || currIdx < left) {
                charIdxMap.put(currChar, right);
                maxLen = Math.max(right-left+1, maxLen);
                right++;
            } else {
                left = charIdxMap.get(currChar) + 1;
            }
        }
        return maxLen;
    }
}

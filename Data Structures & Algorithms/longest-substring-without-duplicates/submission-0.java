class Solution {
    public int lengthOfLongestSubstring(String s) {
        if (s.length() <= 1) {
            return s.length();
        }
        int maxLen = 0, left = 0, right = 0;
        Set<Character> charSet = new HashSet<>();
        Character currChar;
        while (right < s.length()) {
            currChar = s.charAt(right);
            while (charSet.contains(currChar) && left < right) {
                charSet.remove(s.charAt(left++));
            }
            charSet.add(currChar);
            maxLen = Math.max(maxLen, right-left+1);
            right++;
        }
        return maxLen;
    }
}

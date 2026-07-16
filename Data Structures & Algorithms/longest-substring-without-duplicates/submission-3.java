class Solution {
    public int lengthOfLongestSubstring(String s) {
        int left = 0, right = 0, slen = s.length(), maxLen = 0;
        Set<Character> currSet = new HashSet<>();
        char currChar;
        while (right < slen) {
            currChar = s.charAt(right);
            if (!currSet.contains(currChar)) {
                currSet.add(currChar);
                maxLen = Math.max(right-left+1, maxLen);
                right++;
            } else {
                while (currSet.contains(currChar)) {
                    currSet.remove(s.charAt(left++));
                }
            }
        }
        return maxLen;
    }
}

class Solution {
    public int lengthOfLongestSubstring(String s) {
        int size = 0, left = 0, right = 0, n = s.length();
        Integer prevIdx;
        Map<Character, Integer> charIdxMap = new HashMap<>();
        char nextChar;
        while(right < n) {
            nextChar = s.charAt(right);
            prevIdx = charIdxMap.get(nextChar);
            if (prevIdx != null && prevIdx >= left) {
                left = prevIdx+1;
            }
            charIdxMap.put(nextChar, right);
            size = Math.max(size, right-left+1);
            right++;
        }
        return size;
    }
}

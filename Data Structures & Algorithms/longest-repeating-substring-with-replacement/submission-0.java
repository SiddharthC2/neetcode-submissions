class Solution {
    public int characterReplacement(String s, int k) {
        Map<Character, Integer> countChar = new HashMap<>();
        int maxLen=0, left=0, right=0, currCount=0, maxCount=0;
        Character currChar, prevChar;
        while (right < s.length()) {
            currChar = s.charAt(right);
            currCount = countChar.getOrDefault(currChar, 0) + 1;
            countChar.put(currChar, currCount);
            maxCount = Math.max(currCount, maxCount);
            while (((right-left+1) - maxCount) > k) {
                prevChar = s.charAt(left);
                countChar.put(prevChar, countChar.get(prevChar)-1);
                left++;
            }
            maxLen = Math.max(maxLen, (right-left+1));
            right++;
        }
        return maxLen;
    }
}

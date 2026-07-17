class Solution {
    public int characterReplacement(String s, int k) {
        Map<Character, Integer> freqMap = new HashMap<>();
        int l=0, r=0, maxLen=0, maxFreq=0;
        char currChar;
        while (r<s.length()) {
            currChar = s.charAt(r);
            freqMap.put(currChar, freqMap.getOrDefault(currChar, 0)+1);
            maxFreq = Math.max(maxFreq, freqMap.get(currChar));

            while ((r-l+1)-maxFreq > k) {
                currChar = s.charAt(l);
                freqMap.put(currChar, freqMap.get(currChar)-1);
                l++;
            }
            
            maxLen = Math.max(maxLen, (r-l+1));
            r++;
        }
        return maxLen;
    }
}

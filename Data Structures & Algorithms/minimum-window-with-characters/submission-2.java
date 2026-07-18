class Solution {
    public String minWindow(String s, String t) {
        if (t.length() > s.length()) {
            return "";
        }
        Map<Character, Integer> sCharFreq = new HashMap<>();
        Map<Character, Integer> tCharFreq = new HashMap<>();
        for (int i=0; i<t.length(); i++) {
            tCharFreq.put(t.charAt(i), tCharFreq.getOrDefault(t.charAt(i), 0)+1);
        }
        Set<Character> tSet = tCharFreq.keySet();
        // expMatches : Expected character matches for a window
        int matches = 0, expMatches = tSet.size();
        int left = 0, right = 0, minWindow = Integer.MAX_VALUE;
        Character currChar;
        String minSubString = "";
        while (right < s.length()) {
            System.out.println("CurrSubStr: "+s.substring(left, right) + " matches: " + matches);
            if (matches == expMatches) {
                if(right-left < minWindow) {
                    minWindow = (right-left);
                    minSubString = s.substring(left, right);
                }
            }
            
            currChar = s.charAt(right);
            sCharFreq.put(currChar, sCharFreq.getOrDefault(currChar, 0)+1);
            // if its a common char only then it'll be a match, if uncommon, sCharFreq[char] > 0
            if (sCharFreq.getOrDefault(currChar, 0) == tCharFreq.getOrDefault(currChar, 0)) {
                matches++;
            }
            // Including right char in the window has just made a mismatch for that char
            // else if (tSet.contains(currChar) 
            //     && sCharFreq.getOrDefault(currChar, 0) == tCharFreq.getOrDefault(currChar, 0)+1) {
            //     matches--;
            // }
            right++;

            while (left < right) {
                currChar = s.charAt(left);
                if (!tSet.contains(currChar)) {
                    sCharFreq.put(currChar, sCharFreq.getOrDefault(currChar, 0)-1);
                    left++;
                } else if (sCharFreq.getOrDefault(currChar, 0) == tCharFreq.getOrDefault(currChar, 0)+1){
                    sCharFreq.put(currChar, sCharFreq.getOrDefault(currChar, 0)-1);
                    // matches++;
                    left++;
                } else {
                    break;
                }
            }
        }

        System.out.println("CurrSubStr: "+s.substring(left, right) + " matches: " + matches);
        if (matches == expMatches) {
            if(right-left < minWindow) {
                minWindow = (right-left);
                minSubString = s.substring(left, right);
            }
        }
        return minSubString;
    }
}

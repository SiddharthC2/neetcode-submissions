class Solution {

    private String getFrequencyStr(final String str) {
        int[] freqArr = new int[26];
        for (char strChar: str.toCharArray()) {
            freqArr[strChar-'a']++;
        }
        StringBuilder freqStrBldr = new StringBuilder();
        for (int i=0; i<26; i++) {
            freqStrBldr.append('a'+i);
            freqStrBldr.append(Integer.toString(freqArr[i]));
        }
        return freqStrBldr.toString();
    }

    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> anagramMap = new HashMap<>();
        String key;
        for (String str: strs) {
            key = getFrequencyStr(str);
            anagramMap.computeIfAbsent(key, k->new ArrayList<>()).add(str);
        }
        return new ArrayList<List<String>>(anagramMap.values());
    }
}

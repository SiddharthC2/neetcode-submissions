class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        if (strs.length == 0) {
            return null;
        }
        Map<String, List<String>> anagramMap = new HashMap<>();
        char[] keyChar;
        String key;
        for (String str: strs) {
            keyChar = str.toCharArray();
            Arrays.sort(keyChar);
            key = new String(keyChar);
            anagramMap.computeIfAbsent(key, k -> new ArrayList<>()).add(str);
        }
        List<List<String>> anagramList = new ArrayList<>();
        for (String str: anagramMap.keySet()) {
            anagramList.add(anagramMap.get(str));
        }
        return anagramList;
    }
}

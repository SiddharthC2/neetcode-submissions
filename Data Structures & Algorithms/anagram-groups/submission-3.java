class Solution {

    private int[] getCharCount(String str) {
        int[] charCountArr = new int[26];
        for (char strChar: str.toCharArray()) {
            charCountArr[strChar-'a']++;
        }
        return charCountArr;
    }

    private String getHashKey(int[] charCountArr) {
        StringBuilder strBuilder = new StringBuilder();
        for (int charCount: charCountArr) {
            strBuilder.append(String.valueOf(charCount));
            strBuilder.append('#');
        }
        return strBuilder.toString();
    }

    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> anagramMap = new HashMap<>();
        int[] charCountArr;
        String hashKey;
        for (String str: strs) {
            charCountArr = getCharCount(str);
            hashKey = getHashKey(charCountArr);
            anagramMap.putIfAbsent(hashKey, new ArrayList<>());
            anagramMap.get(hashKey).add(str);
        }
        return new ArrayList<>(anagramMap.values());
    }
}

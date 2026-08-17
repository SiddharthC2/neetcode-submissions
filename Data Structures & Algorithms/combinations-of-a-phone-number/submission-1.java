class Solution {
    public List<String> letterCombinations(String digits) {
        if (digits.length() == 0) {
            return List.of();
        }
        Map<Character, List<Character>> digitMap = new HashMap<>();
        digitMap.put('2', List.of('a', 'b', 'c'));
        digitMap.put('3', List.of('d', 'e', 'f'));
        digitMap.put('4', List.of('g', 'h', 'i'));
        digitMap.put('5', List.of('j', 'k', 'l'));
        digitMap.put('6', List.of('m', 'n', 'o'));
        digitMap.put('7', List.of('p', 'q', 'r', 's'));
        digitMap.put('8', List.of('t', 'u', 'v'));
        digitMap.put('9', List.of('w', 'x', 'y', 'z'));
        final List<String> combinations = new ArrayList<>();
        letterCombinations(digits, 0, new StringBuilder(), combinations, digitMap);
        return combinations;
    }

    private void letterCombinations(
        final String digits,
        final int idx,
        final StringBuilder stringBuilder,
        final List<String> combinations,
        final Map<Character, List<Character>> digitMap
    ) {
        if (idx == digits.length()) {
            combinations.add(stringBuilder.toString());
            return;
        }
        final List<Character> digitVals = digitMap.get(digits.charAt(idx));
        for (Character curr: digitVals) {
            stringBuilder.append(curr);
            letterCombinations(digits, idx+1, stringBuilder, combinations, digitMap);
            stringBuilder.deleteCharAt(stringBuilder.length()-1);
        }

    }
}

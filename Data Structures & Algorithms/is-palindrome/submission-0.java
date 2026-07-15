class Solution {
    public boolean isPalindrome(String s) {
        StringBuilder alphaNumericStrBldr = new StringBuilder();
        for (char currChar: s.toCharArray()) {
            if (currChar >= 'a' && currChar <= 'z') {
                alphaNumericStrBldr.append(currChar);
            } else if (currChar >= '0' && currChar <= '9') {
                alphaNumericStrBldr.append(currChar);
            } else if (currChar >= 'A' && currChar <= 'Z') {
                alphaNumericStrBldr.append((char)(currChar+32));
            }
        }
        String alphaNumericStr = alphaNumericStrBldr.toString();
        // System.out.println(alphaNumericStr);
        int left = 0, right = alphaNumericStr.length()-1;
        while (left<right) {
            if (alphaNumericStr.charAt(left) != alphaNumericStr.charAt(right))
                return false;
            left++;
            right--;
        }
        return true;
    }
}

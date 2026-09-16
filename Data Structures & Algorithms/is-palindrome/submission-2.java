class Solution {
    public boolean isPalindrome(String s) {
        int left = 0, right = s.length()-1;
        char leftChar, rightChar;
        int leftCharType, rightCharType;
        while (left < right) {
            leftChar = s.charAt(left);
            leftCharType = getCharType(leftChar);
            if (leftCharType == -1) {
                left++;
                continue;
            }
            rightChar = s.charAt(right);
            rightCharType = getCharType(rightChar);
            if (rightCharType == -1) {
                right--;
                continue;
            }
            if (leftCharType == rightCharType) {
                if (leftChar != rightChar) return false;
            } else if (leftCharType == 0 && rightCharType == 1) {
                if (leftChar-'A' != rightChar-'a') return false;
            } else if (leftCharType == 1 && rightCharType == 0) {
                if (leftChar-'a' != rightChar-'A') return false;
            } else {
                return false;
            }
            left++;
            right--;
        }
        return true;        
    }

    private int getCharType(char c) {
        if (c >= 'A' && c <= 'Z') return 0;
        if (c >= 'a' && c <= 'z') return 1;
        if (c >= '0' && c <= '9') return 2;
        return -1;
    }
}

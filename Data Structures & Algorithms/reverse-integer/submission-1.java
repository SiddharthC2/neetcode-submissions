class Solution {
    public int reverse(int x) {
        if (x == Integer.MIN_VALUE) {
            return 0;
        }
        boolean isNeg = false;
        if (x < 0) {
            isNeg = true;
            x *= -1;
        }
        int reverseNum = 0, prev;
        while (x > 0) {
            prev = reverseNum;
            reverseNum *= 10;
            // System.out.println(prev + " " + reverseNum);
            if (reverseNum/10 != prev) return 0;
            reverseNum += (x%10);
            x /= 10;
        }
        if (isNeg) return -1*reverseNum;
        return reverseNum;        
    }
}

class Solution {
    public int[] plusOne(int[] digits) {
        int n = digits.length, carry = 1;
        int curr = n-1;
        do {
            digits[curr] += carry;
            carry = digits[curr]/10;
            digits[curr] = digits[curr]%10;
            curr--;
        } while (curr >= 0 && carry != 0);

        if (carry != 0) {
            int[] answer = new int[n+1];
            answer[0] = 1;
            return answer;
        }
        return digits;
    }
}

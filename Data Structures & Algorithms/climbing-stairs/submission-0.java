class Solution {
    public int climbStairs(int n) {
        if (n <= 2) return n;
        int one = 1, two = 2, three = 0;
        n -= 2;
        while (n!=0) {
            three = one + two;
            one = two;
            two = three;
            n--;
        }
        return three;
    }
}

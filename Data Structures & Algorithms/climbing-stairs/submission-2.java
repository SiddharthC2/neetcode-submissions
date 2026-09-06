class Solution {
    public int climbStairs(int n) {
        if (n <= 2) return n;
        int one = 1, two = 2, three = 0;
        for (int i=2; i<n; i++) {
            three = one + two;
            one = two;
            two = three;
        }
        return three;
    }
}

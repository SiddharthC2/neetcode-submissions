class Solution {
    public int climbStairs(int n) {
        if (n == 1 || n == 2) return n;
        return bottomUp2(n);
    }

    private int bottomUp2(final int n) {
        int prev = 2, prev2 = 1;
        int curr = 2;
        for (int i=3; i<=n; i++) {
            curr = prev + prev2;
            prev2 = prev;
            prev = curr;
        }
        return curr;
    }
}

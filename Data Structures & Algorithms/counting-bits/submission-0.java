class Solution {
    public int[] countBits(int n) {
        final int[] bits = new int[n+1];
        for (int i=0; i<=n; i++) {
            bits[i] = bitCount(i);
        }
        return bits;
    }

    private int bitCount(int n) {
        int count = 0;
        while (n > 0) {
            count += (n%2 == 0) ? 0 : 1;
            n = n >> 1;
        }
        return count;
    }
}

class Solution {
    public int hammingWeight(int n) {
        int curr = n, weight = 0;
        while (curr != 0) {
            if (curr % 2 == 1) {
                weight += 1;
            }
            curr = curr >> 1;
        }
        return weight;
    }
}

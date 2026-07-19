class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        int[] nextWarmDelta = new int[n];
        int j;
        for (int i=n-2; i>=0; i--) {
            j = i+1;
            while (j<n && temperatures[i] >= temperatures[j]) {
                if (nextWarmDelta[j] == 0) {
                    j = n;
                    break;
                }
                j += nextWarmDelta[j];
            }
            if (j<n) {
                nextWarmDelta[i] = j-i;
            }
        }
        return nextWarmDelta;
    }
}

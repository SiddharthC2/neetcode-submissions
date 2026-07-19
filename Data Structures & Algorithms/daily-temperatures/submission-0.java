class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int tlen = temperatures.length;
        int[] nextWarmDelta = new int[tlen];
        int currTemp;
        for (int i=0; i<tlen; i++) {
            currTemp = temperatures[i];
            for (int j=i+1; j<tlen; j++) {
                if (currTemp < temperatures[j]) {
                    nextWarmDelta[i] = j-i;
                    break;
                }
            }
        }
        return nextWarmDelta;
    }
}

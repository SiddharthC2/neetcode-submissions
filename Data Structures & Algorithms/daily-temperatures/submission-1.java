class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int tlen = temperatures.length;
        int[] nextWarmDelta = new int[tlen];
        int currTemp, currIdx;
        Deque<Integer> tempStack = new ArrayDeque<>();
        for (int i=0; i<tlen; i++) {
            currTemp = temperatures[i];
            while(!tempStack.isEmpty() && currTemp > temperatures[tempStack.peek()]) {
                currIdx = tempStack.pop();
                nextWarmDelta[currIdx] = i-currIdx;
            }
            tempStack.push(i);
        }
        return nextWarmDelta;
    }
}

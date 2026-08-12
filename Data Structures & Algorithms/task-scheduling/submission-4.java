class Solution {
    public int leastInterval(char[] tasks, int n) {
        if (n == 0) return tasks.length;
        int[] freq = new int[26];
        for (char task: tasks) {
            freq[task-'A']++;
        }

        int maxFreq = 0, maxCount = 0;
        for (int i=0; i<26; i++) {
            if (freq[i] > maxFreq) {
                maxFreq = freq[i];
                maxCount = 0;
            }
            if (maxFreq == freq[i]) {
                maxCount++;
            }
        }
        int math = (maxFreq-1)*(n+1)+maxCount;
        return Math.max(tasks.length, math);
    }
}

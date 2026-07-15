class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> numsFreq = new HashMap<>();
        for (Integer num: nums) {
            numsFreq.put(num, numsFreq.getOrDefault(num, 0) + 1);
        }
        List<Integer>[] freqNumArr = new List[nums.length+1];
        for (int i=0; i<freqNumArr.length; i++) {
            freqNumArr[i] = new ArrayList<>();
        }
        for (Map.Entry<Integer, Integer> entry: numsFreq.entrySet()) {
            freqNumArr[entry.getValue()].add(entry.getKey());
        }
        int[] topKFrequentNumArr = new int[k];
        int idx=0;
        for(int i=nums.length; i>=1 && k>idx; i--) {
            for (Integer num: freqNumArr[i]) {
                if (k==idx) {
                    return topKFrequentNumArr;
                } else {
                    topKFrequentNumArr[idx++] = num;
                }
            }
        }
        return topKFrequentNumArr;
    }
}

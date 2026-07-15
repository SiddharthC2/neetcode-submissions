class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> numsFreq = new HashMap<>();
        Integer freq;
        for (Integer num: nums) {
            freq = numsFreq.get(num);
            freq = freq == null ? 0 : freq;
            numsFreq.put(num, freq+1);
        }
        Map<Integer, List<Integer>> freqNumList = new HashMap<>();
        for (Integer num: numsFreq.keySet()) {
            freq = numsFreq.get(num);
            freqNumList.computeIfAbsent(freq, f->new ArrayList<>()).add(num);
        }
        List<Integer> freqKeys = new ArrayList<>(freqNumList.keySet());
        Collections.sort(freqKeys);
        List<Integer> numList;
        List<Integer> topKFrequentNum = new ArrayList<>();
        int minElements;
        for (int i=freqKeys.size()-1; i>=0 && k>0; i--) {
            numList = freqNumList.get(freqKeys.get(i));
            minElements = Math.min(k, numList.size());
            topKFrequentNum.addAll(numList.subList(0, minElements));
            k -= minElements;
        }
        int[] topKFrequentNumArr = new int[topKFrequentNum.size()];
        for (int i=0; i<topKFrequentNumArr.length; i++) {
            topKFrequentNumArr[i] = topKFrequentNum.get(i);
        }
        return topKFrequentNumArr;
    }
}

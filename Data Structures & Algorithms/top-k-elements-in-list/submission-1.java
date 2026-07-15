class Solution {

    private Map<Integer, Integer> getNumFrequency(int[] nums) {
        Map<Integer, Integer> numFrequencyMap = new HashMap<>();
        for (int num: nums) {
            numFrequencyMap.put(num, numFrequencyMap.getOrDefault(num, 0) + 1);
        }
        return numFrequencyMap;
    }

    private Map<Integer, List<Integer>> getFrequencyNum(Map<Integer, Integer> numFrequencyMap) {
        Map<Integer, List<Integer>> frequencyNumMap = new HashMap<>();
        Integer frequency;
        for (Integer num: numFrequencyMap.keySet()) {
            frequency = numFrequencyMap.get(num);
            frequencyNumMap.putIfAbsent(frequency, new ArrayList<>());
            frequencyNumMap.get(frequency).add(num);
        }
        return frequencyNumMap;
    }

    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> numFrequencyMap = getNumFrequency(nums);
        Map<Integer, List<Integer>> frequencyNumMap = getFrequencyNum(numFrequencyMap);
        List<Integer> numList, slice;
        List<Integer> topKFreqList = new ArrayList<>();
        int remaining = k;
        for (int freq=nums.length; freq>0 && remaining > 0; freq--) {
            numList = frequencyNumMap.get(freq);
            if (numList == null)
                continue;
            slice = numList.subList(0, Math.min(remaining, numList.size()));
            topKFreqList.addAll(slice);
            remaining -= slice.size();
        }
        int[] topKFreqArr = new int[topKFreqList.size()];
        for (int i=0; i<topKFreqList.size(); i++) {
            topKFreqArr[i] = topKFreqList.get(i);
        }
        return topKFreqArr;
    }
}

class TimeMap {

    private static class Pair<K,V> {
        private final K key;
        private final V value;

        public Pair(K key, V value) {
            this.key=key;
            this.value=value;
        }

        public K getKey() {
            return key;
        }

        public V getValue() {
            return value;
        }
    }

    Map<String, List<Pair<String, Integer>>> keyPairMap;

    public TimeMap() {
        keyPairMap = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        keyPairMap.computeIfAbsent(key, k-> new ArrayList<>())
            .add(new Pair<>(value, timestamp));
    }
    
    public String get(String key, int timestamp) {
        List<Pair<String, Integer>> pairList = keyPairMap.get(key);
        if (pairList == null) {
            return "";
        }
        int n=pairList.size(), left=0, right=n-1, mid;
        int currTimeStamp;
        while(left <= right) {
            mid = left + (right-left)/2;
            currTimeStamp = pairList.get(mid).getValue();
            if (currTimeStamp == timestamp) {
                right = mid;
                break;
            }
            else if (currTimeStamp > timestamp) {
                right = mid-1;
            } else {
                left = mid+1;
            }
        }
        if (right == -1) {
            return "";
        }
        return pairList.get(right).getKey();
        
    }
}

class KthLargest {

    private static class MinHeap {

        private List<Integer> heapList;
        private int heapSize;
        
        public MinHeap () {
            heapList = new ArrayList<>();
            heapSize = 0;
        }

        public int size() {
            return heapSize;
        }

        public void offer(int num) {
            heapList.add(num);
            heapSize++;
            adjustInsert();
        }

        public void poll() {
            if (heapSize <= 0) return;
            heapList.set(0, heapList.get(heapSize-1));
            heapList.remove(heapSize-1);
            heapSize--;
            adjustDelete();
        }

        public Integer peek() {
            if (heapSize > 0) return heapList.get(0);
            return null;
        }

        private void adjustInsert() {
            int curr = heapSize-1, parent = (curr-1)/2, temp;
            while (parent >= 0 && heapList.get(curr) < heapList.get(parent)) {
                temp = heapList.get(curr);
                heapList.set(curr, heapList.get(parent));
                heapList.set(parent, temp);

                curr = parent;
                parent = (curr-1)/2;
            }
        }

        private void adjustDelete() {
            int curr = 0, childL = (curr*2)+1, childR = childL+1;
            int swapIdx = 0, temp;
            while (childL < heapSize) {
                swapIdx = childL;
                if (childR < heapSize && heapList.get(childL) > heapList.get(childR)) {
                    swapIdx = childR;
                }
                if (heapList.get(curr) <= heapList.get(swapIdx)) {
                    return;
                }
                temp = heapList.get(curr);
                heapList.set(curr, heapList.get(swapIdx));
                heapList.set(swapIdx, temp);

                curr = swapIdx;
                childL = (curr*2)+1;
                childR = childL+1;
            }
        }

        public void print() {
            for (int i=0; i<heapSize; i++) {
                System.out.print(heapList.get(i) + ", ");
            }
            System.out.println();
        }
    }

    private MinHeap minHeap;
    private int k;

    public KthLargest(int k, int[] nums) {
        this.k = k;
        minHeap = new MinHeap();
        for (int num: nums) {
            minHeap.offer(num);
        }
        for (int i=nums.length; i>k; i--){
            minHeap.poll();
        }
        // minHeap.print();
    }
    
    public int add(int val) {
        minHeap.offer(val);
        // minHeap.print();
        if (minHeap.size() > k) {
            minHeap.poll();
        }
        // minHeap.print();
        return minHeap.peek();
    }
}

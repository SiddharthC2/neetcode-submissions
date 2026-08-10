class Solution {

    private static class MaxHeap {
        
        private List<Integer> heap;
        private int heapSize;

        public MaxHeap() {
            heap = new ArrayList<>();
            heapSize = 0;
        }

        public int size() {
            return heapSize;
        }

        public Integer peek() {
            if (heapSize == 0) return null;
            return heap.get(0);
        }

        public void build(int[] nums) {
            for (int num: nums) {
                heap.add(num);
            }
            heapSize = heap.size();
            for (int i=heapSize-1; i>=0; i--) {
                heapifyDown(i);
            }
        }

        public void offer(int num) {
            heap.add(num);
            heapSize++;
            heapifyUp();
        }

        public Integer poll() {
            if (heapSize == 0) return null;
            Integer top = this.peek();
            heap.set(0, heap.get(heapSize-1));
            heap.remove(heapSize-1);
            heapSize--;
            heapifyDown(0);
            return top;
        }

        private void heapifyUp() {
            int curr = heapSize-1, parent = (curr-1)/2;
            while (parent >= 0 && heap.get(parent) < heap.get(curr)) {
                swap(curr, parent);
                curr = parent;
                parent  = (curr-1)/2;
            }
        }

        private void heapifyDown(int curr) {
            int childL = (curr*2)+1, childR = childL+1;
            int swapIdx;
            while (childL < heapSize) {
                swapIdx = childL;
                if (childR < heapSize && heap.get(childR) >= heap.get(childL)) {
                    swapIdx = childR;
                }
                if (heap.get(curr) >= heap.get(swapIdx)) {
                    return;
                }
                swap(curr, swapIdx);
                curr = swapIdx;
                childL = (curr*2)+1;
                childR = childL+1;
            }

        }

        private void swap(int idx1, int idx2) {
            int temp = heap.get(idx1);
            heap.set(idx1, heap.get(idx2));
            heap.set(idx2, temp);
        }

        public void print() {
            for (int num: heap) {
                System.out.print(num + ", ");
            }
            System.out.println();
        }

    }

    public int lastStoneWeight(int[] stones) {
        MaxHeap maxHeap = new MaxHeap();
        maxHeap.build(stones);
        // maxHeap.print();
        while (maxHeap.size() > 1) {
            int stone1 = maxHeap.poll();
            // maxHeap.print();
            int stone2 = maxHeap.poll();
            // maxHeap.print();
            int diff = stone1 - stone2;
            if (diff == 0) {
                continue;
            } else {
                maxHeap.offer(diff);
            }
            // maxHeap.print();
        }
        // maxHeap.print();
        Integer rem = maxHeap.peek();
        return rem == null ? 0 : rem;
        
    }
}

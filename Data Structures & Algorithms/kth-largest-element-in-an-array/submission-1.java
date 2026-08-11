class Solution {

    private static class MaxHeap {

        private final List<Integer> heap;
        private int size;

        public MaxHeap() {
            this.heap = new ArrayList<>();
            this.size = 0;
        }

        public int size() {
            return this.size;
        }

        public void build(final int[] nums) {
            for (int num: nums) {
                heap.add(num);
            }
            size = heap.size();
            for (int i=size-1; i>=0; i--) {
                heapifyDown(i);
            }
        }

        public Integer peek() {
            if (size == 0) return null;
            return heap.get(0);
        }

        public Integer poll() {
            if (size == 0) return null;
            Integer min = this.peek();
            heap.set(0, heap.get(size-1));
            heap.remove(size-1);
            size--;
            heapifyDown(0);
            return min;
        }

        public void offer(final int num) {
            heap.add(num);
            size++;
            heapifyUp(size-1);
        }

        private void heapifyDown(int curr) {
            int childL = (curr*2)+1, childR = childL+1;
            int swapIdx;
            while (childL < size) {
                swapIdx = childL;
                if (childR < size && heap.get(childL) <= heap.get(childR)) {
                    swapIdx = childR;
                }
                if (heap.get(swapIdx) <= heap.get(curr)) {
                    return;
                }
                swap(curr, swapIdx);
                curr = swapIdx;
                childL = (curr*2)+1;
                childR = childL+1;
            }
        }

        private void heapifyUp(int curr) {
            int parent = (curr-1)/2;
            while (parent >= 0 && heap.get(parent) < heap.get(curr)) {
                swap(curr, parent);
                curr = parent;
                parent = (curr-1)/2;
            }
        }

        private void swap(final int idx1, final int idx2) {
            int tmp = heap.get(idx1);
            heap.set(idx1, heap.get(idx2));
            heap.set(idx2, tmp);
        }

        public void print() {
            for (int i=0; i<size; i++) {
                System.out.print(heap.get(i)+", ");
            }
            System.out.println();
        }

    }

    public int findKthLargest(int[] nums, int k) {
        final MaxHeap maxHeap = new MaxHeap();
        maxHeap.build(nums);
        // maxHeap.print();
        while (k>1) {
            maxHeap.poll();
            k--;
            // maxHeap.print();
        }
        //  maxHeap.print();
        return maxHeap.peek();
    }
}

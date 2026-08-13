class MedianFinder {

    private final MaxHeap maxHeap;
    private final MinHeap minHeap;
    private int size;

    public MedianFinder() {
        maxHeap = new MaxHeap();
        minHeap = new MinHeap();
        size = 0;
    }
    
    // time O(2*log(n))
    public void addNum(int num) {
        int newNum = num;
        if (size % 2 == 0) {
            Integer min = minHeap.peek();
            if (min != null && min < num) {
                newNum = minHeap.poll();
                minHeap.offer(num);
            }
            maxHeap.offer(newNum);
        } else {
            Integer max = maxHeap.peek();
            if (max != null && max > num) {
                newNum = maxHeap.poll();
                maxHeap.offer(num);
            }
            minHeap.offer(newNum);
        }
        size++;
    }
    
    // time O(1)
    public double findMedian() {
        if (size == 0) {
            return 0d;
        } else if (size % 2 == 0) {
            return ((double) (maxHeap.peek()+minHeap.peek()))/2d;
        } else {
            return (double) maxHeap.peek();
        }       
    }

    // MaxHeap
    private static class MaxHeap {

        private final List<Integer> heap;

        public MaxHeap () {
            heap = new ArrayList<>();
        }

        public int size() {
            return heap.size();
        }

        public Integer peek() {
            if (heap.size() == 0) return null;
            return heap.get(0);
        }

        public Integer poll() {
            if (heap.size() == 0) return null;
            Integer top = peek();
            heap.set(0, heap.get(size()-1));
            heap.remove(size()-1);
            heapifyDown(0);
            return top;
        }

        public void offer(final int num) {
            heap.add(num);
            heapifyUp(size()-1);
        }

        private void heapifyUp(int curr) {
            if (curr == 0) return;
            int parent = (curr-1)/2;
            while (parent >= 0 && heap.get(parent) < heap.get(curr)) {
                swap(curr, parent);
                curr = parent;
                parent = (curr-1)/2;
            }
        }

        private void heapifyDown(int curr) {
            int childL = (curr*2)+1, childR = childL+1, swapIdx;
            while (childL < size()) {
                swapIdx = childL;
                if (childR < size() && heap.get(childR) >= heap.get(childL)) {
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

        private void swap(final int idx1, final int idx2) {
            final int temp = heap.get(idx1);
            heap.set(idx1, heap.get(idx2));
            heap.set(idx2, temp);
        }

    }

    // MinHeap
    private static class MinHeap {

        private final List<Integer> heap;

        public MinHeap () {
            heap = new ArrayList<>();
        }

        public int size() {
            return heap.size();
        }

        public Integer peek() {
            if (heap.size() == 0) return null;
            return heap.get(0);
        }

        public Integer poll() {
            if (heap.size() == 0) return null;
            Integer top = peek();
            heap.set(0, heap.get(size()-1));
            heap.remove(size()-1);
            heapifyDown(0);
            return top;
        }

        public void offer(final int num) {
            heap.add(num);
            heapifyUp(size()-1);
        }

        private void heapifyUp(int curr) {
            if (curr == 0) return;
            int parent = (curr-1)/2;
            while (parent >= 0 && heap.get(parent) > heap.get(curr)) {
                swap(curr, parent);
                curr = parent;
                parent = (curr-1)/2;
            }
        }

        private void heapifyDown(int curr) {
            int childL = (curr*2)+1, childR = childL+1, swapIdx;
            while (childL < size()) {
                swapIdx = childL;
                if (childR < size() && heap.get(childR) <= heap.get(childL)) {
                    swapIdx = childR;
                }
                if (heap.get(swapIdx) >= heap.get(curr)) {
                    return;
                }
                swap(curr, swapIdx);
                curr = swapIdx;
                childL = (curr*2)+1;
                childR = childL+1; 
            }
        }

        private void swap(final int idx1, final int idx2) {
            final int temp = heap.get(idx1);
            heap.set(idx1, heap.get(idx2));
            heap.set(idx2, temp);
        }

    }
}

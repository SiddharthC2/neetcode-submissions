class Solution {

    private static final class MaxHeap {

        private final List<Integer> heap;

        public MaxHeap() {
            heap = new ArrayList<>();
        }

        public void build(int[] nums) {
            for (int num: nums) {
                heap.add(num);
            }
            for (int i=heap.size()-1; i>=0; i--) {
                heapifyDown(i);
            }
        }

        public Integer poll() {
            if (heap.size() == 0) return null;
            Integer peek = heap.get(0);
            heap.set(0, heap.get(heap.size()-1));
            heap.remove(heap.size()-1);
            heapifyDown(0);
            return peek;
        }

        public void offer(int num) {
            heap.add(num);
            heapifyUp(heap.size()-1);
        }

        private void heapifyDown(int curr) {
            int childL = (curr*2)+1, childR = childL+1;
            int size = heap.size(), swapIdx;
            while (childL < size) {
                swapIdx = childL;
                if (childR < size && heap.get(childR) >= heap.get(childL)) {
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

        private void heapifyUp(int curr) {
            int parent = (curr-1)/2;
            while (parent >= 0 && heap.get(parent) < heap.get(curr)) {
                swap(curr, parent);
                curr = parent;
                parent = (curr-1)/2;
            }
        }

        private void swap(int idx1, int idx2) {
            int tmp = heap.get(idx1);
            heap.set(idx1, heap.get(idx2));
            heap.set(idx2, tmp);
        }

        public void print() {
            System.out.print("HEAP: ");
            for (int i=0; i<heap.size(); i++) {
                System.out.print(heap.get(i) + ", ");
            }
            System.out.println();
        }

    }

    public int leastInterval(char[] tasks, int n) {
        if (n == 0 || tasks.length == 1) return tasks.length;
        int[] freq = new int[26];
        int unique = 0;
        for (char task: tasks) {
            if (freq[task-'A'] == 0) unique++;
            freq[task-'A']++;
        }
        int[] freqNonZero = new int[unique];
        int curr = 0;
        for (int i=0; i<26; i++) {
            if (freq[i] != 0) {
                freqNonZero[curr++] = freq[i];
            }
        }

        final MaxHeap maxHeap = new MaxHeap();
        maxHeap.build(freqNonZero);
        // maxHeap.print();
        final Queue<int[]> waitQ = new ArrayDeque<>();

        int cycles = 0, completed = 0, remTask = 0;
        Integer currTask;
        while (completed < tasks.length) {
            while (!waitQ.isEmpty() && waitQ.peek()[1] == cycles) {
                maxHeap.offer(waitQ.poll()[0]);
            }
            // maxHeap.print();
            currTask = maxHeap.poll();
            // System.out.println("cycles: "+cycles+" :: curr: "+currTask);
            if (currTask != null) {
                remTask = currTask-1;
                if (remTask != 0) {
                    int[] taskPair = new int[2];
                    taskPair[0] = remTask;
                    taskPair[1] = cycles+n+1;
                    waitQ.offer(taskPair);
                }
                completed++;
            }
            // System.out.print("QUEUE: ");
            // for (int[] x : waitQ) {
            //     System.out.print(x[0]+"|"+x[1]+"||");
            // }
            // System.out.println();
            // System.out.println("COMPLETED: "+completed);
            // System.out.println();
            
            cycles++;
        }
        return cycles;
    }
}

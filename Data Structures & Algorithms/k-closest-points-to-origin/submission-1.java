class Solution {

    private static class Point implements Comparable<Point> {
        
        private final int idx;
        private final double distance;

        public Point(final int idx, final double distance) {
            this.idx = idx;
            this.distance = distance;
        }

        public int getIdx() {
            return this.idx;
        }

        public double getDistance() {
            return this.distance;
        }

        @Override
        public int compareTo(Point other) {
            return Double.compare(this.getDistance(), other.getDistance());
        }

    }

    private static class MinHeap {

        private final List<Point> heap;
        private int heapSize;

        public MinHeap() {
            this.heap = new ArrayList<>();
            heapSize = 0;
        }

        public int getSize() {
            return this.heapSize;
        }

        public Point peek() {
            if (heapSize == 0) return null;
            return heap.get(0);
        }

        public Point poll() {
            if (heapSize == 0) return null;
            Point peek = this.peek();
            heap.set(0, heap.get(heapSize-1));
            heap.remove(heapSize-1);
            heapSize--;
            heapifyDown(0);
            return peek;
        }

        public void offer(final Point point) {
            heap.add(point);
            heapSize++;
            heapifyUp(heapSize-1);
        }

        public void build(final Point[] points) {
            for (Point point: points) {
                heap.add(point);
            }
            heapSize = heap.size();
            for (int i=heapSize-1; i>=0; i--) {
                heapifyDown(i);
            }
        }

        private void heapifyDown(int curr) {
            int childL = (curr*2)+1, childR = childL+1;
            int swapIdx;
            while (childL < heapSize) {
                swapIdx = childL;
                if (childR < heapSize && heap.get(childR).compareTo(heap.get(childL)) <= 0) {
                    swapIdx = childR;
                }
                if (heap.get(curr).compareTo(heap.get(swapIdx)) == 1) {
                    swap(curr, swapIdx);
                }
                curr = swapIdx;
                childL = (curr*2)+1;
                childR = childL+1;
            }
        }

        private void heapifyUp(int curr) {
            int parent = (curr-1)/2;
            while (parent >= 0 && heap.get(parent).compareTo(heap.get(curr)) == 1) {
                swap(curr, parent);
                curr = parent;
                parent = (curr-1)/2;
            }
        }

        private void swap(int idx1, int idx2) {
            Point temp = heap.get(idx1);
            heap.set(idx1, heap.get(idx2));
            heap.set(idx2, temp);
        }

    }

    public int[][] kClosest(int[][] points, int k) {
        int n = points.length;
        Point[] pointObjs = new Point[n];
        double distance;
        for (int i=0; i<n; i++) {
            int[] point = points[i];
            distance = Math.sqrt((double) ((point[0]*point[0]) + (point[1]*point[1])));
            Point pointObj = new Point(i, distance);
            pointObjs[i] = pointObj;
        }

        MinHeap minHeap = new MinHeap();
        minHeap.build(pointObjs);

        int[][] kPoints = new int[k][2];
        for (int i=0; i<k; i++) {
            Point pointObj = minHeap.poll();
            kPoints[i][0] = points[pointObj.getIdx()][0];
            kPoints[i][1] = points[pointObj.getIdx()][1];
        }
        return kPoints;
    }
}

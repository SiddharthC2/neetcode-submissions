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

        int left = 0, right = n-1, pivot = n;
        while (pivot != k) {
            pivot = partition(pointObjs, left, right);
            if (pivot < k) {
                left = pivot+1;
            } else {
                right = pivot-1;
            }
        }

        int[][] kPoints = new int[k][2];
        for (int i=0; i<k; i++) {
            int idx = pointObjs[i].getIdx();
            kPoints[i][0] = points[idx][0];
            kPoints[i][1] = points[idx][1];
        }
        return kPoints;
    }

    private int partition(Point[] points, int left, int right) {
        int pivot = right;
        int i=left;
        for (int j=left; j<right; j++) {
            if (points[j].compareTo(points[pivot]) < 0) {
                Point temp = points[j];
                points[j] = points[i];
                points[i] = temp;
                i++;
            }
        }
        Point temp = points[i];
        points[i] = points[pivot];
        points[pivot] = temp;
        return i;
    }
}

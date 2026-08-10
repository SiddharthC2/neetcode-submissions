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

        Arrays.sort(pointObjs);

        int[][] kPoints = new int[k][2];
        for (int i=0; i<k; i++) {
            Point pointObj = pointObjs[i];
            kPoints[i][0] = points[pointObj.getIdx()][0];
            kPoints[i][1] = points[pointObj.getIdx()][1];
        }
        return kPoints;
    }
}

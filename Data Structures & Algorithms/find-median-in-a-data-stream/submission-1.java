class MedianFinder {

    private List<Integer> nums;

    public MedianFinder() {
        nums = new ArrayList<>();
    }
    
    public void addNum(int num) {
        int left = 0, right = nums.size()-1, mid;
        while (left <= right) {
            mid = left + (right-left)/2;
            if (nums.get(mid) > num) {
                right = mid-1;
            } else {
                left = mid+1;
            }
        }
        nums.add(num);
        int curr = nums.size()-1;
        while (curr > right+1) {
            nums.set(curr, nums.get(curr-1));
            curr--;
        }
        nums.set(curr, num);
    }
    
    public double findMedian() {
        // for (int num: nums) {
        //     System.out.print(num+", ");
        // }
        // System.out.println();
        int n = nums.size();
        if (n % 2 == 0) {
            return ((double) (nums.get(n/2)+nums.get((n/2)-1)))/2d;
        } else {
            return (double) nums.get(n/2);
        }
        
    }
}

class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int low = 1, high = 1, mid, k;
        for (int pile: piles) {
            high = Math.max(high, pile);
        }
        while (low <= high) {
            mid = low + (high - low)/2;
            k = timeToEat(piles, mid);
            if (k > h) {
                low = mid+1;
            } else {
                high = mid-1;
            }
        }
        return low;
    }

    private int timeToEat(final int[] piles, final int mid) {
        int totalTime = 0;
        for (int pile: piles) {
            totalTime += Math.ceil((double) pile/mid);
        }
        return totalTime;
    }


}

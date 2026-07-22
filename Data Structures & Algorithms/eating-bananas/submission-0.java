class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int min=1, max=0, mid, n = piles.length;
        for (int i=0; i<n; i++) {
            max = Math.max(piles[i], max);
        }
        
        while (min <= max) {
            mid = min + (max-min)/2;
            if (canEat(piles, h, mid) == true) {
                max = mid-1;
            } else {
                min = mid+1;
            }
        }
        return min;
    }

    private boolean canEat(int[] piles, int h, int k) {
        int n = piles.length, totalHours = 0;
        for (int i=0; i<n; i++) {
            totalHours += Math.ceil((double) piles[i]/k);
        }
        if (totalHours <= h) {
            return true;
        }
        return false;
    }
}

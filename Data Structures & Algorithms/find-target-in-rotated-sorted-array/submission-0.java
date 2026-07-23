class Solution {
    public int search(int[] nums, int target) {
        int left = 0, right = nums.length-1, mid;
        while (left < right) {
            mid = left+(right-left)/2;
            if (nums[mid] < nums[right]) {
                right = mid;
            } else {
                left = mid+1;
            }
        }
        mid = left;
        left = 0;
        right = nums.length-1;
        if (nums[mid] == target) {
            return mid;
        }
        if (nums[mid] < target && nums[right] < target) {
            right = mid-1;
        } else {
            left = mid+1;
        }
        while (left<=right) {
            mid = left+(right-left)/2;
            if (nums[mid] == target) {
                return mid;
            } if (nums[mid] > target) {
                right = mid-1;
            } else {
                left = mid+1;
            }
        }
        return -1;
    }
}

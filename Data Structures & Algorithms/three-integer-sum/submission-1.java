class Solution {

    private int moveLeftPtr(int left, int right, int[] nums) {
        do {
            left++;
        } while (left < right && nums[left-1]==nums[left]);
        return left;
    }

    private int moveRightPtr(int left, int right, int[] nums) {
        do {
            right--;
        } while (left < right && nums[right+1]==nums[right]);
        return right;
    }

    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> triplets = new ArrayList<>();
        int ptr1, left, right, target;
        ptr1 = 0;
        while (ptr1 < nums.length-2) {
            left = ptr1+1;
            right = nums.length-1;
            while (left < right) {
                target = nums[ptr1] + nums[left] + nums[right];
                if (target == 0) {
                    triplets.add(List.of(nums[ptr1], nums[left], nums[right]));
                    left = moveLeftPtr(left, right, nums);
                    right = moveRightPtr(left, right, nums);
                } else if (target > 0) {
                    right = moveRightPtr(left, right, nums);
                } else {
                    left = moveLeftPtr(left, right, nums);
                }
            }
            do {
                ptr1++;
            } while (ptr1 < nums.length-2 && nums[ptr1-1]==nums[ptr1]);
        }
        return triplets;
    }
}

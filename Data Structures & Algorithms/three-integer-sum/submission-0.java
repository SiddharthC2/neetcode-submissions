class Solution {

    private int moveRightSide(int[] nums, int ptr) {
        int ptr2 = ptr;
        while (ptr < nums.length && nums[ptr] == nums[ptr2]) {
            ptr++;
        }
        return ptr;
    }

    private int moveLeftSide(int[] nums, int ptr) {
        int ptr2 = ptr;
        while (ptr >= 0 && nums[ptr] == nums[ptr2]) {
            ptr--;
        }
        return ptr;
    }

    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> triplets = new ArrayList<>();
        int ptr=0, left, right, currSum;
        while (ptr < nums.length-2) {
            left = ptr+1;
            right = nums.length-1;
            while (left < right) {
                currSum = nums[ptr] + nums[left] + nums[right];
                if (currSum == 0) {
                    triplets.add(new ArrayList<>(List.of(nums[ptr], nums[left], nums[right])));
                    // move left and right;
                    left = moveRightSide(nums, left);
                    right = moveLeftSide(nums, right);
                } else if (currSum > 0) {
                    // move rigth ptr
                    right = moveLeftSide(nums, right);
                } else {
                    // move left ptr
                    left = moveRightSide(nums, left);
                }
            }
            ptr = moveRightSide(nums, ptr);
        }
        return triplets;
    }
}

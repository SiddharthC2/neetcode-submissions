class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> threeSumLists = new ArrayList<>();
        Arrays.sort(nums);
        int n = nums.length, k = n-2, ptr1 = 0, ptr2, ptr3, currSum;
        while (ptr1 < k) {
            ptr2 = ptr1+1;
            ptr3 = n-1;
            while (ptr2 < ptr3) {
                currSum = nums[ptr1] + nums[ptr2] + nums[ptr3];
                if (currSum == 0) {
                    threeSumLists.add(List.of(nums[ptr1], nums[ptr2], nums[ptr3]));
                    do {
                        ptr3--;
                    } while (ptr3 > ptr1 && nums[ptr3+1] == nums[ptr3]);
                    do {
                        ptr2++;
                    } while (ptr2 < n && nums[ptr2-1] == nums[ptr2]);
                } else if (currSum > 0) {
                    do {
                        ptr3--;
                    } while (ptr3 > ptr1 && nums[ptr3+1] == nums[ptr3]);
                } else {
                    do {
                        ptr2++;
                    } while (ptr2 < n && nums[ptr2-1] == nums[ptr2]);
                }
            }

            do {
                ptr1++;
            } while (ptr1 < k && nums[ptr1-1] == nums[ptr1]);
        }
        return threeSumLists;
    }
}
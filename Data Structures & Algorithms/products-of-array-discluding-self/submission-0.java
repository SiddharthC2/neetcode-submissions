class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] productArr = new int[nums.length];
        for (int i=0; i<nums.length; i++) {
            productArr[i] = 1;
        }
        for (int i=0; i<nums.length; i++) {
            for (int j=0; j<nums.length; j++) {
                if (i==j)
                    continue;
                productArr[j] *= nums[i];
            }
        }
        return productArr;
    }
}  

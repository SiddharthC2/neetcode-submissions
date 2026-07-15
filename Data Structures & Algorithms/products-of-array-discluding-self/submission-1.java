class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] productArr = new int[nums.length];
        int product = 1, restProduct;
        for (int i=0; i<nums.length; i++) {
            product *= nums[i];
        }
        for (int i=0; i<nums.length; i++) {
            if (nums[i] != 0) {
                productArr[i] = product/nums[i];
            } else {
                restProduct = 1;
                for (int j=0; j<nums.length; j++) {
                    if (i==j)
                        continue;
                    restProduct *= nums[j];
                }
                productArr[i] = restProduct;
            }
        }
        return productArr;
    }
}  

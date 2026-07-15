class Solution {
    public int[] productExceptSelf(int[] nums) {
        if (nums == null || nums.length <= 1) return nums; 
        int[] productArr = new int[nums.length];
        int[] prefixProduct = new int[nums.length];
        int[] suffixProduct = new int[nums.length];

        prefixProduct[0] = nums[0];
        for (int i=1; i<nums.length; i++) {
            prefixProduct[i] = nums[i] * prefixProduct[i-1];
        }

        suffixProduct[nums.length-1] = nums[nums.length-1];
        for (int i=nums.length-2; i>=0; i--) {
            suffixProduct[i] = nums[i] * suffixProduct[i+1];
        }

        productArr[0] = suffixProduct[1];
        productArr[nums.length-1] = prefixProduct[nums.length-2];
        for (int i=1; i<nums.length-1; i++) {
            productArr[i] = prefixProduct[i-1]*suffixProduct[i+1];
        }
        return productArr;
    }
}  

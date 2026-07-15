class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int[] pair = new int[2];
        int left = 0, right = numbers.length-1;
        int currSum;
        while (left < right) {
            currSum = numbers[left]+numbers[right];
            if (currSum == target) {
                pair[0] = left+1;
                pair[1] = right+1;
                return pair;
            } else if (currSum > target) {
                right--;
            } else {
                left++;
            }
        }
        return null;
    }
}

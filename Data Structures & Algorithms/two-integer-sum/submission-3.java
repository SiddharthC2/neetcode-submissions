class Solution {
	public int[] twoSum(int[] nums, int target) {
		int[][] numsWithIdx = new int[nums.length][2];
		for (int i=0; i<nums.length; i++) {
			numsWithIdx[i][0] = nums[i];
			numsWithIdx[i][1] = i;
		}
		Arrays.sort(numsWithIdx, Comparator.comparingInt(num -> num[0]));
		int leftIdx = 0, rightIdx = nums.length-1, currSum;
		while (leftIdx < rightIdx) {
			currSum = numsWithIdx[leftIdx][0] + numsWithIdx[rightIdx][0];
			if (currSum == target) {
				int[] answer = new int[] {numsWithIdx[leftIdx][1], numsWithIdx[rightIdx][1]};
				Arrays.sort(answer);
				return answer;
			} else if (currSum > target) {
				rightIdx--;
			} else {
				leftIdx++;
			}
		}
		return null;
	}
}
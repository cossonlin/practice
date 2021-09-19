package algorithm;

public class MinimumSizeSubarraySum {
	public static void main(String[] args) {
		int[] nums = new int[]{1, 2, 3, 4, 5};
		int s = 15;
		System.out.println(test(nums, s));
	}

	static int test(int[] nums, int target) {
		int result = 0;
		int tempResult = 0;
		int startIndex = 0;
		int sum = 0;
		for (int i = 0; i < nums.length; i++) {
			sum += nums[i];
			if (sum >= target) {
				while (sum - nums[startIndex] >= target) {
					sum = sum - nums[startIndex];
					startIndex++;
				}
				tempResult = i - startIndex + 1;
			}
			if (result == 0 && tempResult > 0
					|| result > tempResult) {
				result = tempResult;
			}
		}
		return result;
	}
}

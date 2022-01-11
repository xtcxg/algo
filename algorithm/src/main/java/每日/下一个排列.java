package 每日;

import java.util.Arrays;

/**
 * @author liutz
 * @date 2022/1/7
 */
public class 下一个排列 {
	public static void main(String[] args) {
		nextPermutation2(new int[]{2,3,1});
	}

	public static void nextPermutation(int[] nums) {
		int a;
		for (int i = nums.length - 2; i >= 0; i--) {
			if (nums[i] < nums[nums.length - 1]) {
				for (int j = i + 1; j < nums.length; j++) {
					if (nums[i] < nums[j]) {
						a = nums[i];
						nums[i] = nums[j];
						nums[j] = a;
						return;
					}
				}
			} else {
				for (int j = i; j < nums.length - 1; j++) {
					a = nums[j];
					nums[j] = nums[j+1];
					nums[j + 1] = a;
				}
			}
		}
	}
	public static void nextPermutation2(int[] nums) {
		for (int i = nums.length - 1; i > 0; i--) {
			if (nums[i-1] < nums[i]) {
				for (int j = i - 1; j < nums.length; j++) {
					if (nums[j + 1] < nums[i-1] || j + 1  == nums.length) {
						int a = nums[i-1];
						nums[i-1] = nums[j + 1];
						nums[j + 1] = a;
						for (int k = 0; k < (nums.length - i ) / 2; k++) {
							a = nums[i + k];
							nums[i+k] = nums[nums.length-1-k];
							nums[nums.length-1-k] = a;
						}
						System.out.println(Arrays.toString(nums));
						return;
					}
				}
			}
		}
		Arrays.sort(nums);
		System.out.println(Arrays.toString(nums));
	}

}

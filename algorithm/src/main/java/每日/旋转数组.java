package 每日;

/**
 * @author liutz
 * @date 2022/1/11
 */
public class 旋转数组 {
	public static void main(String[] args) {
		int[] arr = {4,5,6,7,0,1,2};
		System.out.println(search(arr,0));
	}

	public static int search(int[] nums, int target) {
		if (target >= nums[0]) {
			for (int i = 0; i < nums.length; i++) {
				if (nums[i] > target) return -1;
				if (nums[i] == target) return i;
			}
			return -1;
		} else if (target <= nums[nums.length-1]) {
			for (int i = nums.length-1;i>=0;i--) {
				if (nums[i] < target) return -1;
				if (nums[i] == target) return i;
			}
			return -1;
		} else {
			return -1;
		}
	}
}

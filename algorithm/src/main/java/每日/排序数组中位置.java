package 每日;

import org.junit.Test;

import java.util.Arrays;

/**
 * @author liutz
 * @date 2022/1/20
 */
public class 排序数组中位置 {

	@Test
	public void t1() {
//		int[] nums = new int[]{1,2,3,5,6,7,8,8,8,8,13,15,16,17,24,26,27,28,34,35,37,39,41,43,44};
		int[] nums = {1};
		int target = 1;
		int[] r = searchRange(nums,target);
		System.out.println(Arrays.toString(searchRange0(nums,target)));
		System.out.println(Arrays.toString(r));
	}


	public int[] searchRange0(int[] nums, int target) {
		int[] res = new int[]{-1,-1};
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] == target) {
				if (res[0] == -1) {
					res[0] =  i;
				}
				res[1] =  i;
			}
		}
		return res;
	}

	public int[] searchRange(int[] nums, int target) {
		int begin = 0;
		int end = nums.length - 1;
		if (end < 0 || target < nums[0] || target > nums[end]) {
			return new int[]{-1,-1};
		}
		int mid;
		for (;;) {
			mid = (begin + end) / 2;
			if (end - begin <= 4 || nums[mid] == target) {
				int[] res = new int[]{-1,-1};
				for (int i = begin; i <= end; i++) {
					if (nums[i] == target) {
						if (res[0] == -1) {
							res[0] = i ;
						}
						res[1] = i;
					}
				}
				return res;
			} else {
				if (nums[mid] < target) {
					begin = mid;
				} else {
					end = mid;
				}
			}
		}
	}
}

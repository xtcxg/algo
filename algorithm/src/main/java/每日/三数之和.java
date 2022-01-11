package 每日;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Hashtable;
import java.util.List;

/**
 * @author liutz
 * @date 2022/1/4
 */
public class 三数之和 {
	public static void main(String[] args) {
		int[] nums = {0,0,0,0,0,0,0,0};
		System.out.println(threeSum2(nums));

	}

	// 使用hash表
	public static List<List<Integer>> threeSum(int[] nums) {
		Hashtable<Integer,Integer> table = new Hashtable<>();
		Hashtable<String,List<Integer>> res = new Hashtable<>();
		String k;
		int o;
		for (int i = 0; i < nums.length; i++) {
			table.clear();

			for (int j = 0; j < nums.length; j++) {
				if (i!=j) {
					o = -nums[i] - nums[j];
					if (table.containsKey(o)) {
						k = Math.min(Math.min(nums[i],nums[j]),o) + ",";
						k = k + Math.max(Math.max(nums[i],nums[j]),o);
						if (!res.containsKey(k)) {
							res.put(k,Arrays.asList(nums[i],nums[j],o));
						}
					}
					table.put(nums[j],j);
				}
			}
		}
		return new ArrayList<>(res.values());
	}

	// 使用双指针
	private static List<List<Integer>> threeSum2(int[] nums) {
		int a;
		for (int i = 0; i < nums.length; i++) {
			for (int j = nums.length - 1; j > i; j--) {
				if (nums[j] < nums[j - 1]) {
					a = nums[j];
					nums[j] = nums[j-1];
					nums[j-1] = a;
				}
			}
		}

		Hashtable<String,List<Integer>> table = new Hashtable<>();
		for (int i = 1; i < nums.length - 1; i++) {
			for (int q = 1; i-q >= 0; q++) {
				for (int p = 1; i + p < nums.length; p++) {
					if (nums[i] + nums[i-q] + nums[i+p] == 0) {
						table.put(nums[i] +","+ nums[i-q]+","+nums[i+p],Arrays.asList(nums[i],nums[i-q],nums[i+p]));
						break;
					}
					if (nums[i] + nums[i-q] + nums[i+p] > 0) break;
				}
			}
		}

		return new ArrayList<>(table.values());
	}
}

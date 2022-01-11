package 每日;

import java.util.Arrays;
import java.util.Hashtable;

/**
 * @author liutz
 * @date 2022/1/4
 */
public class 两数之和 {

	public static void main(String[] args) {
		int[] array = {1,2,2,3,4,5};
		int target = 4;
		System.out.println(Arrays.toString(twoSum(array, target)));
	}

	public static int[] twoSum(int[] nums,int target) {
		Hashtable<Integer,Integer> table = new Hashtable<>();
		for (int i = 0; i < nums.length; i++) {
			if(table.containsKey(target - nums[i])) {
				return new int[]{i,table.get(target - nums[i])};
			}
			table.put(nums[i],i);
		}
		return new int[0];
	}
}

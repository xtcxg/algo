package 每日;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author liutz
 * @date 2022/1/20
 */
public class 全排列 {

	@Test
	public void t1() {
		int[] nums = {1,2,3};
		List<List<Integer>> permute = permute(nums);
		System.out.println(permute);
	}

	public List<List<Integer>> permute(int[] nums) {
		List<Integer> left = new ArrayList<>();
		for (int num : nums) {
			left.add(num);
		}
		return join(new ArrayList<>(), left);
	}

	public List<List<Integer>> join(List<Integer> per,List<Integer> left) {
		if (left.size() == 0) {
			return new ArrayList<List<Integer>>(){{
				add(per);
			}};
		}
		List<List<Integer>> r = new ArrayList<>();
		for (int i = 0; i < left.size(); i++) {
			List<Integer> newList = new ArrayList<>(left);
			List<Integer> newPer = new ArrayList<>(per);
			newPer.add(newList.get(i));
			newList.remove(i);
			r.addAll(join(newPer,newList));
		}
		return r;
	}

}

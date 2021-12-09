package util;

import java.util.HashSet;

/**
 * @author liutz
 * @date 2021/12/8
 */
public class ArrayUtil {

	public static int[] createArray(int len) {
		return createArray(len,true);
	}

	public static int[] createArray(int len,Boolean repeat) {
		int[] array = new int[len];
		if (repeat) {
			for (int i = 0; i < len; i++) {
				array[i] = (int) (Math.random() * 9999999);
			}
		} else {
			HashSet<Integer> set = new HashSet<>();
			int i = 0;
			while (i<len) {
				set.add((int) (Math.random() * 99999));
				if (set.size() == i) continue;
				i++;
			}
			array = set.stream().mapToInt(Integer::valueOf).toArray();
		}
		return array;
	}
}

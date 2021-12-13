package 贪心;

import java.util.Arrays;

/**
 * @author liutz
 * @date 2021/12/13
 */
public class 背包装的最多_每种物品数量无限 {
	public static void main(String[] args) {
		int max = max(10,new int[]{2,4});
		System.out.println(max);
	}

	/**
	 *
	 * @param capacity 背包容量
	 * @param weights 物品重量列表(物品数量无限)
	 * @return
	 */
	private static int max(int capacity,int[] weights) {
		int num = weights.length;
		int[][] record = new int[capacity+1][num+1];

		for (int i = 1; i <= capacity; i++) {
			for (int j = 1; j <= num; j++) {
				if (weights[j-1] <= i) {
					record[i][j] = Math.max(record[i][j-1],
							record[i-weights[j-1]][j] + weights[j-1]);
				} else {
					record[i][j] = record[i][j-1];
				}
			}
		}
		return record[capacity][num];
	}
}

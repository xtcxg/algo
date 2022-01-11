package 贪心;

import java.util.Arrays;

/**
 * 这里有 n 门不同的在线课程，按从 1 到 n 编号。
 * 给你一个数组 courses ，
 * 其中 courses[i] = [durationi, lastDayi] 表示第 i 门课将会 持续 上 durationi 天课，
 * 并且必须在不晚于 lastDayi 的时候完成。
 */
public class 最多课程 {
	public static void main(String[] args) {
		int[][] courses = {{860,4825},{13,1389},{746,8823},{455,2778},{233,2069},{106,5648},{802,2969},{958,2636},{567,2439},{623,1360},{700,4206},{9,3725},{241,7381}};
		System.out.println(chose(courses));
	}

	public static int chose(int[][] courses) {
		int num = courses.length;
		int end = 0;

		for (int i = 1; i < num; i++) {
			for (int j = 1; j < num; j++) {
				if (courses[j][1] < courses[j-1][1]) {
					int[] x = courses[j-1];
					courses[j-1]= courses[j];
					courses[j] = x;
				}
			}
		}
		for (int[] course : courses) {
			end = Math.max(end,course[1]);
		}
		int[][][] c = new int[num + 1][end+1][2];// [课程数][天数]

		for (int i = 1; i <= num; i++) {
			for (int j = 1; j <= end; j++) {
				if (courses[i-1][0] <= j // 时间可以完成当前课程
						&& courses[i-1][0] + c[i-1][j-courses[i-1][0]][0]  <= courses[i-1][1]
						&& c[i-1][j-courses[i-1][0]][1] + 1 > c[i-1][j][1]) {
					c[i][j][0] = c[i-1][j-courses[i-1][0]][0] + courses[i-1][0];
					c[i][j][1] = c[i-1][j-courses[i-1][0]][1] + 1;
				} else {
					c[i][j] = c[i-1][j];
				}
			}
		}
		return c[num][end][1];
	}
}

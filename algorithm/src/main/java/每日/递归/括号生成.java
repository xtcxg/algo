package 每日.递归;

import java.util.ArrayList;
import java.util.List;

/**
 * @author liutz
 * @date 2022/1/6
 */
public class 括号生成 {
	public static void main(String[] args) {
		System.out.println(generateParenthesis(4));
	}

	public static List<String> generateParenthesis(int n) {
		List<String> list = new ArrayList<>();
		rec(n ,n,"", list);
		return list;
	}

	public static void rec(int left, int right,String str,List<String> list) {
		if (right == 0) {
			list.add(str);
			return;
		}
		if (left > 0) {
			rec(left - 1,right,str + "(",list);
		}
		if (right > 0 && right > left) {
			rec(left,right - 1,str + ")",list);
		}
	}
}

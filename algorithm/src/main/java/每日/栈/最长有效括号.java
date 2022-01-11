package 每日.栈;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * @author liutz
 * @date 2022/1/7
 */
public class 最长有效括号 {

	public static void main(String[] args) {
		int v = longestValidParentheses2(")(())))(())())");
		System.out.println(v);
	}

	public static int longestValidParentheses(String s) {
		List<Integer> list = new ArrayList<>();
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) == '(') {
				list.add(0);
			} else {
				for (int j = list.size()-1; j >= 0; j--) {
					if (list.get(j) == 0) {
						list.set(j,1);
						break;
					}
					if (list.get(j) == -1 || j == 0) {
						list.add(-1);
						break;
					}
				}
			}
		}
		int m = 0;
		int p = 0;
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i) == 1) {
				p++;
			} else {
				m = Math.max(m,p);
				p = 0;
			}
		}
		m = Math.max(m,p);
		return m*2;
	}

	public static int longestValidParentheses2(String s) {
		Deque<Integer> deque = new LinkedList<>();
		deque.push(-1);
		int max = 0;
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) == '(') {
				deque.push(i);
			} else {
				deque.pop();
				if (deque.isEmpty()) {
					deque.push(i);
				} else {
					max = Math.max(max,i - deque.peek());
				}
			}
		}
		return max;
	}
}

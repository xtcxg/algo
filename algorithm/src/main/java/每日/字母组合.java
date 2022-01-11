package 每日;

import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author liutz
 * @date 2022/1/6
 */
public class 字母组合 {

	static Map<Character,List<String>> map = new HashMap<Character,List<String>>() {{
		put('2', Arrays.asList("a","b","c"));
		put('3', Arrays.asList("d","e","f"));
		put('4', Arrays.asList("g","h","i"));
		put('5', Arrays.asList("j","k","l"));
		put('6', Arrays.asList("m","n","o"));
		put('7', Arrays.asList("p","q","r","s"));
		put('8', Arrays.asList("t","u","v"));
		put('9', Arrays.asList("w","x","y","z"));
	}};

	public static void main(String[] args) {
		String digits = "23";
		System.out.println(letterCombinations(digits));
	}

	public static List<String> letterCombinations(String digits) {
		List<List<String>> list = new ArrayList<>();
		for (int i = 0; i < digits.length(); i++) {
			list.add(map.get(digits.charAt(i)));
		}
		if (list.size() == 0) return Collections.emptyList();
		List<String> cache = new ArrayList<>();
		List<String> res = new ArrayList<>(list.get(0));
		for (int i = 1; i < list.size(); i++) {
			cache.clear();
			cache.addAll(res);
			res.clear();
			for (int j = 0; j < list.get(i).size(); j++) {
				for (int k = 0; k < cache.size(); k++) {
					res.add(cache.get(k) + list.get(i).get(j));
				}
			}
		}
		return res;
	}

	public static String add() {
		return "";
	}
}

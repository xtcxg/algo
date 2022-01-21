package 每日;

/**
 * @author liutz
 * @date 2022/1/11
 */
public class 最多雨水 {
	public static void main(String[] args) {
		int[] height = {0,1,0,2,1,0,1,3,2,1,2,1};
		System.out.println(trap2(height));
	}
	public static int trap(int[] height) {
		int p = -1,q = 0,s = 0,h=0;
		for (int i = 0; i < height.length; i++) {
			if (height[i] >= h) {
				h = height[i];
				q = h;
			}
		}
		h = 0;
		for (;;) {
			for (int i = 0; i < height.length; i++) {
				if (height[i] >= h) {
					if (p != -1) {
						s = s + i - p - 1;
					}
					p = i;
				}
			}
			if (q <= h) {
				break;
			}
			h++;
			p=-1;
		}
		return s;
	}

	public static int trap2(int[] height) {
		int left = 0,right,second,size = 0;
		for (int i = 0; i < height.length; i++) {
			if (height[left] <= height[i]) {
				left = i;
			} else {
				if (i > height.length-3) return size;
				right = i++;
				for (int j = i+2; j < height.length; j++) {
					if (height[j]>=height[right]){
						right = j;
					}
					if (height[j] > height[i]) {
						break;
					}
				}
				second = Math.min(height[left],height[right]);
				for (int j = left; j < right; j++) {
					size = size + second - height[j];
				}
				i = right;
				left = i;
			}
		}
		return size;
	}

}

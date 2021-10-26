package 选择排序;

import java.util.Arrays;

public class Application {
    public static void main(String[] args) {
        int[] arr = new int[]{8,2,3,5,12,7,3,21};
        System.out.println(Arrays.toString(sort(arr)));
    }

    /**
     * 找到数组中第 i 小的元素，与数组中第 i 个位置交换
     * O(n^2/2)
     * 即使数组有序，时间也不变
     * @param arr 待排序数据
     * @return  有序数组
     */
    public static int[] sort(int[] arr) {
        int len = arr.length;
        for (int i = 0; i < len; i++) {
            int min;
            for (int j = i+1; j < len; j++) {
                if (arr[j]<arr[i]) {
                    min = arr[j];
                    arr[j] = arr[i];
                    arr[i] = min;
                }
            }
        }
        return arr;
    }
}

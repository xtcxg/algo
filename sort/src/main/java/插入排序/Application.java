package 插入排序;

import java.util.Arrays;

public class Application {
    public static void main(String[] args) {
        int[] arr = new int[]{8,2,3,5,12,7,3,21};
        System.out.println(Arrays.toString(sort(arr)));
    }

    /**
     * 索引左边的元素都是有序的，将索引所在位置的元素与左边元素比较，插入合适的位置
     * O(n^2/2)
     * 最好的情况，无需移动元素，最坏的情况所有元素都需要移动
     * @param arr 待排序数据
     * @return  有序数组
     */
    public static int[] sort(int[] arr) {
        for (int i = 0; i < arr.length-1; i++) {
            int min;
            for (int j = i+1; j > 0; j--) {
                if (arr[j] < arr[j-1]) {
                    min = arr[j];
                    arr[j] = arr[j-1];
                    arr[j-1] = min;
                } else {
                    break;
                }
            }
        }
        return arr;
    }
}

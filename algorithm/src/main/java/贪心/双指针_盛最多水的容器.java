package 贪心;

/**
 * 给你 n 个非负整数 a1，a2，...，an，每个数代表坐标中的一个点(i,ai) 。
 * 在坐标内画 n 条垂直线，垂直线 i的两个端点分别为(i,ai) 和 (i, 0) 。
 * 找出其中的两条线，使得它们与x轴共同构成的容器可以容纳最多的水。
 *
 */
public class 双指针_盛最多水的容器 {

    public static void main(String[] args) {
        int[] array = {1,8,6,2,5,4,8,3,7};
        System.out.println(reduce(array));
    }


    public static int reduce(int[] array) {
        int front = 0;
        int back = array.length - 1;
        int area = 0;
        while (front < back) {
            area = Math.max(area,array[front] < array[back] ? array[front] * (back - front++) : array[back] * (back-- - front));
//            if (array[front] < array[back]) {
//                area = Math.max(area,array[front] * (back - front));
//                front++;
//            } else {
//                area = Math.max(area,array[back] * (back - front));
//                back--;
//            }
        }
        return area;
    }
}

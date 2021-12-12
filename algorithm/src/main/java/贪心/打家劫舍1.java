package 贪心;

/**
 * 你是一个专业的小偷，计划偷窃沿街的房屋。每间房内都藏有一定的现金，
 * 影响你偷窃的唯一制约因素就是相邻的房屋装有相互连通的防盗系统，如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警。
 *
 * 给定一个代表每个房屋存放金额的非负整数数组，计算你 不触动警报装置的情况下 ，一夜之内能够偷窃到的最高金额。
 *
 *
 */
public class 打家劫舍1 {
    public static void main(String[] args) {
        System.out.println(rob(new int[]{2,1,1,2}));
    }

    public static int rob(int[] nums) {
        if (nums.length == 0)
            return 0;
        if (nums.length == 1)
            return nums[0];
        int next = 0;  // 上一次最大的值，如果同一个值最大两次也会变成next
        int first = 0; // 当前最大的值
        int max = 0;
        for (int chose : nums) {
            // 如果 next + chose > first
            // 当前最大的值 first 为 next + chose
            // first 则变成上一次最大的值
            if (chose + next > first) {
                max = chose + next;
                next = first;
                first = max;
            } else {
                // 如果 next + chose !> first
                // first 两次成为最大值
                // next = first
                next = first;
            }
        }
        return max;
    }
}

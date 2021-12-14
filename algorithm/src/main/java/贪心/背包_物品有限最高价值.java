package 贪心;

public class 背包_物品有限最高价值 {
    public static void main(String[] args) {
        reduce();
    }

    public static int reduce() {
        int[] value = {60,100,120};
        int[] weight = {10,20,30};

        int w = 50; // 背包容量
        int n = 3; // 物品数

        int[][] dp = new int[n+1][w+1];

        for (int i = 1; i <= n; i++) {
            for (int cw = 1; cw <= w; cw++) {
                if (weight[i-1]<=cw) {
                    dp[i][cw] = Math.max(
                            value[i-1] + dp[i-1][cw-weight[i-1]],
                            dp[i-1][cw]
                    );
                } else {
                    dp[i][cw] = dp[i-1][cw];
                }
            }
        }
        System.out.println(dp[n][w]);
        return dp[n][w];
    }
}

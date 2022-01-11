package 贪心;

public class 背包_物品有限最高价值 {
    public static void main(String[] args) {
//        reduce();
        int[][] goods = {{70,80},{50,70},{40,60},{50,90}};
        reduce(100,goods);
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

    /**
     *
     * @param size 背包大小
     * @param goods 物品[重量，价格]列表
     * -                 -
     * | [weight1,price1] |
     * | [weight2,price2] |
     * | ....             |
     * _                 _
     * @return
     */
    public static int reduce(int size,int[][] goods) {

        int n = goods.length; // 物品数量
        int[][] dp = new int[size+1][n+1];

        for (int i = 1; i <= size ; i++) {
            for (int j = 1; j <= n; j++) {
                if (goods[j-1][0] <= i) {
                    dp[i][j] = Math.max(
                            goods[j-1][1] + dp[i - goods[j-1][0]][j-1],
                            dp[i][j-1]
                    );
                } else {
                    dp[i][j] = dp[i][j-1];
                }
            }
        }
        System.out.println(dp[size][n]);
        return dp[size][n];
    }
}

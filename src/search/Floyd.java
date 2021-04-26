package search;

/**
 * Floyd
 *
 * @author CodeX
 * @version 1.0
 * @date 2021/4/27 12:18
 */
public class Floyd {

    public static void main(String[] args) {
        int max = Integer.MAX_VALUE;
        int[][] weights = new int[][]{
                {max, max, 10, max, 30, 100},
                {max, max, 5, max, max, max},
                {max, max, max, 50, max, max},
                {max, max, max, max, max, 10},
                {max, max, max, 20, max, 60},
                {max, max, max, max, max, max}};

        int[][] dp = floyd(weights);
        for (int i = 0; i < dp.length; i++) {
            StringBuffer sb = new StringBuffer();
            for (int j = 0; j < dp.length; j++) {
                sb.append(dp[i][j] + " ");
            }
            System.out.println(sb.toString().trim());
        }
    }

    private static int[][] floyd(int[][] weights) {
        int[][] dp = weights;
        int len = dp.length;
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len; j++) {
                for (int k = 0; k < len; k++) {
                    if (dp[j][i] != Integer.MAX_VALUE && dp[i][k] != Integer.MAX_VALUE && dp[j][k] > dp[j][i] + dp[i][k]) {
                        dp[j][k] = dp[j][i] + dp[i][k];
                    }
                }
            }
        }

        return dp;

    }
}

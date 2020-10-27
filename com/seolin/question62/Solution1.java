package com.seolin.question62;

/**
 * @author liangzi on 2020/10/27
 */
public class Solution1 {
    public int uniquePaths(int m, int n) {
        //状态转移方程 dp(i,j) = dp(i-1 , j) + dp(i , j-1)
        //边界条件 i = 0 j = 0;
        int[][] dp = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (i == 0) {
                    dp[i][j] = 1;
                } else if (j == 0) {
                    dp[i][j] = dp[i - 1][j];
                } else {
                    dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
                }
            }
        }
        return dp[n - 1][m - 1];
    }

    public static void main(String[] args) {
        System.out.println(new Solution1().uniquePaths(7, 3));
    }
}

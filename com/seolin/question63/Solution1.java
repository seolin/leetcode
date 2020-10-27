package com.seolin.question63;

/**
 * @author liangzi on 2020/10/27
 */
public class Solution1 {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int n = obstacleGrid.length;
        int m = obstacleGrid[0].length;
        if (obstacleGrid[0][0] == 1) {
            return 0;
        } else {
            obstacleGrid[0][0] = 1;
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (i == 0 && j == 0) {
                    continue;
                }
                if (obstacleGrid[i][j] == 1) {
                    obstacleGrid[i][j] = -1;
                    continue;
                }
                if (i == 0) {
                    obstacleGrid[i][j] = obstacleGrid[i][j - 1];
                } else if (j == 0) {
                    obstacleGrid[i][j] = obstacleGrid[i - 1][j];
                } else {
                    if (obstacleGrid[i - 1][j] == -1 && obstacleGrid[i][j - 1] == -1) {
                        obstacleGrid[i][j] = -1;
                    } else if (obstacleGrid[i - 1][j] == -1) {
                        obstacleGrid[i][j] = obstacleGrid[i][j - 1];
                    } else if (obstacleGrid[i][j - 1] == -1) {
                        obstacleGrid[i][j] = obstacleGrid[i - 1][j];
                    } else {
                        obstacleGrid[i][j] = obstacleGrid[i][j - 1] + obstacleGrid[i - 1][j];
                    }

                }
            }
        }
        if (obstacleGrid[n - 1][m - 1] == -1) {
            return 0;
        }
        return obstacleGrid[n - 1][m - 1];
    }

    public static void main(String[] args) {
        int[][] obstacleGrid = {{0, 0, 0}, {0, 1, 0}, {0, 0, 0}};

        System.out.println(new Solution1().uniquePathsWithObstacles(obstacleGrid));
    }
}

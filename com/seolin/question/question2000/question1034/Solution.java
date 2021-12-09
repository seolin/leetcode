package com.seolin.question.question2000.question1034;

/**
 * //给你一个大小为 m x n 的整数矩阵 grid ，表示一个网格。另给你三个整数 row、col 和 color 。网格中的每个值表示该位置处的网格块的颜色
 * //。
 * //
 * // 当两个网格块的颜色相同，而且在四个方向中任意一个方向上相邻时，它们属于同一 连通分量 。
 * //
 * // 连通分量的边界 是指连通分量中的所有与不在分量中的网格块相邻（四个方向上）的所有网格块，或者在网格的边界上（第一行/列或最后一行/列）的所有网格块。
 * //
 * // 请你使用指定颜色 color 为所有包含网格块 grid[row][col] 的 连通分量的边界 进行着色，并返回最终的网格 grid 。
 * //
 * //
 * //
 * // 示例 1：
 * //
 * //
 * //输入：grid = [[1,1],[1,2]], row = 0, col = 0, color = 3
 * //输出：[[3,3],[3,2]]
 * //
 * // 示例 2：
 * //
 * //
 * //输入：grid = [[1,2,2],[2,3,2]], row = 0, col = 1, color = 3
 * //输出：[[1,3,3],[2,3,3]]
 * //
 * // 示例 3：
 * //
 * //
 * //输入：grid = [[1,1,1],[1,1,1],[1,1,1]], row = 1, col = 1, color = 2
 * //输出：[[2,2,2],[2,1,2],[2,2,2]]
 * //
 * //
 * //
 * // 提示：
 * //
 * //
 * // m == grid.length
 * // n == grid[i].length
 * // 1 <= m, n <= 50
 * // 1 <= grid[i][j], color <= 1000
 * // 0 <= row < m
 * // 0 <= col < n
 * //
 * //
 * //
 * // Related Topics 深度优先搜索 广度优先搜索 数组 矩阵
 *
 * @author chenkangkang
 * @date 2021/12/7 9:37 AM
 * @description
 **/
public class Solution {
    /**
     * 记录访问过的区域
     */
    boolean[][] flag;
    int color;
    int mark;
    int n;
    int m;

    public int[][] colorBorder(int[][] grid, int row, int col, int color) {
        //暴搜
        this.n = grid.length;
        this.m = grid[0].length;
        this.flag = new boolean[n][m];
        this.color = color;
        this.mark = grid[row][col];
        dfs(row, col, grid);
        return grid;
    }

    private void dfs(int row, int col, int[][] grid) {
        if (row >= n || col >= m || row < 0 || col < 0) {
            return;
        }
        if (flag[row][col]) {
            return;
        }
        flag[row][col] = true;
        if (grid[row][col] == mark) {
            grid[row][col] = color;
        } else {
            return;
        }
        dfs(row + 1, col, grid);
        dfs(row - 1, col, grid);
        dfs(row, col + 1, grid);
        dfs(row, col - 1, grid);
    }
}

package com.seolin.beat.T54;
//给你一个 m 行 n 列的矩阵 matrix ，请按照 顺时针螺旋顺序 ，返回矩阵中的所有元素。
//
//
//
// 示例 1：
//
//
//输入：matrix = [[1,2,3],[4,5,6],[7,8,9]]
//输出：[1,2,3,6,9,8,7,4,5]
//
//
// 示例 2：
//
//
//输入：matrix = [[1,2,3,4],[5,6,7,8],[9,10,11,12]]
//输出：[1,2,3,4,8,12,11,10,9,5,6,7]
//
//
//
//
// 提示：
//
//
// m == matrix.length
// n == matrix[i].length
// 1 <= m, n <= 10
// -100 <= matrix[i][j] <= 100
//
// Related Topics 数组 矩阵 模拟 👍 1087 👎 0

import java.util.ArrayList;
import java.util.List;

/**
 * @author chenkangkang
 * @date 2022/5/10 11:16 AM
 **/
public class T54 {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> ansList = new ArrayList<>();
        int t = 0;
        int e = matrix.length - 1;

        int l = 0;
        int r = matrix[0].length - 1;

        while (true) {
            //从左到右
            //从上到下
            //从右到左
            //从下到上
            for (int i = l; i <= r; i++) {
                ansList.add(matrix[i][t]);
            }
            if (++t > e) {
                break;
            }
            for (int i = t; i <= e; i++) {
                ansList.add(matrix[r][i]);
            }
            if (--r < l) {
                break;
            }
            for (int i = r; i >= l; i--) {
                ansList.add(matrix[i][e]);
            }
            if (--e < t) {
                break;
            }
            for (int i = e; i >=t; i--) {
                ansList.add(matrix[l][i]);
            }
            if (++l > r) {
                break;
            }
         }
        return ansList;
    }
}

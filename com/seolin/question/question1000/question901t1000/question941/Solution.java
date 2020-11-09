package com.seolin.question.question1000.question901t1000.question941;
//给定一个整数数组 A，如果它是有效的山脉数组就返回 true，否则返回 false。
//
// 让我们回顾一下，如果 A 满足下述条件，那么它是一个山脉数组：
//
//
// A.length >= 3
// 在 0 < i < A.length - 1 条件下，存在 i 使得：
//
// A[0] < A[1] < ... A[i-1] < A[i]
// A[i] > A[i+1] > ... > A[A.length - 1]
//
//
//
//
//
//
//
//
//
//
// 示例 1：
//
// 输入：[2,1]
//输出：false
//
//
// 示例 2：
//
// 输入：[3,5,5]
//输出：false
//
//
// 示例 3：
//
// 输入：[0,3,2,1]
//输出：true
//
//
//
// 提示：
//
//
// 0 <= A.length <= 10000
// 0 <= A[i] <= 10000
//
//
//
//
//
// Related Topics 数组

/**
 * 941. 有效的山脉数组
 * 注意边界条件
 *
 * @author liangzi on 2020/11/3
 */
public class Solution {
    public boolean validMountainArray(int[] A) {
        if (A == null || A.length == 0) {
            return false;
        }
        int top = A[0];
        boolean up = true;
        for (int i = 1; i < A.length; i++) {
            if (up && A[i] > top) {
                top = A[i];
                if ((i + 1) < A.length && A[i] > A[i + 1]) {
                    up = false;
                }
            } else if (!up && A[i] < top) {
                top = A[i];
            } else {
                return false;
            }
        }
        return !up;
    }

    public static void main(String[] args) {
        int[] A = {3,5,5};
//        int[] A = {0, 3, 2, 1};
        System.out.println(new Solution().validMountainArray(A));
    }
}

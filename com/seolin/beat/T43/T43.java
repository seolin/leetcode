package com.seolin.beat.T43;
//给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。
//
//
//
// 示例 1：
//
//
//
//
//输入：height = [0,1,0,2,1,0,1,3,2,1,2,1]
//输出：6
//解释：上面是由数组 [0,1,0,2,1,0,1,3,2,1,2,1] 表示的高度图，在这种情况下，可以接 6 个单位的雨水（蓝色部分表示雨水）。
//
//
// 示例 2：
//
//
//输入：height = [4,2,0,3,2,5]
//输出：9
//
//
//
//
// 提示：
//
//
// n == height.length
// 1 <= n <= 2 * 10⁴
// 0 <= height[i] <= 10⁵
//
// Related Topics 栈 数组 双指针 动态规划 单调栈 👍 3421 👎 0

/**
 * @author chenkangkang
 * @date 2022/5/7 4:00 PM
 **/
public class T43 {
    public int trap(int[] height) {
        int ans = 0;
        int n = height.length;
        if (n < 3) {
            return 0;
        }
        int[] leftDp = new int[n];
        int[] rightDp = new int[n];
        leftDp[0] = height[0];
        rightDp[n - 1] = height[n - 1];
        for (int i = 1; i < n; i++) {
            leftDp[i] = Math.max(leftDp[i - 1], height[i]);
        }
        for (int i = n - 2; i >= 0; i++) {
            rightDp[i] = Math.max(rightDp[i + 1], height[i]);
        }
        for (int i = 1; i < n - 1; i++) {
            int min = Math.min(leftDp[i - 1], rightDp[i + 1]);
            if (min > height[i]) {
                ans += min - height[i];
            }
        }
        return ans;
    }
}

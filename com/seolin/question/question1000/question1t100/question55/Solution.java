package com.seolin.question.question1000.question1t100.question55;

/**
 * 55. 跳跃游戏
 * //给定一个非负整数数组 nums ，你最初位于数组的 第一个下标 。
 * //
 * // 数组中的每个元素代表你在该位置可以跳跃的最大长度。
 * //
 * // 判断你是否能够到达最后一个下标。
 * //
 * //
 * //
 * // 示例 1：
 * //
 * //
 * //输入：nums = [2,3,1,1,4]
 * //输出：true
 * //解释：可以先跳 1 步，从下标 0 到达下标 1, 然后再从下标 1 跳 3 步到达最后一个下标。
 * //
 * //
 * // 示例 2：
 * //
 * //
 * //输入：nums = [3,2,1,0,4]
 * //输出：false
 * //解释：无论怎样，总会到达下标为 3 的位置。但该下标的最大跳跃长度是 0 ， 所以永远不可能到达最后一个下标。
 * //
 * //
 * //
 * //
 * // 提示：
 * //
 * //
 * // 1 <= nums.length <= 3 * 104
 * // 0 <= nums[i] <= 105
 * //
 * // Related Topics 贪心 数组 动态规划
 * // 👍 1282 👎 0
 * @Description:
 * @Author: kangkangchen
 * @Date: 2021/8/1 22:57
 */
public class Solution {
    public boolean canJump(int[] nums) {
        boolean[] res = new boolean[nums.length];
        res[0] = true;
        for (int i = 1; i < nums.length; i++) {
            for (int j = i - 1; j >= 0; j--) {
                if ((nums[j] - i + j >= 0) && res[j]) {
                    res[i] = true;
                    break;
                }
            }
        }
        return res[nums.length - 1];
    }

    public static void main(String[] args) {
        int[] nums  = {2,3,1,1,4};
        System.out.println(new Solution().canJump(nums));
    }
}

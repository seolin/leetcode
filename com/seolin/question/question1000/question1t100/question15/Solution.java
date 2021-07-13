package com.seolin.question.question1000.question1t100.question15;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * //给你一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？请你找出所有和为 0 且不重
 * //复的三元组。
 * //
 * // 注意：答案中不可以包含重复的三元组。
 * //
 * //
 * //
 * // 示例 1：
 * //
 * //
 * //输入：nums = [-1,0,1,2,-1,-4]
 * //输出：[[-1,-1,2],[-1,0,1]]
 * //
 * //
 * // 示例 2：
 * //
 * //
 * //输入：nums = []
 * //输出：[]
 * //
 * //
 * // 示例 3：
 * //
 * //
 * //输入：nums = [0]
 * //输出：[]
 * //
 * //
 * //
 * //
 * // 提示：
 * //
 * //
 * // 0 <= nums.length <= 3000
 * // -105 <= nums[i] <= 105
 * //
 * // Related Topics 数组 双指针 排序
 * // 👍 3493 👎 0
 *
 * @author liangzi on 2021/7/13
 */
public class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums.length < 3) {
            return result;
        }
        Arrays.sort(nums);
        for (int target = 0; target < nums.length - 2; target++) {
            if (nums[target] > 0) {
                break;
            }
            if (target > 0 && nums[target] == nums[target - 1]) {
                continue;
            }
            int left = target + 1;
            int right = nums.length - 1;
            while (left < right) {
                int sum = nums[target] + nums[left] + nums[right];
                if (sum > 0) {
                    while (left < right && nums[right] == nums[--right]) ;
                } else if (sum < 0) {
                    while (left < right && nums[left] == nums[++left]) ;
                } else {
                    List<Integer> subResult = new ArrayList<>();
                    subResult.add(nums[target]);
                    subResult.add(nums[left]);
                    subResult.add(nums[right]);
                    while (left < right && nums[left] == nums[++left]) ;
                    while (left < right && nums[right] == nums[--right]) ;
                }
            }
        }
        return result;
    }
}

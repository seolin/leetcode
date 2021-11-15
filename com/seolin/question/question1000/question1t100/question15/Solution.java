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
        int n = nums.length;
        List<List<Integer>> ans = new ArrayList<>();
        if (n <= 2) {
            return ans;
        }
        Arrays.sort(nums);
        for (int i = 0; i < n - 2; i++) {
            if (nums[i] > 0) {
                continue;
            }
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int left = i + 1;
            int right = n - 1;
            while (left < right) {
                int temp = nums[left] + nums[right] + nums[i];
                if (temp > 0) {
                    right--;
                    while (left < right && nums[right] == nums[right - 1]) {
                        right--;
                    }
                } else if (temp < 0) {
                    left++;
                    while (left < right && nums[left] == nums[left + 1]) {
                        left++;
                    }
                } else {
                    List<Integer> subAns = new ArrayList<>();
                    subAns.add(nums[i]);
                    subAns.add(nums[left]);
                    subAns.add(nums[right]);
                    ans.add(subAns);
                    left++;
                    right--;
                    while (left < right && nums[left] == nums[left + 1]) {
                        left++;
                    }
                    while (left < right && nums[right] == nums[right - 1]) {
                        right--;
                    }
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] nums = {-2,0,1,1,2};
        System.out.println(new Solution().threeSum(nums));
    }
}

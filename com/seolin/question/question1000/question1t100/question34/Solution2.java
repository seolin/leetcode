package com.seolin.question.question1000.question1t100.question34;
//给定一个按照升序排列的整数数组 nums，和一个目标值 target。找出给定目标值在数组中的开始位置和结束位置。
//
// 如果数组中不存在目标值 target，返回 [-1, -1]。
//
// 进阶：
//
//
// 你可以设计并实现时间复杂度为 O(log n) 的算法解决此问题吗？
//
//
//
//
// 示例 1：
//
//
//输入：nums = [5,7,7,8,8,10], target = 8
//输出：[3,4]
//
// 示例 2：
//
//
//输入：nums = [5,7,7,8,8,10], target = 6
//输出：[-1,-1]
//
// 示例 3：
//
//
//输入：nums = [], target = 0
//输出：[-1,-1]
//
//
//
// 提示：
//
//
// 0 <= nums.length <= 105
// -109 <= nums[i] <= 109
// nums 是一个非递减数组
// -109 <= target <= 109
//
// Related Topics 数组 二分查找
// 👍 719 👎 0

import java.util.Arrays;

/**
 * 34. 在排序数组中查找元素的第一个和最后一个位置
 * 问题1: == 号写成了=号
 * 问题2: i++ 还是 i--
 * 问题3:
 *
 * @author liangzi on 2020/12/1
 */
public class Solution2 {
    public int[] searchRange(int[] nums, int target) {
        //临界情况
        int[] result = new int[2];
        result[0] = -1;
        result[1] = -1;
        if (nums == null) {
            return result;
        }
        if (nums.length == 1 && target == nums[0]) {
            result[0] = 0;
            result[1] = 0;
            return result;
        }
        int length = nums.length;
        int start = 0, end = length - 1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (nums[mid] > target) {
                end = mid - 1;
            } else if (nums[mid] < target) {
                start = mid + 1;
            } else {
                for (int i = mid; i >= 0; i--) {
                    if (nums[i] == target) {
                        result[0] = i;
                    }
                }
                for (int i = mid; i < length; i++) {
                    if (nums[i] == target) {
                        result[1] = i;
                    }
                }
                break;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums = {5, 7, 7, 8, 10};
        int target = 8;
        System.out.println(Arrays.toString(new Solution2().searchRange(nums, target)));
    }
}

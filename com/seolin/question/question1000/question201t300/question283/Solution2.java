package com.seolin.question.question1000.question201t300.question283;
//给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
//
// 示例:
//
// 输入: [0,1,0,3,12]
//输出: [1,3,12,0,0]
//
// 说明:
//
//
// 必须在原数组上操作，不能拷贝额外的数组。
// 尽量减少操作次数。
//
// Related Topics 数组 双指针
// 👍 834 👎 0


/**
 * 283. 移动零
 *
 * @author liangzi on 2020/11/19
 */
public class Solution2 {
    public void moveZeroes(int[] nums) {
        //1. 找到0所在位置；2. 从这个位置往后找，找到第一个非0元素，交换位置
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            if (i == n - 1) {
                continue;
            }
            if (nums[i] == 0) {
                for (int j = i + 1; j < n; j++) {
                    if (nums[j] != 0) {
                        swap(nums, i, j);
                        break;
                    }
                }
            }
        }
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}

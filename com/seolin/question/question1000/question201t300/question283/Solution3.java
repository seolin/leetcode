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
public class Solution3 {
    public void moveZeroes(int[] nums) {
        //还是双指针，但是用for来写
        int n = nums.length;
        int zero = 0;
        for (int i = 0; i < n; i++) {
            if (nums[i] != 0){
                swap(nums, i, zero);
                zero++;
            }
         }
    }

    private void swap(int[] nums, int i, int j) {
        if (i == j) {
            return;
        }
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}

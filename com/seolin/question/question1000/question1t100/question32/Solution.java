package com.seolin.question.question1000.question1t100.question32;
//实现获取下一个排列的函数，算法需要将给定数字序列重新排列成字典序中下一个更大的排列。
//
// 如果不存在下一个更大的排列，则将数字重新排列成最小的排列（即升序排列）。
//
// 必须原地修改，只允许使用额外常数空间。
//
// 以下是一些例子，输入位于左侧列，其相应输出位于右侧列。
//1,2,3 → 1,3,2
//3,2,1 → 1,2,3
//1,1,5 → 1,5,1
// Related Topics 数组
// 👍 762 👎 0

import java.util.Arrays;

/**
 * 31. 下一个排列
 * 1. 注意被交换实体
 * 2. 注意符号是否需要相等
 *
 * @author liangzi on 2020/11/10
 */
public class Solution {
    public void nextPermutation(int[] nums) {
        int n = nums.length;
        boolean isExist = false;
        for (int i = n - 1; i > 0; i--) {
            if (nums[i] > nums[i - 1]) {
                for (int j = n - 1; j >= i - 1; j--) {
                    if (nums[j] > nums[i - 1]) {
                        swap(j, i - 1, nums);
                        isExist = true;
                        break;
                    }
                }
                revert(i, n - 1, nums);
                break;
            }
        }
        if (!isExist) {
            revert(0, n - 1, nums);
        }
    }

    private void swap(int i, int j, int[] nums) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    private void revert(int i, int j, int[] nums) {
        while (i < j) {
            swap(i, j, nums);
            i++;
            j--;
        }
    }

    public static void main(String[] args) {
        int[] nums = {1, 3, 2};
        new Solution().nextPermutation(nums);
        Arrays.stream(nums).forEach(System.out::println);
    }

}

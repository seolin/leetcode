package com.seolin.beat.T31;
//整数数组的一个 排列 就是将其所有成员以序列或线性顺序排列。
//
//
// 例如，arr = [1,2,3] ，以下这些都可以视作 arr 的排列：[1,2,3]、[1,3,2]、[3,1,2]、[2,3,1] 。
//
//
// 整数数组的 下一个排列 是指其整数的下一个字典序更大的排列。更正式地，如果数组的所有排列根据其字典顺序从小到大排列在一个容器中，那么数组的 下一个排列 就
//是在这个有序容器中排在它后面的那个排列。如果不存在下一个更大的排列，那么这个数组必须重排为字典序最小的排列（即，其元素按升序排列）。
//
//
// 例如，arr = [1,2,3] 的下一个排列是 [1,3,2] 。
// 类似地，arr = [2,3,1] 的下一个排列是 [3,1,2] 。
// 而 arr = [3,2,1] 的下一个排列是 [1,2,3] ，因为 [3,2,1] 不存在一个字典序更大的排列。
//
//
// 给你一个整数数组 nums ，找出 nums 的下一个排列。
//
// 必须 原地 修改，只允许使用额外常数空间。
//
//
//
// 示例 1：
//
//
//输入：nums = [1,2,3]
//输出：[1,3,2]
//
//
// 示例 2：
//
//
//输入：nums = [3,2,1]
//输出：[1,2,3]
//
//
// 示例 3：
//
//
//输入：nums = [1,1,5]
//输出：[1,5,1]
//
//
//
//
// 提示：
//
//
// 1 <= nums.length <= 100
// 0 <= nums[i] <= 100
//
// Related Topics 数组 双指针 👍 1688 👎 0

import java.util.Arrays;

/**
 * @author chenkangkang
 * @date 2022/5/10 11:49 AM
 **/
public class T31 {
    public static void main(String[] args) {
//        int[] res = {1, 2, 3};
//        decorator(res);
//        int[] res2 = {3, 2, 1};
//        decorator(res2);
//
//        int[] res3 = {1, 1, 5};
//        decorator(res3);

        int[] res4 = {1, 1, 4, 2, 1};
        //[1,2,1,1,4]
        decorator(res4);
    }

    public static void decorator(int[] nums) {
        new T31().nextPermutation(nums);
        System.out.println(Arrays.toString(nums));
    }

    public void nextPermutation(int[] nums) {
        //1. 从右到左，找到第一个破坏非降序的位置，设为index1
        //2. 从index1出发，找到第一个比index1小的位置，设为index2
        //3. 交换index1与index2的元素
        int n = nums.length;
        int index = -1;
        for (int i = n - 1; i > 0; i--) {
            if (nums[i] > nums[i - 1]) {
                index = i - 1;
                break;
            }
        }
        if (index == -1) {
            reverse(nums, 0, n - 1);
            return;
        }

        for (int i = n - 1; i > index; i--) {
            if (nums[i] > nums[index]) {
                swap(nums, i, index);
                break;
            }
        }
        reverse(nums, index + 1, n - 1);
    }

    private void reverse(int[] nums, int i, int j) {
        while (i < j) {
            swap(nums, i++, j--);
        }
    }

    public void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

}

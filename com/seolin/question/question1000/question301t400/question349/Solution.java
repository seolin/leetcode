package com.seolin.question.question1000.question301t400.question349;
//给定两个数组，编写一个函数来计算它们的交集。
//
//
//
// 示例 1：
//
// 输入：nums1 = [1,2,2,1], nums2 = [2,2]
//输出：[2]
//
//
// 示例 2：
//
// 输入：nums1 = [4,9,5], nums2 = [9,4,9,8,4]
//输出：[9,4]
//
//
//
// 说明：
//
//
// 输出结果中的每个元素一定是唯一的。
// 我们可以不考虑输出结果的顺序。
//
// Related Topics 排序 哈希表 双指针 二分查找

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * 349. 两个数组的交集
 *
 * @author liangzi on 2020/11/2
 */
public class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> num1Set = new HashSet<>();
        Set<Integer> numSet = new HashSet<>();
        for (int i : nums1) {
            num1Set.add(i);
        }
        for (int i : nums2) {
            if (num1Set.contains(i)) {
                numSet.add(i);
            }
        }
        int[] nums = new int[numSet.size()];
        int i = 0;
        for (Integer integer : numSet) {
            nums[i] = integer;
            i++;
        }
        return nums;
    }

    public static void main(String[] args) {
        int[] nums1 = {4, 9, 5};
        int[] nums2 = {9, 4, 9, 8, 4};
        Arrays.stream(new Solution().intersection(nums1, nums2)).forEach(System.out::println);
    }
}

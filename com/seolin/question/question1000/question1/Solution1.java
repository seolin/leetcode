package com.seolin.question.question1000.question1;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author: kangkangchen
 * @Description: 1. 两数之和
 * 给定一个整数数组和一个目标值，找出数组中和为目标值的两个数。
 * 你可以假设每个输入只对应一种答案，且同样的元素不能被重复利用。
 * 示例:
 * 给定 nums = [2, 7, 11, 15], target = 9
 * 因为 nums[0] + nums[1] = 2 + 7 = 9
 * 所以返回 [0, 1]
 * @Date: 9:46 AM 4/25/2018
 */
public class Solution1 {
    public static void main(String[] args) {
        int[] one = {2, 7, 11, 15};
        int target = 9;
        Arrays.stream(new Solution2().towSum(one, target)).forEach(System.out::println);
    }

    public int[] towSum(int[] nums, int target) {
        Map<Integer, Integer> resultMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (resultMap.containsKey(target - nums[i])) {
                return new int[]{resultMap.get(target - nums[i]), i};
            } else {
                resultMap.put(nums[i], i);
            }
        }
        return null;
    }
}

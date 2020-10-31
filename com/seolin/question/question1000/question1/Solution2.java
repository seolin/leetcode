package com.seolin.question.question1000.question1;

import java.util.Arrays;

/**
 * @author liangzi on 2020/10/31
 */
public class Solution2 {
    /**
     * 算法复杂度 n的平方
     *
     * @param nums
     * @param target
     * @return
     */
    public int[] towSum(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    return new int[]{i, j};
                }
            }
        }
        return null;
    }

    public static void main(String[] args) {
        int[] one = {2, 7, 11, 15};
        int target = 9;
        Arrays.stream(new Solution2().towSum(one, target)).forEach(System.out::println);
    }
}

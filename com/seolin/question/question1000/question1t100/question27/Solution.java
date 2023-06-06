package com.seolin.question.question1000.question1t100.question27;

import java.util.Arrays;

/**
 * @author chenkangkang
 * @date 2023/6/2
 **/
public class Solution {
    public int removeElement(int[] nums, int val) {
        int n = nums.length;
        int l = 0, r = n - 1;
        int index = 0;
        while (l < r) {
            if (nums[r] == val) {
                r--;
                continue;
            }
            if (nums[l] == val) {
                nums[l++] = nums[r--];
            }
            index++;
        }
        return index;
    }

    public static void main(String[] args) {
        int[] nums = {3, 2, 2, 3};
        int i = new Solution().removeElement(nums, 3);
        System.out.println(Arrays.toString(nums));
        System.out.println(i);
    }
}

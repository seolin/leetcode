package com.seolin.question.question1000.question1t100.question34;

import java.util.Arrays;

/**
 * @author chenkangkang
 * @date 2023/6/8
 **/
public class Solution3 {
    public int[] searchRange(int[] nums, int target) {
        int l = 0, r = nums.length - 1;
        //寻找左界
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (nums[mid] == target) {
                r = mid - 1;
            } else if (nums[mid] > target) {
                r = mid - 1;
            } else if (nums[mid] < target) {
                l = mid + 1;
            }
        }
        if (l >= nums.length || nums[l] != target) {
            return new int[]{-1, -1};
        }
        int left = l;

        l = 0;
        r = nums.length - 1;

        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (nums[mid] == target) {
                l = mid + 1;
            } else if (nums[mid] > target) {
                r = mid - 1;
            } else if (nums[mid] < target) {
                l = mid + 1;
            }
        }
        return new int[]{left, r};
    }

    public static void main(String[] args) {
        int[] nums = {5, 7, 7, 8, 8, 10};
        int target = 8;
        System.out.println(Arrays.toString(new Solution3().searchRange(nums, target)));
    }

}

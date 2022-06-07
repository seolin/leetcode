package com.seolin.everyday.dichotomy;

/**
 * 二分法
 *
 * @author chenkangkang
 * @date 2022/5/18 5:42 PM
 **/
public class Dichotomy {

    public static void main(String[] args) {
        int[] nums = {1, 2, 2, 2, 3, 4};
        System.out.println(new Dichotomy().dichotomyLeft(2, nums));
        System.out.println(new Dichotomy().dichotomyRight(2, nums));
    }

    /**
     * 找左界
     *
     * @return 目标值
     */
    public int dichotomyLeft(int target, int[] nums) {
        int n = nums.length;
        int l = 0, r = n;
        while (l < r) {
            int mid = (l + r) >> 1;
            if (nums[mid] >= target) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        return l;
    }

    /**
     * 找右界
     */
    private int dichotomyRight(int target, int[] nums) {
        int n = nums.length;
        int l = 0, r = n - 1;
        while (l < r) {
            int mid = (l + r + 1) >> 1;
            if (nums[mid] <= target) {
                l = mid;
            } else {
                r = mid - 1;
            }
        }
        return l;
    }
}

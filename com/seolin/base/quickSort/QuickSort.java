package com.seolin.base.quickSort;

import java.util.Arrays;

/**
 * @author kkchen on 2019/3/6
 */
public class QuickSort {

    private static void quickSort(int[] nums) {
        sort(nums, 0, nums.length - 1);
    }

    private static void sort(int[] nums, int lo, int hi) {
        if (lo >= hi) {
            return;
        }

        int mid = getMidIndex(nums, lo, hi);
        sort(nums, lo, mid - 1);
        sort(nums, mid + 1, hi);
    }

    private static int getMidIndex(int[] nums, int lo, int hi) {
        int i = lo;
        int j = hi + 1;
        int key = nums[lo];

        while (true) {
            while (nums[++i] <= key) {
                if (i == hi) {
                    break;
                }
            }
            while (key <= nums[--j]) {
                if (j == lo) {
                    break;
                }
            }

            if (i >= j) {

                break;
            }
            swap(nums, i, j);
        }
        swap(nums, lo, j);
        return j;
    }

    private static void swap(int[] nums, int i, int y) {
        if (i == y) {
            return;
        }
        nums[i] ^= nums[y];
        nums[y] ^= nums[i];
        nums[i] ^= nums[y];
    }

    public static void main(String[] args) {
        int[] arrs = new int[]{5, 3, 6, 7, 8, 9};
        quickSort(arrs);
        System.out.println(Arrays.toString(arrs));
    }


}

package com.seolin.base.quickSort;

import java.util.Arrays;


/**
 * @author kkchen on 2019/3/6
 */
public class QuickSort3 {

    private static void quickSort(int[] nums, int lo, int hi) {
        if (hi <= lo) {
            return;
        }
        int lt = lo, i = lo + 1, gt = hi;
        int v = nums[lo];
        while (i <= gt) {
            if (nums[i] < v) {
                swap(nums, lt++, i++);
            } else if (nums[i] > v) {
                swap(nums, i, gt--);
            } else {
                i++;
            }
        }
        quickSort(nums, lo, lt - 1);
        quickSort(nums, gt + 1, hi);
    }


    private static void swap(int[] nums, int i, int j) {
        if (i == j) {
            return;
        }
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }


    public static void main(String[] args) {
        int[] arrs = new int[]{5, 3, 6, 7, 8, 9};
        quickSort(arrs, 0, arrs.length - 1);
        System.out.println(Arrays.toString(arrs));
    }


}

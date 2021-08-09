package com.seolin.base.quickSort;

import java.util.Arrays;


/**
 * @author kkchen on 2019/3/6
 */
public class QuickSort2 {

    private static void quickSort(int[] nums, int begin, int end) {
        if (begin >= end) {
            return;
        }
        int pivot = partition(nums, begin, end);
        quickSort(nums, begin, pivot);
        quickSort(nums, pivot + 1, end);
    }

    private static int partition(int[] nums, int begin, int end) {
        int pivot = end;
        int count = begin;
        for (int i = begin; i < end; i++) {
            if (nums[i] < nums[pivot]) {
                swap(nums, i, pivot);
                count++;
            }
        }
        swap(nums, pivot, count);
        return  count;
    }

    private static void swap(int[] nums, int i, int j) {
        if (i == j) {
            return;
        }
        nums[i] ^= nums[j];
        nums[j] ^= nums[i];
        nums[i] ^= nums[j];
    }


    public static void main(String[] args) {
        int[] arrs = new int[]{5, 3, 6, 7, 8, 9};
        quickSort(arrs, 0, arrs.length);
        System.out.println(Arrays.toString(arrs));
    }


}

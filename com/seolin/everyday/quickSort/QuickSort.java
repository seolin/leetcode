package com.seolin.everyday.quickSort;

import java.util.Arrays;
import java.util.Random;

/**
 * 快速排序
 *
 * @author chenkangkang
 * @date 2022/5/20 4:46 PM
 **/
public class QuickSort {

    public static void main(String[] args) {
        int[] nums = {3, 2, 1, 5, 4, 1, 3};
        new QuickSort().quickSortLeft(nums, 0, nums.length - 1);
        System.out.println(Arrays.toString(nums));

        int[] nums2 = {3, 2, 1, 5, 4, 1, 3};
        new QuickSort().partition(nums2, 0, nums.length - 1);
        System.out.println(Arrays.toString(nums2));
    }

    private void quickSortLeft(int[] nums, int left, int right) {
        if (left >= right) {
            return;
        }
        int randomIndex = left + random.nextInt(right - left + 1);
        swap(nums, left, randomIndex);

        int p = left;
        int count = left;
        for (int i = left; i <= right; i++) {
            if (nums[i] < nums[p]) {
                count++;
                swap(nums, i, count);
            }
        }
        swap(nums, p, count);
        quickSortLeft(nums, left, count - 1);
        quickSortLeft(nums, count + 1, right);
    }

    private void swap(int[] nums, int s, int t) {
        int temp = nums[t];
        nums[t] = nums[s];
        nums[s] = temp;
    }

    private final static Random random = new Random(1000);


    private void partition(int[] nums, int left, int right) {
        int randomIndex = left + random.nextInt(right - left + 1);
        swap(nums, left, randomIndex);

        // all in nums[left + 1..le) <= pivot;
        // all in nums(ge..right] >= pivot;
        int pivot = nums[left];
        int le = left + 1;
        int ge = right;

        while (true) {
            while (le <= ge && nums[le] < pivot) {
                le++;
            }

            while (le <= ge && nums[ge] > pivot) {
                ge--;
            }

            if (le >= ge) {
                break;
            }
            swap(nums, le, ge);
            le++;
            ge--;
        }

        swap(nums, left, ge);
        partition(nums, left, ge - 1);
        partition(nums, ge + 1, right);
    }
}

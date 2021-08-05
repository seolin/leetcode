package com.seolin.base.mergeSort;

/**
 * @author liangzi on 2021/8/5
 */
public class MergeSort {
    public void mergeSort(int left, int right, int[] nums) {
        if (left >= right) {
            return;
        }
        int mid = (left + right) >> 1;
        mergeSort(left, mid, nums);
        mergeSort(mid + 1, right, nums);
        merge(left, mid, right, nums);
    }

    private void merge(int left, int mid, int right, int[] nums) {
        int[] temp = new int[right - left + 1];
        int i = left;
        int j = mid + 1;
        int k = 0;
        while (i <= mid && j <= right) {
            temp[k++] = nums[i] < nums[j] ? nums[i++] : nums[j++];
        }
        while (i <= mid) {
            temp[k++] = nums[i++];
        }
        while (j <= right) {
            temp[k++] = nums[j++];
        }
        for (int p = 0; p < temp.length; p++) {
            nums[left + p] = temp[p];
        }
    }

    public static void main(String[] args) {
        int[] nums = {2, 1, 3};
        new MergeSort().mergeSort(0, nums.length - 1, nums);
        for (int num : nums) {
            System.out.println(num);
        }
    }
}

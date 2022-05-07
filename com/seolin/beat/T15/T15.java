package com.seolin.beat.T15;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author chenkangkang
 * @date 2022/5/6 8:19 PM
 **/
public class T15 {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> ansList = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            return ansList;
        }
        //排序
        Arrays.sort(nums);
        int n = nums.length;
        for (int i = 0; i < n - 2; i++) {
            //因为已经是排好序的，所以找和为0需要其中一个元素小于等于0
            if (nums[i] > 0) {
                break;
            }
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int l = i + 1;
            int r = n - 1;
            while (l < r) {
                int sum = nums[i] + nums[l] + nums[r];
                if (sum == 0) {
                    List<Integer> subList = new ArrayList<>();
                    subList.add(nums[i]);
                    subList.add(nums[l]);
                    subList.add(nums[r]);
                    ansList.add(subList);
                    //先++，原本就得++，如果相等则继续++
                    while (l < r && nums[l] == nums[++l]) ;
                    while (l < r && nums[r] == nums[--r]) ;
                } else if (sum < 0) {
                    while (l < r && nums[l] == nums[++l]) ;
                } else {
                    while (l < r && nums[r] == nums[--r]) ;
                }
            }
        }
        return ansList;
    }
}

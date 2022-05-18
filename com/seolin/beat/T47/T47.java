package com.seolin.beat.T47;
//给定一个可包含重复数字的序列 nums ，按任意顺序 返回所有不重复的全排列。
//
//
//
// 示例 1：
//
//
//输入：nums = [1,1,2]
//输出：
//[[1,1,2],
// [1,2,1],
// [2,1,1]]
//
//
// 示例 2：
//
//
//输入：nums = [1,2,3]
//输出：[[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
//
//
//
//
// 提示：
//
//
// 1 <= nums.length <= 8
// -10 <= nums[i] <= 10
//
// Related Topics 数组 回溯 👍 1065 👎 0

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 全排列
 *
 * @author chenkangkang
 * @date 2022/5/17 5:39 PM
 **/
public class T47 {
    public static void main(String[] args) {
        int[] nums = {1, 1, 2};
        System.out.println(new T47().permuteUnique(nums));
    }

    public List<List<Integer>> permuteUnique(int[] nums) {
        Set<List<Integer>> resList = new HashSet<>();
        int n = nums.length;
        if (n == 0) {
            return new ArrayList<>(resList);
        }
        //如何判断元素已经使用过了
        boolean[] used = new boolean[n];
        List<Integer> pathList = new ArrayList<>();
        dfs(nums, pathList, used, resList);
        return new ArrayList<>(resList);
    }

    private void dfs(int[] nums, List<Integer> pathList, boolean[] used, Set<List<Integer>> resList) {
        if (pathList.size() >= nums.length) {
            resList.add(pathList);
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (used[i]) {
                continue;
            }

            boolean[] newUsed = new boolean[nums.length];
            for (int j = 0; j < nums.length; j++) {
                newUsed[j] = used[j];
            }
            List<Integer> newList = new ArrayList<>(pathList);
            newUsed[i] = true;
            newList.add(nums[i]);
            dfs(nums, newList, newUsed, resList);
        }
    }

}

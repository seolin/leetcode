package com.seolin.beat.T46;
//给定一个不含重复数字的数组 nums ，返回其 所有可能的全排列 。你可以 按任意顺序 返回答案。
//
//
//
// 示例 1：
//
//
//输入：nums = [1,2,3]
//输出：[[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
//
//
// 示例 2：
//
//
//输入：nums = [0,1]
//输出：[[0,1],[1,0]]
//
//
// 示例 3：
//
//
//输入：nums = [1]
//输出：[[1]]
//
//
//
//
// 提示：
//
//
// 1 <= nums.length <= 6
// -10 <= nums[i] <= 10
// nums 中的所有整数 互不相同
//
// Related Topics 数组 回溯 👍 2006 👎 0

import java.util.ArrayList;
import java.util.List;

/**
 * @author chenkangkang
 * @date 2022/5/13 4:48 PM
 **/
public class T46 {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        System.out.println(new T46().permute(nums));
    }

    public List<List<Integer>> permute(int[] nums) {

        int n = nums.length;
        List<List<Integer>> resList = new ArrayList<>();
        //判空
        if (n == 0) {
            return resList;
        }
        boolean[] used = new boolean[n];
        List<Integer> curList = new ArrayList<>();
        dfs(nums, curList, used, resList);
        return resList;
    }

    private void dfs(int[] nums, List<Integer> curList, boolean[] used, List<List<Integer>> resList) {
        if (curList.size() >= nums.length) {
            resList.add(curList);
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (used[i]) {
                continue;
            }
            List<Integer> newList = new ArrayList<>(curList);
            //复制已经使用
            boolean[] newUsed = new boolean[nums.length];
            for (int j = 0; j < nums.length; j++) {
                newUsed[j] = used[j];
            }
            newUsed[i] = true;
            newList.add(nums[i]);
            dfs(nums, newList, newUsed, resList);
        }
    }


}

/*
    public List<List<Integer>> permute(int[] nums) {
        // 首先是特判
        int len = nums.length;
        // 使用一个动态数组保存所有可能的全排列
        List<List<Integer>> res = new ArrayList<>();

        if (len == 0) {
            return res;
        }

        boolean[] used = new boolean[len];
        List<Integer> path = new ArrayList<>();

        dfs(nums, len, 0, path, used, res);
        return res;
    }

    private void dfs(int[] nums, int len, int depth,
                     List<Integer> path, boolean[] used,
                     List<List<Integer>> res) {
        if (depth == len) {
            // 3、不用拷贝，因为每一层传递下来的 path 变量都是新建的
            res.add(path);
            return;
        }

        for (int i = 0; i < len; i++) {
            if (!used[i]) {
                // 1、每一次尝试都创建新的变量表示当前的"状态"
                List<Integer> newPath = new ArrayList<>(path);
                newPath.add(nums[i]);

                boolean[] newUsed = new boolean[len];
                System.arraycopy(used, 0, newUsed, 0, len);
                newUsed[i] = true;

                dfs(nums, len, depth + 1, newPath, newUsed, res);
                // 2、无需回溯
            }
        }
    }
 */

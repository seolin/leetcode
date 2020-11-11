package com.seolin.question.question1000.question301t400.question347;
//给定一个非空的整数数组，返回其中出现频率前 k 高的元素。
//
//
//
// 示例 1:
//
// 输入: nums = [1,1,1,2,2,3], k = 2
//输出: [1,2]
//
//
// 示例 2:
//
// 输入: nums = [1], k = 1
//输出: [1]
//
//
//
// 提示：
//
//
// 你可以假设给定的 k 总是合理的，且 1 ≤ k ≤ 数组中不相同的元素的个数。
// 你的算法的时间复杂度必须优于 O(n log n) , n 是数组的大小。
// 题目数据保证答案唯一，换句话说，数组中前 k 个高频元素的集合是唯一的。
// 你可以按任意顺序返回答案。
//
// Related Topics 堆 哈希表
// 👍 565 👎 0

import java.util.*;

/**
 * 347. 前 K 个高频元素
 *
 * @author liangzi on 2020/11/11
 */
public class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> num2CountMap = new HashMap<>();

        for (int num : nums) {
            Integer count = num2CountMap.getOrDefault(num, 0);
            count++;
            num2CountMap.put(num, count);
        }
        int[][] n = new int[num2CountMap.size()][2];
        int i = 0;
        for (Map.Entry<Integer, Integer> entry : num2CountMap.entrySet()) {
            n[i][0] = entry.getKey();
            n[i][1] = entry.getValue();
            i++;
        }

        List<int[]> list = Arrays.asList(n);
        list.sort(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return Integer.compare(o1[1], o2[1]) * -1;
            }
        });

        int[] result = new int[k];
        for (int j = 0; j < k; j++) {
            result[j] = list.get(j)[0];
        }
        return result;
    }

    public static void main(String[] args) {
//        int[] nums = {1, 1, 1, 2, 2, 3};
//        int k = 2;
        int[] nums = {1};
        int k = 1;
        System.out.println(Arrays.toString(new Solution().topKFrequent(nums, k)));
    }
}

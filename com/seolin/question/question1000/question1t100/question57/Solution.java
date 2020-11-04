package com.seolin.question.question1000.question1t100.question57;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
//给出一个无重叠的 ，按照区间起始端点排序的区间列表。
//
// 在列表中插入一个新的区间，你需要确保列表中的区间仍然有序且不重叠（如果有必要的话，可以合并区间）。
//
//
//
// 示例 1：
//
// 输入：intervals = [[1,3],[6,9]], newInterval = [2,5]
//输出：[[1,5],[6,9]]
//
//
// 示例 2：
//
// 输入：intervals = [[1,2],[3,5],[6,7],[8,10],[12,16]], newInterval = [4,8]
//输出：[[1,2],[3,10],[12,16]]
//解释：这是因为新的区间 [4,8] 与 [3,5],[6,7],[8,10] 重叠。
//
//
//
//
// 注意：输入类型已在 2019 年 4 月 15 日更改。请重置为默认代码定义以获取新的方法签名。
// Related Topics 排序 数组

/**
 * 57. 插入区间
 *
 * @author liangzi on 2020/11/4
 */
public class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> resultList = new ArrayList<>();
        int left = newInterval[0];
        int right = newInterval[1];
        boolean place = false;
        for (int[] interval : intervals) {
            if (interval[0] > right) {
                if (!place) {
                    resultList.add(new int[]{left, right});
                    place = true;
                }
                resultList.add(interval);
            } else if (interval[1] < left) {
                resultList.add(interval);
            } else {
                left = Math.min(left, interval[0]);
                right = Math.max(right, interval[1]);
            }
        }
        if (!place) {
            resultList.add(new int[]{left, right});
        }
        int[][] r = new int[resultList.size()][2];
        for (int i = 0; i < resultList.size(); i++) {
            r[i] = resultList.get(i);
        }
        return r;
    }

    public static void main(String[] args) {
        int[][] intervals = {{1, 2}, {5, 7}};
        int[] newInterval = {3, 6};
        intervals = new Solution().insert(intervals, newInterval);
        for (int[] interval : intervals) {
            System.out.println(Arrays.toString(interval));
            ;
        }
    }
}

package com.seolin.question.question1000.question401t500.question435;
//给定一个区间的集合，找到需要移除区间的最小数量，使剩余区间互不重叠。
//
// 注意:
//
//
// 可以认为区间的终点总是大于它的起点。
// 区间 [1,2] 和 [2,3] 的边界相互“接触”，但没有相互重叠。
//
//
// 示例 1:
//
//
//输入: [ [1,2], [2,3], [3,4], [1,3] ]
//
//输出: 1
//
//解释: 移除 [1,3] 后，剩下的区间没有重叠。
//
//
// 示例 2:
//
//
//输入: [ [1,2], [1,2], [1,2] ]
//
//输出: 2
//
//解释: 你需要移除两个 [1,2] 来使剩下的区间没有重叠。
//
//
// 示例 3:
//
//
//输入: [ [1,2], [2,3] ]
//
//输出: 0
//
//解释: 你不需要移除任何区间，因为它们已经是无重叠的了。
//
// Related Topics 贪心算法
// 👍 242 👎 0

import java.util.Arrays;
import java.util.Comparator;

/**
 * 435. 无重叠区间
 *
 * @author liangzi on 2020/11/23
 */
public class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        if (intervals == null) {
            return 0;
        }
        int n = intervals.length;
        if (n == 0 || n == 1) {
            return 0;
        }
        Arrays.sort(intervals, Comparator.comparingInt(source -> source[1]));
        int right = intervals[0][1];
        int count = 0;
        for (int i = 1; i < n; i++) {
            int currentLeft = intervals[i][0];
            int currentRight = intervals[i][1];
            if (currentLeft >= right) {
                right = currentRight;
            } else {
                count++;
            }
        }
        return count;
    }
}

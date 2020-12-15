package com.seolin.question.question1000.question701t800.question738;
//给定一个非负整数 N，找出小于或等于 N 的最大的整数，同时这个整数需要满足其各个位数上的数字是单调递增。
//
// （当且仅当每个相邻位数上的数字 x 和 y 满足 x <= y 时，我们称这个整数是单调递增的。）
//
// 示例 1:
//
// 输入: N = 10
//输出: 9
//
//
// 示例 2:
//
// 输入: N = 1234
//输出: 1234
//
//
// 示例 3:
//
// 输入: N = 332
//输出: 299
//
//
// 说明: N 是在 [0, 10^9] 范围内的一个整数。
// Related Topics 贪心算法
// 👍 103 👎 0

/**
 * 738. 单调递增的数字
 *
 * @author liangzi on 2020/12/15
 */
public class Solution {
    public int monotoneIncreasingDigits(int N) {
        char[] str = String.valueOf(N).toCharArray();
        int i = 1;
        while (i < str.length && str[i - 1] <= str[i]) {
            i++;
        }
        if (i < str.length) {
            while (i > 0 && str[i - 1] > str[i]) {
                str[i - 1] -= 1;
                i--;
            }
            for (i += 1; i < str.length; i++) {
                str[i] = '9';
            }
        }
        return Integer.parseInt(String.valueOf(str));
    }

    public static void main(String[] args) {
        System.out.println(new Solution().monotoneIncreasingDigits(332));
    }
}

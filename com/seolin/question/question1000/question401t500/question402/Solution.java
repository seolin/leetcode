package com.seolin.question.question1000.question401t500.question402;
//给定一个以字符串表示的非负整数 num，移除这个数中的 k 位数字，使得剩下的数字最小。
//
// 注意:
//
//
// num 的长度小于 10002 且 ≥ k。
// num 不会包含任何前导零。
//
//
// 示例 1 :
//
//
//输入: num = "1432219", k = 3
//输出: "1219"
//解释: 移除掉三个数字 4, 3, 和 2 形成一个新的最小的数字 1219。
//
//
// 示例 2 :
//
//
//输入: num = "10200", k = 1
//输出: "200"
//解释: 移掉首位的 1 剩下的数字为 200. 注意输出不能有任何前导零。
//
//
// 示例 3 :
//
//
//输入: num = "10", k = 2
//输出: "0"
//解释: 从原数字移除所有的数字，剩余为空就是0。
//
// Related Topics 栈 贪心算法
// 👍 411 👎 0

import java.util.Deque;
import java.util.LinkedList;

/**
 * 402. 移掉K位数字
 *
 * @author liangzi on 2020/11/15
 */
public class Solution {
    public String removeKdigits(String num, int k) {
        Deque<Character> deque = new LinkedList<Character>();
        int n = num.length();
        for (int i = 0; i < n; i++) {
            char s = num.charAt(i);
            while (!deque.isEmpty() && k > 0 && deque.peekLast() > s) {
                deque.pollLast();
                k--;
            }
            deque.add(s);
        }
        for (int i = 0; i < k; i++) {
            deque.pollLast();
        }
        StringBuilder builder = new StringBuilder();
        boolean isTop = true;
        for (Character character : deque) {
            if (isTop && character.equals('0')) {
                continue;
            }
            isTop = false;
            builder.append(character);
        }
        return builder.length() == 0 ? "0" : builder.toString();
    }

    public static void main(String[] args) {
//        System.out.println("1432219".substring(1, 2));
        System.out.println(new Solution().removeKdigits("1432219", 3));
        System.out.println(new Solution().removeKdigits("10", 3));
        System.out.println(new Solution().removeKdigits("112", 1));
    }
}

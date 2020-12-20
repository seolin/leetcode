package com.seolin.question.question1000.question301t400.question316;
//给你一个字符串 s ，请你去除字符串中重复的字母，使得每个字母只出现一次。需保证 返回结果的字典序最小（要求不能打乱其他字符的相对位置）。
//
// 注意：该题与 1081 https://leetcode-cn.com/problems/smallest-subsequence-of-distinct
//-characters 相同
//
//
//
// 示例 1：
//
//
//输入：s = "bcabc"
//输出："abc"
//
//
// 示例 2：
//
//
//输入：s = "cbacdcbc"
//输出："acdb"
//
//
//
// 提示：
//
//
// 1 <= s.length <= 104
// s 由小写英文字母组成
//
// Related Topics 栈 贪心算法 字符串
// 👍 374 👎 0

import java.util.LinkedList;

/**
 * 316. 去除重复字母
 *
 * @author liangzi on 2020/12/20
 */
public class Solution {
    public String removeDuplicateLetters(String s) {
        boolean[] visit = new boolean[26];
        int[] num = new int[26];
        //统计每个字母出现次数
        for (int i = 0; i < s.length(); i++) {
            num[s.charAt(i) - 'a']++;
        }
        LinkedList<Character> stack = new LinkedList<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            int letterIndex = c - 'a';
            if (!visit[letterIndex]) {
                while (stack.size() > 0 && stack.getLast() > c) {
                    if (num[stack.getLast() - 'a'] > 0) {
                        visit[stack.getLast() - 'a'] = false;
                        stack.removeLast();
                    } else {
                        break;
                    }
                }
                stack.add(c);
                visit[letterIndex] = true;
            }
            num[letterIndex]--;
        }
        StringBuilder builder = new StringBuilder();
        stack.forEach(builder::append);
        return builder.toString();
    }

    public static void main(String[] args) {
        System.out.println(new Solution().removeDuplicateLetters("cbacdcbc"));
        System.out.println(new Solution().removeDuplicateLetters("bcabc"));
    }
}

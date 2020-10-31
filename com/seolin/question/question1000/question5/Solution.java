package com.seolin.question.question1000.question5;

/**
 * 5. 最长回文子串
 * 给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为1000。
 * 示例 1：
 * 输入: "babad"
 * 输出: "bab"
 * 注意: "aba"也是一个有效答案。
 * 示例 2：
 * 输入: "cbbd"
 * 输出: "bb"
 *
 * @author kkchen on 2018/9/5
 */
public class Solution {
    public static void main(String[] args) {
        String txt = "cbbd";
        System.out.println(new Solution().longestPalindrome(txt));
    }

    public String longestPalindrome(String s) {
        if (s == null || s.length() == 0) {
            return "";
        }
        boolean[][] dp = new boolean[s.length()][s.length()];
        dp[0][0] = true;
        char[] words = s.toCharArray();
        int[] point = {0, 1};
        int max = 1;
        for (int length = 0; length < s.length(); length++) {
            for (int i = 0; i + length < s.length(); i++) {
                int j = i + length;
                if (length == 0) {
                    dp[i][j] = true;
                } else if (length == 1) {
                    dp[i][j] = words[i] == words[j];
                } else {
                    dp[i][j] = words[i] == words[j] && dp[i + 1][j - 1];
                }
                if (dp[i][j] && length + 1 > max) {
                    point[0] = i;
                    point[1] = i + length + 1;
                }
            }
        }
        return s.substring(point[0], point[1]);
    }

}

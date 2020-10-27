package com.seolin.question5;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
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
public class Solution4 {
    public static void main(String[] args) {
        Date now = new Date();
        String test = "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaabcaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa";
        System.out.println("用时：" + (new Date().getTime() - now.getTime()) + "毫秒，结果：" + longestPalindrome(test));

    }

    public static String longestPalindrome(String s) {
        if (s == null || s.length() == 0) {
            return "";
        }
        int length = 0;
        char[] sChars = s.toCharArray();
        List<Character> characterList = new ArrayList<>();
        int finalLength = 0;
        String resultString = s.substring(0, 1);
        for (int i = 0; i < s.length(); i++) {
            for (int j = 0; j < characterList.size(); j++) {
                if (sChars[i] == characterList.get(j)) {
                    boolean isPalindromic = true;
                    int k = i - 1;
                    int b = j + 1;
                    for (; b < k; b++) {
                        if (sChars[k] != characterList.get(b)) {
                            isPalindromic = false;
                        }
                        k--;
                    }
                    if (isPalindromic) {
                        length = i - j + 1;
                        if (finalLength < length) {
                            finalLength = length;
                            resultString = s.substring(j, i + 1);
                        }
                    }
                }
            }
            characterList.add(sChars[i]);
        }
        return resultString;
    }

}

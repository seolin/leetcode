package com.seolin.question.question3;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: kangkangchen
 * @Description: 3.无重复字符的最长子串
 * 给定一个字符串，找出不含有重复字符的最长子串的长度。
 * 示例：
 * 给定 "abcabcbb" ，没有重复字符的最长子串是 "abc" ，那么长度就是3。
 * 给定 "bbbbb" ，最长的子串就是 "b" ，长度是1。
 * 给定 "pwwkew" ，最长子串是 "wke" ，长度是3。请注意答案必须是一个子串，"pwke" 是 子序列  而不是子串。
 * @Date: 4:25 PM 4/25/2018
 */
public class Solution3 {
    public static void main(String[] args) {
        String s = "abcdefghigklmnopqrstuvwxyz请注意答案必须是一个子串，pwke 是 子序列  而不是子串";
        System.out.println(lengthOfLongestSubstring(s));
    }

    public static int lengthOfLongestSubstring(String s) {
        char[] charList = s.toCharArray();
        Map<Character, Integer> map = new HashMap<>();
        int max = 0;
        for (int i = 0; i < charList.length; i++) {
            if (map.containsKey(charList[i])) {
                if (max < map.size()) {
                    max = map.size();
                }
                i = map.get(charList[i]) + 1;
                map.clear();
                map.put(charList[i], i);
            } else {
                map.put(charList[i], i);
            }
        }
        if (map.size() > max) {
            max = map.size();
        }
        return max;
    }
}

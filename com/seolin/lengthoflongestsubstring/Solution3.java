package com.seolin.lengthoflongestsubstring;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: kangkangchen
 * @Description: 无重复字符的最长子串
 * 给定一个字符串，找出不含有重复字符的最长子串的长度。
 * 示例：
 * 给定 "abcabcbb" ，没有重复字符的最长子串是 "abc" ，那么长度就是3。
 * 给定 "bbbbb" ，最长的子串就是 "b" ，长度是1。
 * 给定 "pwwkew" ，最长子串是 "wke" ，长度是3。请注意答案必须是一个子串，"pwke" 是 子序列  而不是子串。
 * @Date: 4:25 PM 4/25/2018
 */
public class Solution3 {
    public static void main(String[] args) {
        String s = "abcabcbb";
        System.out.println(lengthOfLongestSubstring(s));
    }

    public static int lengthOfLongestSubstring(String s) {
        char[] charList = s.toCharArray();
        Map<Integer, Character> map = new HashMap<>();
        int i = 0;
        int max = 0;
        for (char c : charList) {
            if (map.containsValue(c)) {
                if (max < map.size()) {
                    max = map.size();
                }
                i = 0;
                map.clear();
                map.put(i, c);
            } else {
                map.put(i, c);
            }
            i++;
        }
        return max;
    }
}

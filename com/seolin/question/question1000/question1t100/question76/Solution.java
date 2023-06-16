package com.seolin.question.question1000.question1t100.question76;

import java.util.HashMap;
import java.util.Map;

/**
 * @author chenkangkang
 * @date 2023/6/7
 **/
public class Solution {
    public String minWindow(String s, String t) {
        //滑动窗口 在成功包含t中所有元素后，窗口缩小

        Map<Character, Integer> sm = new HashMap<>();
        Map<Character, Integer> tm = new HashMap<>();

        for (char c : t.toCharArray()) {
            tm.put(c, tm.getOrDefault(c, 0) + 1);
        }
        int l = 0, r = 0;
        char[] cs = s.toCharArray();
        int valid = 0;
        int start = 0;
        int len = Integer.MAX_VALUE;
        while (r < s.length()) {
            char c = cs[r];
            r++;
            if (tm.containsKey(c)) {
                sm.put(c, sm.getOrDefault(c, 0) + 1);
                if (sm.get(c).equals(tm.get(c))) {
                    valid++;
                }
            }
            while (valid == tm.size()) {
                if (r - l < len) {
                    start = l;
                    len = r - l;
                }
                char d = cs[l];
                if (tm.containsKey(d)) {
//                    if (sm.get(d).equals(tm.get(d))) {
                        valid--;
//                    }
                    sm.put(d, sm.get(d) - 1);
                }
                l++;
            }
        }
        if (len == Integer.MAX_VALUE) {
            return "";
        }
        return s.substring(start, start + len);
    }

    public static void main(String[] args) {
        String s =
                "ADOBECODEBANC";
        String t =
                "ABC";
        System.out.println(new Solution().minWindow(s, t));
    }
}

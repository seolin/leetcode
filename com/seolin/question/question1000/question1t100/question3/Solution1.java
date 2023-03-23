package com.seolin.question.question1000.question1t100.question3;

import java.util.HashMap;

/**
 * @author chenkangkang
 * @date 2023/3/23 3:15 PM
 **/
public class Solution1 {

    public static void main(String[] args) {
        String s = "abcabcbb";
        System.out.println(new Solution1().lengthOfLongestSubstring(s));
    }

    public int lengthOfLongestSubstring(String s) {
        if (s.length() == 0) {
            return 0;
        }
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        int max = 0;
        int left = 0;
        for (int i = 0; i < s.length(); i++) {
            if (map.containsKey(s.charAt(i))) {
                left = Math.max(left, map.get(s.charAt(i)) + 1);
            }
            map.put(s.charAt(i), i);
            max = Math.max(max, i - left + 1);
        }
        return max;

    }

}

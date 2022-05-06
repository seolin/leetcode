package com.seolin.beat.T3;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/**
 * 3. 无重复字符的最长子串
 *
 * @author chenkangkang
 * @date 2022/5/5 1:46 PM
 **/
public class T3 {
    public static void main(String[] args) {
        String s = " ";
        System.out.println(new T3().lengthOfLongestSubstring2(s));
    }

    /**
     * 个人感觉的最优解
     */
    public int lengthOfLongestSubstring(String s) {
        int[] chars = new int[256];
        for (int i = 0; i < chars.length; i++) {
            chars[i] = -1;
        }
        int l = -1, r = 0, ans = 0;
        while (r < s.length()) {
            int num = chars[s.charAt(r)];
            if (num > l) {
                l = num;
            }
            chars[s.charAt(r)] = r;
            ans = Math.max(ans, r - l);
            r++;
        }
        return ans;
    }

    public int lengthOfLongestSubstring2(String s) {
        if (s.length() == 0) {
            return 0;
        }
        HashMap<Character, Integer> map = new HashMap<>();
        int max = 0;
        for (int i = 0, j = 0; i < s.length(); ++i) {
            if (map.containsKey(s.charAt(i))) {
                j = Math.max(j, map.get(s.charAt(i)) + 1);
            }
            map.put(s.charAt(i), i);
            max = Math.max(max, i - j + 1);
        }
        return max;
    }


    public int lengthOfLongestSubstring3(String s) {
        Set<Character> set = new HashSet<>();
        int l = 0, r = 0, ans = 0;
        while (r < s.length()) {
            if (set.contains(s.charAt(r))) {
                set.remove(s.charAt(l++));
            } else {
                set.add(s.charAt(r++));
                ans = Math.max(ans, set.size());
            }
        }
        return ans;
    }


}

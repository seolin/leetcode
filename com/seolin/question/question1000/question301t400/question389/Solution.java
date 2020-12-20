package com.seolin.question.question1000.question301t400.question389;
//给定两个字符串 s 和 t，它们只包含小写字母。
//
// 字符串 t 由字符串 s 随机重排，然后在随机位置添加一个字母。
//
// 请找出在 t 中被添加的字母。
//
//
//
// 示例 1：
//
// 输入：s = "abcd", t = "abcde"
//输出："e"
//解释：'e' 是那个被添加的字母。
//
//
// 示例 2：
//
// 输入：s = "", t = "y"
//输出："y"
//
//
// 示例 3：
//
// 输入：s = "a", t = "aa"
//输出："a"
//
//
// 示例 4：
//
// 输入：s = "ae", t = "aea"
//输出："a"
//
//
//
//
// 提示：
//
//
// 0 <= s.length <= 1000
// t.length == s.length + 1
// s 和 t 只包含小写字母
//
// Related Topics 位运算 哈希表
// 👍 188 👎 0

import java.util.HashMap;
import java.util.Map;

/**
 * 389. 找不同
 *
 * @author liangzi on 2020/12/18
 */
public class Solution {
    public char findTheDifference(String s, String t) {
        Map<Character, Integer> char2CountMap = new HashMap<>();
        for (char c : s.toCharArray()) {
            Integer count = char2CountMap.getOrDefault(c, 0);
            count++;
            char2CountMap.put(c, count);
        }
        for (char c : t.toCharArray()) {
            Integer count = char2CountMap.get(c);
            if (count == null) {
                return c;
            }
            count--;
            if (count.equals(0)) {
                char2CountMap.remove(c);
            } else {
                char2CountMap.put(c, count);
            }
        }
        char c = 'b';
        for (Character character : char2CountMap.keySet()) {
            c = character;
        }
        return char2CountMap.keySet().stream().findFirst().get();
    }

    public static void main(String[] args) {
        System.out.println(new Solution().findTheDifference("ae", "aea"));
    }
}

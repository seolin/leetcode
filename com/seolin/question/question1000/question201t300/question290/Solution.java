package com.seolin.question.question1000.question201t300.question290;
//给定一种规律 pattern 和一个字符串 str ，判断 str 是否遵循相同的规律。
//
// 这里的 遵循 指完全匹配，例如， pattern 里的每个字母和字符串 str 中的每个非空单词之间存在着双向连接的对应规律。
//
// 示例1:
//
// 输入: pattern = "abba", str = "dog cat cat dog"
//输出: true
//
// 示例 2:
//
// 输入:pattern = "abba", str = "dog cat cat fish"
//输出: false
//
// 示例 3:
//
// 输入: pattern = "aaaa", str = "dog cat cat dog"
//输出: false
//
// 示例 4:
//
// 输入: pattern = "abba", str = "dog dog dog dog"
//输出: false
//
// 说明:
//你可以假设 pattern 只包含小写字母， str 包含了由单个空格分隔的小写字母。
// Related Topics 哈希表
// 👍 244 👎 0

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * 290. 单词规律
 *
 * @author liangzi on 2020/12/16
 */
public class Solution {
    public boolean wordPattern(String pattern, String s) {
        String[] array = s.split(" ");
        char[] patterns = pattern.toCharArray();
        if (array.length != pattern.length()) {
            return false;
        }
        Map<Character, String> char2StrMap = new HashMap<>();
        Set<String> uniqueStr = new HashSet<>();
        for (int i = 0; i < patterns.length; i++) {
            String target = char2StrMap.get(patterns[i]);
            if (target == null) {
                if (uniqueStr.contains(array[i])) {
                    return false;
                }
                char2StrMap.put(patterns[i], array[i]);
                uniqueStr.add(array[i]);
            } else if (array[i].equals(target)) {
                continue;
            } else {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().wordPattern("abba", "dog cat cat dog"));
        System.out.println(new Solution().wordPattern("abba", "dog cat cat fish"));
        System.out.println(new Solution().wordPattern("aaaa", "dog cat cat dog"));
        System.out.println(new Solution().wordPattern("abba", "dog dog dog dog"));
        System.out.println(new Solution().wordPattern("aaa", "dog dog dog dog"));
    }
}

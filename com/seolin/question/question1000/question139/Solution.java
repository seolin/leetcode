package com.seolin.question.question1000.question139;
//139. 单词拆分
// 给定一个非空字符串 s 和一个包含非空单词的列表 wordDict，判定 s 是否可以被空格拆分为一个或多个在字典中出现的单词。
//
// 说明：
//
//
// 拆分时可以重复使用字典中的单词。
// 你可以假设字典中没有重复的单词。
//
//
// 示例 1：
//
// 输入: s = "leetcode", wordDict = ["leet", "code"]
//输出: true
//解释: 返回 true 因为 "leetcode" 可以被拆分成 "leet code"。
//
//
// 示例 2：
//
// 输入: s = "applepenapple", wordDict = ["apple", "pen"]
//输出: true
//解释: 返回 true 因为 "applepenapple" 可以被拆分成 "apple pen apple"。
//     注意你可以重复使用字典中的单词。
//
//
// 示例 3：
//
// 输入: s = "catsandog", wordDict = ["cats", "dog", "sand", "and", "cat"]
//输出: false
//
// Related Topics 动态规划

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author liangzi on 2020/10/31
 */
public class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        //状态转移方程 dp[i] = dp[j] + check(s[j,i-1])
        Set<String> wordDictSet = new HashSet<>(wordDict);
        char[] words = s.toCharArray();
        boolean[] dp = new boolean[words.length + 1];
        dp[0] = true;
        for (int i = 1; i <= words.length; i++) {
            for (int j = 0; j < i; j++) {
                String subword = s.substring(j, i);
                if (dp[j] && wordDictSet.contains(subword)) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[words.length];
    }

    public static void main(String[] args) {
        String word = "leetcode";
        List<String> wordDict = Arrays.asList("leet", "code");
        System.out.println(new Solution().wordBreak(word, wordDict));
    }
}

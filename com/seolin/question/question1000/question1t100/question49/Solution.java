package com.seolin.question.question1000.question1t100.question49;
//给定一个字符串数组，将字母异位词组合在一起。字母异位词指字母相同，但排列不同的字符串。
//
// 示例:
//
// 输入: ["eat", "tea", "tan", "ate", "nat", "bat"]
//输出:
//[
//  ["ate","eat","tea"],
//  ["nat","tan"],
//  ["bat"]
//]
//
// 说明：
//
//
// 所有输入均为小写字母。
// 不考虑答案输出的顺序。
//
// Related Topics 哈希表 字符串
// 👍 552 👎 0

import java.util.*;

/**
 * 49. 字母异位词分组
 *
 * @author liangzi on 2020/12/14
 */
public class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<Integer, Map<Character, Integer>> index2CharSetMap = new HashMap<>();
        List<List<String>> resultList = new ArrayList<>();
        int idx = 0;
        for (String str : strs) {
            boolean isContain = false;
            Map<Character, Integer> currentChar2NumMap = getMap(str);
            for (Map.Entry<Integer, Map<Character, Integer>> entry : index2CharSetMap.entrySet()) {
                Integer index = entry.getKey();
                boolean currentIsContain = currentChar2NumMap.equals(entry.getValue());
                if (!currentIsContain) {
                    continue;
                }
                resultList.get(index).add(str);
                isContain = currentIsContain;
                break;
            }
            if (isContain) {
                continue;
            }
            List<String> list = new ArrayList<>();
            list.add(str);
            resultList.add(list);
            index2CharSetMap.put(idx, currentChar2NumMap);
            idx++;
        }
        return resultList;
    }

    public Map<Character, Integer> getMap(String str) {
        Map<Character, Integer> char2NumMap = new HashMap<>();
        for (char c : str.toCharArray()) {
            Integer num = char2NumMap.getOrDefault(c, 0);
            num++;
            char2NumMap.put(c, num);
        }
        return char2NumMap;
    }


    public static void main(String[] args) {
        String[] strs = {"hhhhu", "tttti", "tttit", "hhhuh", "hhuhh", "tittt"};
        System.out.println(new Solution().groupAnagrams(strs));
    }
}

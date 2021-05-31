package com.seolin.alibaba;

import java.util.HashMap;
import java.util.Map;

/**
 * 阿里巴巴笔试题：匹配模式（简单的以字符来写）， 比如 aabb, 来判断该字符串是否符合该模式
 * //有一个字符串它的构成是词+空格的组合，如“北京 杭州 杭州 北京”，
 * //要求输入一个匹配模式（简单的以字符来写）， 比如 aabb, 来判断该字符串是否符合该模式， 举个例子：
 * //1. pattern = “abba”, str=“北京 杭州 杭州 北京” 返回 ture
 * //2. pattern = “aabb”, str=“北京 杭州 杭州 北京” 返回 false
 * //3. pattern = “baab”, str=“北京 杭州 杭州 北京” 返回 ture
 *
 * @author liangzi on 2021/3/16
 */
public class PatternQuestion {

    public boolean wordPattern(String pattern, String str) {
        if (pattern == null || str == null) {
            return false;
        }
        Map<Character, String> pattern2WordMap = new HashMap<>();
        char[] parrerns = pattern.toCharArray();
        String[] strs = str.split(" ");
        if (parrerns.length == 0 || strs.length == 0) {
            return false;
        }
        if (parrerns.length != strs.length) {
            return false;
        }
        if (parrerns.length == 1) {
            return true;
        }
        for (int i = 0; i < parrerns.length; i++) {
            String val = pattern2WordMap.get(parrerns[i]);
            if (val != null) {
                if (!val.equals(strs[i])) {
                    return false;
                }
            } else {
                if (!pattern2WordMap.containsValue(strs[i])) {
                    pattern2WordMap.put(parrerns[i], strs[i]);
                } else {
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        PatternQuestion patternQuestion = new PatternQuestion();
        boolean is = patternQuestion.wordPattern("abba", "北京 杭州 杭州 北京");
        System.out.println(is);
        is = patternQuestion.wordPattern("abba", "北京 beij 杭州 北京");
        System.out.println(is);
    }

}

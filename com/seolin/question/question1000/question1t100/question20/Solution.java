package com.seolin.question.question1000.question1t100.question20;
//给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。
//
// 有效字符串需满足：
//
//
// 左括号必须用相同类型的右括号闭合。
// 左括号必须以正确的顺序闭合。
//
//
// 注意空字符串可被认为是有效字符串。
//
// 示例 1:
//
// 输入: "()"
//输出: true
//
//
// 示例 2:
//
// 输入: "()[]{}"
//输出: true
//
//
// 示例 3:
//
// 输入: "(]"
//输出: false
//
//
// 示例 4:
//
// 输入: "([)]"
//输出: false
//
//
// 示例 5:
//
// 输入: "{[]}"
//输出: true
// Related Topics 栈 字符串

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * 20. 有效的括号
 *
 * @author liangzi on 2020/11/4
 */
public class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack();
        Map<Character, Integer> character2NumMap = new HashMap<>();
        character2NumMap.put('(', 1);
        character2NumMap.put(')', -1);
        character2NumMap.put('{', 2);
        character2NumMap.put('}', -2);
        character2NumMap.put('[', 3);
        character2NumMap.put(']', -3);
        char[] words = s.toCharArray();
        for (int i = 0; i < words.length; i++) {
            if (stack.empty()) {
                stack.add(words[i]);
            } else if (character2NumMap.get(words[i]) < 0) {
                char c = stack.pop();
                if (character2NumMap.get(c) + character2NumMap.get(words[i]) != 0) {
                    stack.add(c);
                    stack.add(words[i]);
                }
            } else {
                stack.add(words[i]);
            }
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        System.out.println(new Solution().isValid("(){}}{"));
//        System.out.println(new Solution().isValid("{[]}"));
    }
}

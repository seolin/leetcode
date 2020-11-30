package com.seolin.question.question1000.question701t800.question767;
//给定一个字符串S，检查是否能重新排布其中的字母，使得两相邻的字符不同。
//
// 若可行，输出任意可行的结果。若不可行，返回空字符串。
//
// 示例 1:
//
//
//输入: S = "aab"
//输出: "aba"
//
//
// 示例 2:
//
//
//输入: S = "aaab"
//输出: ""
//
//
// 注意:
//
//
// S 只包含小写字母并且长度在[1, 500]区间内。
//
// Related Topics 堆 贪心算法 排序 字符串
// 👍 223 👎 0

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 767. 重构字符串
 *
 * @author liangzi on 2020/11/30
 */
public class Solution {
    public String reorganizeString(String S) {
        if (S.length() <= 2) {
            return S;
        }
        int[] count = new int[26];
        int max = 0;
        for (char c : S.toCharArray()) {
            int index = c - 'a';
            count[index]++;
            if (count[index] > max) {
                max = count[index];
            }
        }

        if (max > ((S.length() + 1) / 2)) {
            return "";
        }

        PriorityQueue<Character> queue = new PriorityQueue<>(new Comparator<Character>() {
            @Override
            public int compare(Character o1, Character o2) {
                return -1 * Integer.compare(count[o1 - 'a'], count[o2 - 'a']);
            }
        });

        for (int i = 0; i < 26; i++) {
            if (count[i] > 0) {
                queue.offer((char) (i + 'a'));
            }
        }

        StringBuilder builder = new StringBuilder();
        while (queue.size() > 1) {
            char letterFirst = queue.poll();
            char letterSecond = queue.poll();

            builder.append(letterFirst).append(letterSecond);

            int indexFirst = letterFirst - 'a';
            int indexSecond = letterSecond - 'a';

            count[indexFirst]--;
            count[indexSecond]--;
            if (count[indexFirst] > 0) {
                queue.offer(letterFirst);
            }

            if (count[indexSecond] > 0) {
                queue.offer(letterSecond);
            }
        }
        if (queue.size() > 0) {
            builder.append(queue.poll());
        }
        return builder.toString();
    }
}

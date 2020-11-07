package com.seolin.question.question1000.question101t200.question127;
//给定两个单词（beginWord 和 endWord）和一个字典，找到从 beginWord 到 endWord 的最短转换序列的长度。转换需遵循如下规则：
//
//
//
// 每次转换只能改变一个字母。
// 转换过程中的中间单词必须是字典中的单词。
//
//
// 说明:
//
//
// 如果不存在这样的转换序列，返回 0。
// 所有单词具有相同的长度。
// 所有单词只由小写字母组成。
// 字典中不存在重复的单词。
// 你可以假设 beginWord 和 endWord 是非空的，且二者不相同。
//
//
// 示例 1:
//
// 输入:
//beginWord = "hit",
//endWord = "cog",
//wordList = ["hot","dot","dog","lot","log","cog"]
//
//输出: 5
//
//解释: 一个最短转换序列是 "hit" -> "hot" -> "dot" -> "dog" -> "cog",
//     返回它的长度 5。
//
//
// 示例 2:
//
// 输入:
//beginWord = "hit"
//endWord = "cog"
//wordList = ["hot","dot","dog","lot","log"]
//
//输出: 0
//
//解释: endWord "cog" 不在字典中，所以无法进行转换。
// Related Topics 广度优先搜索

import java.util.*;

/**
 * 127. 单词接龙
 *
 * @author liangzi on 2020/11/5
 */
public class Solution {
    Map<String, Integer> word2wordIdMap = new HashMap<>();
    List<List<Integer>> table = new ArrayList<>();
    int node = 0;

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        for (String word : wordList) {
            addEdge(word);
        }
        if (!word2wordIdMap.containsKey(endWord)) {
            return 0;
        }
        addEdge(beginWord);
        int beginId = word2wordIdMap.get(beginWord);
        int endId = word2wordIdMap.get(endWord);
        Queue<Integer> idQueue = new LinkedList<>();
        idQueue.offer(beginId);
        int[] len = new int[node];
        Arrays.fill(len, Integer.MAX_VALUE);
        len[beginId] = 0;

        while (!idQueue.isEmpty()) {
            int id = idQueue.poll();
            if (endId == id) {
                return len[id] / 2 + 1;
            }
            for (int matchId : table.get(id)) {
                if (len[matchId] == Integer.MAX_VALUE) {
                    len[matchId] = len[id] + 1;
                    idQueue.offer(matchId);
                }
            }
        }
        return 0;
    }

    private void addEdge(String word) {
        addWord(word);
        char[] words = word.toCharArray();
        int id = word2wordIdMap.get(word);
        for (int i = 0; i < words.length; i++) {
            char temp = words[i];
            words[i] = '*';
            String likeWord = new String(words);
            addWord(likeWord);
            int likeId = word2wordIdMap.get(likeWord);
            table.get(id).add(likeId);
            table.get(likeId).add(id);
            words[i] = temp;
        }
    }

    private void addWord(String word) {
        if (!word2wordIdMap.containsKey(word)) {
            word2wordIdMap.put(word, node++);
            table.add(new ArrayList<>());
        }
    }

    public static void main(String[] args) {
        String beginWord = "hit";
        String endWord = "dot";
        List<String> wordList = Arrays.asList("hot", "dot");
        System.out.println(new Solution().ladderLength(beginWord, endWord, wordList));

    }
}

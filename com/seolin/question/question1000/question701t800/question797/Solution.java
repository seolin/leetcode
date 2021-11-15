package com.seolin.question.question1000.question701t800.question797;

import java.util.*;

/**
 * @author liangzi on 2021/8/25
 */
public class Solution {
    int[] visit;
    int n;
    List<List<Integer>> ans = new ArrayList<>();

    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        n = graph.length;
        visit = new int[n];
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            List<Integer> sub = new ArrayList<>();
            for (int j = 0; j < graph[i].length; j++) {
                sub.add(graph[i][j]);
            }
            map.put(i, sub);
        }
        dfs(map, 0, new ArrayList<>());
        return ans;
    }

    public void dfs(Map<Integer, List<Integer>> map, int current, List<Integer> subAns) {
        if (visit[current] == 1) {
            return;
        }
        subAns.add(current);
        visit[current] = 1;
        if (current == (n - 1)) {
            ans.add(subAns);
            visit[current] = 0;
            return;
        }
        List<Integer> next = map.get(current);
        if (next != null && next.size() != 0) {
            for (int nextStep : next) {
                dfs(map, nextStep, new ArrayList<>(subAns));
            }
        }
        visit[current] = 0;
    }

    public static void main(String[] args) {
        int[][] m = {{1, 2}, {3}, {3}, {}};
        System.out.println(Arrays.toString(new Solution().allPathsSourceTarget(m).toArray()));
    }
}

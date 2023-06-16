package com.seolin.question.question1000.question701t800.question710;

import java.util.HashMap;
import java.util.Map;

/**
 * @author chenkangkang
 * @date 2023/6/12
 **/
public class Solution {
    int sz;
    Map<Integer, Integer> map;
    public Solution(int n, int[] blacklist) {
        int sz = n - blacklist.length;
        map = new HashMap<>();
        for (int b : blacklist) {
            map.put(b, 666);
        }
        int last = n - 1;
        for (int b : blacklist) {
            if (b >= sz) {
                continue;
            }
            while (map.containsKey(last)) {
                last--;
            }
            map.put(b, last);
            last--;
        }
    }

    public int pick() {
        int index = (int)(Math.random() * sz);
        if (map.containsKey(index)) {
            return map.get(index);
        }
        return index;
    }

    public static void main(String[] args) {
        Solution solution = new Solution(2, new int[]{});
        System.out.println(solution.pick());
    }
}

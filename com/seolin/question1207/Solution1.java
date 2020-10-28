package com.seolin.question1207;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

/**
 * @author liangzi on 2020/10/28
 */
public class Solution1 {
    public boolean uniqueOccurrences(int[] arr) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>(arr.length);
        for (int i : arr) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }
        return new HashSet<Integer>(map.values()).size() == map.values().size();
    }

    public static void main(String[] args) {
        int[] arr = {-3, 0, 1, -3, 1, 1, 1, -3, 10, 0};
        System.out.println(new Solution1().uniqueOccurrences(arr));
    }

}

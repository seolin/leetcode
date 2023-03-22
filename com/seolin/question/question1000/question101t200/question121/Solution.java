package com.seolin.question.question1000.question101t200.question121;

/**
 * @author chenkangkang
 * @date 2023/3/22 7:23 PM
 **/
public class Solution {
    public int maxProfit(int[] prices) {
        int size = prices.length;
        int[] min = new int[size];
        min[0] = prices[0];
        int max = 0;
        for (int i = 1; i < size; i++) {
            max = Math.max(max, prices[i] - min[i - 1]);
            min[i] = Math.min(prices[i], min[i - 1]);
        }
        return max;
    }

    public static void main(String[] args) {
        int[] pri = {7, 1, 5, 3, 6, 4};
        System.out.println(new Solution().maxProfit(pri));
    }
}

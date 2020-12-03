package com.seolin.question.question1000.question201t300.question204;
//统计所有小于非负整数 n 的质数的数量。
//
//
//
// 示例 1：
//
// 输入：n = 10
//输出：4
//解释：小于 10 的质数一共有 4 个, 它们是 2, 3, 5, 7 。
//
//
// 示例 2：
//
// 输入：n = 0
//输出：0
//
//
// 示例 3：
//
// 输入：n = 1
//输出：0
//
//
//
//
// 提示：
//
//
// 0 <= n <= 5 * 106
//
// Related Topics 哈希表 数学
// 👍 540 👎 0

import java.util.Arrays;

/**
 * 204. 计数质数
 *
 * @author liangzi on 2020/12/3
 */
public class Solution {
    public int countPrimes(int n) {
        int count = 0;
        int[] primes = new int[n];
        //1表示为质数
        Arrays.fill(primes, 1);

        //从2开始，2肯定为质数
        for (int i = 2; i < n; i++) {
            if (primes[i] == 1) {
                count++;
                long doubleSelf = (long) i * i;
                System.out.println(i);
                System.out.println(doubleSelf);
                if (doubleSelf < n) {
                    for (int j = i * i; j < n; j += i) {
                        primes[j] = 0;
                    }
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().countPrimes(499979));
    }
}

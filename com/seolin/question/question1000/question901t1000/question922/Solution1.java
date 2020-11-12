package com.seolin.question.question1000.question901t1000.question922;
//给定一个非负整数数组 A， A 中一半整数是奇数，一半整数是偶数。
//
// 对数组进行排序，以便当 A[i] 为奇数时，i 也是奇数；当 A[i] 为偶数时， i 也是偶数。
//
// 你可以返回任何满足上述条件的数组作为答案。
//
//
//
// 示例：
//
// 输入：[4,2,5,7]
//输出：[4,5,2,7]
//解释：[4,7,2,5]，[2,5,4,7]，[2,7,4,5] 也会被接受。
//
//
//
//
// 提示：
//
//
// 2 <= A.length <= 20000
// A.length % 2 == 0
// 0 <= A[i] <= 1000
//
//
//
// Related Topics 排序 数组
// 👍 153 👎 0

import java.util.Arrays;

/**
 * 922. 按奇偶排序数组 II
 *
 * @author liangzi on 2020/11/12
 */
public class Solution1 {
    public int[] sortArrayByParityII(int[] A) {
        int j = 1;
        int n = A.length;
        for (int i = 0; i < n; i += 2) {
            int num = A[i];
            boolean isValueOdd = isOdd(num);
            if (isValueOdd) {
                while (isOdd(A[j])) {
                    j += 2;
                }
                swap(j, i, A);
            }
        }

        return A;
    }

    private void swap(int i, int location, int[] a) {
        int temp = a[i];
        a[i] = a[location];
        a[location] = temp;
    }

    private boolean isOdd(int num) {
        return (num & 1) == 1;
    }

    public static void main(String[] args) {
        int[] nums = {4, 2, 5, 7};
        System.out.println(Arrays.toString(new Solution1().sortArrayByParityII(nums)));
    }
}

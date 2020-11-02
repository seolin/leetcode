package com.seolin.question.question1000.question501t600.question556;
///给定一个32位正整数 n，你需要找到最小的32位整数，其与 n 中存在的位数完全相同，并且其值大于n。如果不存在这样的32位整数，则返回-1。
//
// 示例 1:
//
//
//输入: 12
//输出: 21
//
//
// 示例 2:
//
//
//输入: 21
//输出: -1
//
// Related Topics 字符串

/**
 * 349. 两个数组的交集
 *
 * @author liangzi on 2020/11/2
 */
public class Solution {
    public int nextGreaterElement(int n) {
        String num = String.valueOf(n);
        char[] numbers = num.toCharArray();
        int i = numbers.length - 2;
        while (i >= 0 && numbers[i + 1] <= numbers[i]) {
            i--;
        }
        if (i < 0) {
            return -1;
        }
        int j = numbers.length - 1;
        while (j > i && numbers[i] >= numbers[j]) {
            j--;
        }
        swap(numbers, i, j);
        revert(numbers, i + 1, numbers.length - 1);
        String nextGreaterElement = "";
        for (char number : numbers) {
            nextGreaterElement += number;
        }
        try {
            return Integer.parseInt(nextGreaterElement);
        } catch (NumberFormatException e) {
            return -1;
        }
    }

    private void revert(char[] numbers, int i, int j) {
        while (i < j) {
            swap(numbers, i, j);
            i++;
            j--;
        }
    }

    private void swap(char[] numbers, int i, int j) {
        char temp = numbers[i];
        numbers[i] = numbers[j];
        numbers[j] = temp;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().nextGreaterElement(11));
    }
}

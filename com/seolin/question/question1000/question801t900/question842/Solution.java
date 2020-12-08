package com.seolin.question.question1000.question801t900.question842;
//给定一个数字字符串 S，比如 S = "123456579"，我们可以将它分成斐波那契式的序列 [123, 456, 579]。
//
// 形式上，斐波那契式序列是一个非负整数列表 F，且满足：
//
//
// 0 <= F[i] <= 2^31 - 1，（也就是说，每个整数都符合 32 位有符号整数类型）；
// F.length >= 3；
// 对于所有的0 <= i < F.length - 2，都有 F[i] + F[i+1] = F[i+2] 成立。
//
//
// 另外，请注意，将字符串拆分成小块时，每个块的数字一定不要以零开头，除非这个块是数字 0 本身。
//
// 返回从 S 拆分出来的任意一组斐波那契式的序列块，如果不能拆分则返回 []。
//
//
//
// 示例 1：
//
// 输入："123456579"
//输出：[123,456,579]
//
//
// 示例 2：
//
// 输入: "11235813"
//输出: [1,1,2,3,5,8,13]
//
//
// 示例 3：
//
// 输入: "112358130"
//输出: []
//解释: 这项任务无法完成。
//
//
// 示例 4：
//
// 输入："0123"
//输出：[]
//解释：每个块的数字不能以零开头，因此 "01"，"2"，"3" 不是有效答案。
//
//
// 示例 5：
//
// 输入: "1101111"
//输出: [110, 1, 111]
//解释: 输出 [11,0,11,11] 也同样被接受。
//
//
//
//
// 提示：
//
//
// 1 <= S.length <= 200
// 字符串 S 中只含有数字。
//
// Related Topics 贪心算法 字符串 回溯算法
// 👍 151 👎 0

import java.util.ArrayList;
import java.util.List;

/**
 * 842. 将数组拆分成斐波那契序列
 *
 * @author liangzi on 2020/12/8
 */
public class Solution {
    //通过回溯 + 减枝 来实现
    public List<Integer> splitIntoFibonacci(String S) {
        List<Integer> resultList = new ArrayList<>();
        backtrack(resultList, S, S.length(), 0, 0, 0);
        return resultList;
    }
    public boolean backtrack(List<Integer> resultList, String S, int length, int index, int sum, int prev) {
        //回溯最终识别条件：已经到最后一个
        if (index == length) {
            return resultList.size() > 2;
        }
        long currentCount = 0;
        for (int i = index; i < length; i++) {
            //减枝条件：如果数组长度大于1，则第一位不能为空
            if (i > index && S.charAt(index) == '0') {
                break;
            }
            currentCount = currentCount * 10 + S.charAt(i) - '0';
            if (resultList.size() > 1) {
                //如果前两位总和大于当前数，则当前数继续循环变大
                if (sum > currentCount) {
                    continue;
                    //减枝条件：如果前两位总和小于当前树，则说明不符合要求
                } else if (currentCount > sum) {
                    break;
                }
            }
            resultList.add((int)currentCount);
            if (backtrack(resultList, S, length, i + 1 ,(int)(prev + currentCount), (int)currentCount)) {
                return true;
            } else {
                resultList.remove(resultList.size() - 1);
            }
        }
        return false;
    }


}

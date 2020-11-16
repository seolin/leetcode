package com.seolin.question.question1000.question401t500.question406;
//假设有打乱顺序的一群人站成一个队列。 每个人由一个整数对(h, k)表示，其中h是这个人的身高，k是排在这个人前面且身高大于或等于h的人数。 编写一个算法来
//重建这个队列。
//
// 注意：
//总人数少于1100人。
//
// 示例
//
//
//输入:
//[[7,0], [4,4], [7,1], [5,0], [6,1], [5,2]]
//
//输出:
//[[5,0], [7,0], [5,2], [6,1], [4,4], [7,1]]
//
// Related Topics 贪心算法
// 👍 639 👎 0

import java.util.Arrays;
import java.util.LinkedList;

/**
 * 406. 根据身高重建队列
 *
 * @author liangzi on 2020/11/16
 */
public class Solution {
    public int[][] reconstructQueue(int[][] people) {
        Arrays.sort(people, (source, target) -> source[0] != target[0] ? Integer.compare(source[0], target[0]) * -1 : Integer.compare(source[1], target[1]));

        LinkedList<int[]> arr = new LinkedList<>();

        for (int[] person : people) {
            arr.add(person[1], person);
        }
        return arr.toArray(new int[people.length][2]);
    }

    public static void main(String[] args) {
        int[][] people = {{7, 0}, {4, 4}, {7, 1}, {5, 0}, {6, 1}, {5, 2}};
        System.out.println(Arrays.deepToString(new Solution().reconstructQueue(people)));
    }
}

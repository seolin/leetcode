package com.seolin.question.question2000.question1122;
//给你两个数组，arr1 和 arr2，
//
//
// arr2 中的元素各不相同
// arr2 中的每个元素都出现在 arr1 中
//
//
// 对 arr1 中的元素进行排序，使 arr1 中项的相对顺序和 arr2 中的相对顺序相同。未在 arr2 中出现过的元素需要按照升序放在 arr1 的末
//尾。
//
//
//
// 示例：
//
// 输入：arr1 = [2,3,1,3,2,4,6,7,9,2,19], arr2 = [2,1,4,3,9,6]
//输出：[2,2,2,1,4,3,3,9,6,7,19]
//
//
//
//
// 提示：
//
//
// arr1.length, arr2.length <= 1000
// 0 <= arr1[i], arr2[i] <= 1000
// arr2 中的元素 arr2[i] 各不相同
// arr2 中的每个元素 arr2[i] 都出现在 arr1 中
//
// Related Topics 排序 数组
// 👍 138 👎 0

import java.util.*;

/**
 * 1122. 数组的相对排序
 *
 * @author liangzi on 2020/11/14
 */
public class Solution {
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        Map<Integer, Integer> num2IndexMap = new HashMap<>();
        for (int i = 0; i < arr2.length; i++) {
            num2IndexMap.put(arr2[i], i);
        }
        List<Integer> arr1List = new ArrayList<>(arr1.length);
        for (int i : arr1) {
            arr1List.add(i);
        }
        arr1List.sort((source, target) -> {
            Integer sourceLocation = num2IndexMap.get(source);
            Integer targetLocation = num2IndexMap.get(target);
            if (sourceLocation == null && targetLocation == null) {
                return Integer.compare(source, target);
            } else if (targetLocation == null) {
                return -1;
            } else if (sourceLocation == null) {
                return 1;
            } else {
                return Integer.compare(sourceLocation, targetLocation);
            }
        });
        for (int i = 0; i < arr1.length; i++) {
            arr1[i] = arr1List.get(i);
        }
        return arr1;
    }

    public static void main(String[] args) {
        // 输入：arr1 = [2,3,1,3,2,4,6,7,9,2,19], arr2 = [2,1,4,3,9,6]
        // 输出：[2,2,2,1,4,3,3,9,6,7,19]
        int[] arr1 = {2, 3, 1, 3, 2, 4, 6, 7, 9, 2, 19};
        int[] arr2 = {2, 1, 4, 3, 9, 6};
        System.out.println(Arrays.toString(new Solution().relativeSortArray(arr1, arr2)));
    }
}

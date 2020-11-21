package com.seolin.question.question1000.question101t200.question148;
//给你链表的头结点 head ，请将其按 升序 排列并返回 排序后的链表 。
//
// 进阶：
//
//
// 你可以在 O(n log n) 时间复杂度和常数级空间复杂度下，对链表进行排序吗？
//
//
//
//
// 示例 1：
//
//
//输入：head = [4,2,1,3]
//输出：[1,2,3,4]
//
//
// 示例 2：
//
//
//输入：head = [-1,5,3,4,0]
//输出：[-1,0,3,4,5]
//
//
// 示例 3：
//
//
//输入：head = []
//输出：[]
//
//
//
//
// 提示：
//
//
// 链表中节点的数目在范围 [0, 5 * 104] 内
// -105 <= Node.val <= 105
//
// Related Topics 排序 链表
// 👍 863 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode() {}
 * ListNode(int val) { this.val = val; }
 * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

/**
 * 148. 排序链表
 * 自底向上
 *
 * @author liangzi on 2020/11/21
 */
public class Solution1 {
    public ListNode sortList(ListNode head) {
        //自底向上的归并排序
        //先算出链表的长度
        int length = 0;
        ListNode countLengthNode = head;
        while (countLengthNode != null) {
            countLengthNode = countLengthNode.next;
            length++;
        }
        ListNode dummyHead = new ListNode(0, head);

        //再将链表分隔成子串，对子串进行合并，子串大小从1，2，4一直增加，直到子串大小超过链表长度
        for (int subListLength = 1; subListLength < length; subListLength <<= 1) {
            ListNode prev = dummyHead, current = dummyHead.next;
            while (current != null) {
                ListNode source = current;
                for (int i = 1; i < subListLength && current.next != null; i++) {
                    current = current.next;
                }
                ListNode target = current.next;
                current.next = null;
                current = target;
                for (int i = 1; i < subListLength && current != null && current.next != null; i++) {
                    current = current.next;
                }
                ListNode next = null;
                if (current != null) {
                    next = current.next;
                    current.next = null;
                }
                ListNode merge = mergeList(source, target);
                prev.next = merge;
                while (prev.next != null) {
                    prev = prev.next;
                }
                current = next;
            }
        }
        return dummyHead.next;
    }

    //有序链表合并
    public ListNode mergeList(ListNode source, ListNode target) {
        if (source == null) {
            return target;
        }
        if (target == null) {
            return source;
        }
        ListNode dummyHead = new ListNode(0);
        ListNode current = dummyHead;

        while (source != null && target != null) {
            if (source.val <= target.val) {
                current.next = source;
                source = source.next;
            } else {
                current.next = target;
                target = target.next;
            }
            current = current.next;
        }
        if (source != null) {
            current.next = source;
        }
        if (target != null) {
            current.next = target;
        }
        return dummyHead.next;
    }
}

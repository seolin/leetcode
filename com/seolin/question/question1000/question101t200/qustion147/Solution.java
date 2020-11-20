package com.seolin.question.question1000.question101t200.qustion147;
//对链表进行插入排序。
//
//
//插入排序的动画演示如上。从第一个元素开始，该链表可以被认为已经部分排序（用黑色表示）。
//每次迭代时，从输入数据中移除一个元素（用红色表示），并原地将其插入到已排好序的链表中。
//
//
//
// 插入排序算法：
//
//
// 插入排序是迭代的，每次只移动一个元素，直到所有元素可以形成一个有序的输出列表。
// 每次迭代中，插入排序只从输入数据中移除一个待排序的元素，找到它在序列中适当的位置，并将其插入。
// 重复直到所有输入数据插入完为止。
//
//
//
//
// 示例 1：
//
// 输入: 4->2->1->3
//输出: 1->2->3->4
//
//
// 示例 2：
//
// 输入: -1->5->3->4->0
//输出: -1->0->3->4->5
//
// Related Topics 排序 链表
// 👍 304 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode(int x) { val = x; }
 * }
 */

/**
 * 147. 对链表进行插入排序
 *
 * @author liangzi on 2020/11/20
 */
public class Solution {
    public ListNode insertionSortList(ListNode head) {
        //判空
        if (head == null) {
            return head;
        }
        //虚拟的头节点
        ListNode dummyHead = new ListNode(0);
        dummyHead.next = head;
        //当前正在排序的节点
        ListNode current = head.next;
        //已经排好序的最后一个节点
        ListNode sortNode = head;
        while (current != null) {
            //如果当前节点比已经排好序的最后一个节点大，则不需要改变位置
            if (current.val >= sortNode.val) {
                sortNode = sortNode.next;
            } else {
                //从头开始找，找到第一个比当前节点大的前一个节点
                ListNode pre = dummyHead;
                while(pre.next.val <= current.val) {
                    pre = pre.next;
                }
                //把排好序的节点的下一个指针指向下一个需要排序的节点
                sortNode.next = current.next;
                //开始将当前节点插入对应位置
                current.next = pre.next;
                pre.next = current;
            }
            current = sortNode.next;
        }
        return dummyHead.next;
    }
}

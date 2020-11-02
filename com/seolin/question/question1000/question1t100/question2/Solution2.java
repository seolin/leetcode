package com.seolin.question.question1000.question1t100.question2;

/**
 * @Author: kangkangchen
 * @Description: 2.两数相加
 * 给定两个非空链表来表示两个非负整数。位数按照逆序方式存储，它们的每个节点只存储单个数字。将两数相加返回一个新的链表。
 * 你可以假设除了数字 0 之外，这两个数字都不会以零开头。
 * 示例：输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
 * 输出：7 -> 0 -> 8
 * 原因：342 + 465 = 807
 * @Date: 10:14 AM 4/25/2018
 */
public class Solution2 {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int carry = 0;
        return new ListNode(1);
    }

    public static void main(String[] args) {
//        //(2 -> 4 -> 3) + (5 -> 6 -> 4)
//        ListNode l11 = new ListNode(2);
//        ListNode l12 = new ListNode(4);
//        ListNode l13 = new ListNode(3);
//        l11.next = l12;
//        l12.next = l13;
//
//        ListNode l21 = new ListNode(5);
//        ListNode l22 = new ListNode(6);
//        ListNode l23 = new ListNode(4);
//
//        l21.next = l22;
//        l22.next = l23;
//[9]
//[1,9,9,9,9,9,9,9,9,9]
        ListNode l11 = new ListNode(9);

        ListNode l21 = new ListNode(1);
        ListNode l22 = new ListNode(9);
        ListNode l23 = new ListNode(9);
        ListNode l24 = new ListNode(9);
        ListNode l25 = new ListNode(9);
        ListNode l26 = new ListNode(9);
        ListNode l27 = new ListNode(9);
        ListNode l28 = new ListNode(9);
        ListNode l29 = new ListNode(9);
        ListNode l210 = new ListNode(9);

        l21.next = l22;
        l22.next = l23;
        l23.next = l24;
        l24.next = l25;
        l25.next = l26;
        l26.next = l27;
        l27.next = l28;
        l28.next = l29;
        l29.next = l210;
        ListNode result = new Solution2().addTwoNumbers(l11, l21);
        while (result != null) {
            System.out.println(result.val);
            result = result.next;
        }
    }
}

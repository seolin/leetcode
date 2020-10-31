package com.seolin.question.question1000.question2;

/**
 * @Author: kangkangchen
 * @Description: 两数相加
 * 给定两个非空链表来表示两个非负整数。位数按照逆序方式存储，它们的每个节点只存储单个数字。将两数相加返回一个新的链表。
 * 你可以假设除了数字 0 之外，这两个数字都不会以零开头。
 * 示例：输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
 * 输出：7 -> 0 -> 8
 * 原因：342 + 465 = 807
 * @Date: 10:14 AM 4/25/2018
 */
public class Solution2 {
    public static void main(String[] args) {
        ListNode l11 = new ListNode(2);
        ListNode l1 = l11;
        l1.next = new ListNode(2);
        l1 = l1.next;
        l1.next = new ListNode(4);
        l1 = l1.next;
        l1.next = new ListNode(3);
        l1 = l1.next;
        ListNode l22 = new ListNode(5);
        ListNode l2 = l22;
        l2.next = new ListNode(5);
        l2 = l2.next;
        l2.next = new ListNode(6);
        l2 = l2.next;
        l2.next = new ListNode(4);
        l2 = l2.next;
        ListNode result = addTwoNumbers(l11.next, l22.next);
        while ( result != null){
            System.out.println(result.val);
            result = result.next;
        }
    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode listNode = new ListNode(0);
        ListNode point = listNode;
        int carry = 0;
        while (l1 != null || l2 != null) {
            int temp = 0;
            if (l1 != null) {
                temp += l1.val;
                l1 = l1.next;
            }
            if (l2 != null) {
                temp += l2.val;
                l2 = l2.next;
            }
            temp += carry;
            point.next = new ListNode(temp % 10);
            carry = temp / 10;
            point = point.next;
        }
        if(carry !=0){
            point.next = new ListNode(carry);
        }
        return listNode.next;
    }


}

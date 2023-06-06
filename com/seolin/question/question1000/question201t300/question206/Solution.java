package com.seolin.question.question1000.question201t300.question206;

import com.seolin.question.question1000.question101t200.question102.Solution2;

/**
 * @author chenkangkang
 * @date 2023/6/2
 **/
public class Solution {
    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode cur = reverseList(head.next);
        cur.next = head;
        head.next = null;
        return cur;
    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        ListNode result = new Solution().reverseList(node1);
        while (result != null) {
            System.out.println(result.val);
            result = result.next;
        }
    }
}

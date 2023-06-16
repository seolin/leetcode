package com.seolin.question.question1000.question1t100.question25;


/**
 * @author chenkangkang
 * @date 2023/6/16
 **/
public class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode a = head, b = head;
        for (int i = 0; i < k; i++) {
            if (b == null) {
                return head;
            }
            b = b.next;
        }
        ListNode node = reverse(a, b);
        a.next = reverseKGroup(b, k);
        return node;
    }

    public ListNode reverse(ListNode a, ListNode b) {
        ListNode pre = null;
        ListNode cur = a;
        while (cur != b) {
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }


}

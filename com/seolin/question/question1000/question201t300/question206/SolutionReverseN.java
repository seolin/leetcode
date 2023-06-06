package com.seolin.question.question1000.question201t300.question206;

/**
 * @author chenkangkang
 * @date 2023/6/2
 **/
public class SolutionReverseN {
    ListNode tail = null;

    public ListNode reverseN(ListNode head, int n) {
        if (n == 1) {
            tail = head.next;
            return head;
        }
        ListNode cur = reverseN(head.next, n - 1);
        head.next.next = head;
        head.next = tail;
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
        ListNode result = new SolutionReverseN().reverseN(node1, 3);
        while (result != null) {
            System.out.println(result.val);
            result = result.next;
        }
    }
}

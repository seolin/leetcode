package com.seolin.question.question1000.question201t300.question234;

/**
 * @author chenkangkang
 * @date 2023/6/16
 **/
public class Solution {

    public boolean isPalindrome(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        if (fast != null) {
            slow = slow.next;
        }
        ListNode left = head;
        ListNode right = reverse(slow);
        while (right != null) {
            if (left.val == right.val) {
                left = left.next;
                right = right.next;
            } else {
                return false;
            }
        }
        return true;
    }
    public ListNode reverse(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode cur = reverse(head.next);
        head.next.next = head;
        head.next = null;
        return cur;
    }
}

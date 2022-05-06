package com.seolin.beat.t206;

/**
 * @author chenkangkang
 * @date 2022/5/6 11:25 AM
 **/
public class T206 {
    public ListNode reverseList(ListNode head) {
        ListNode pre = null;
        ListNode cur = head;
        while (cur != null) {
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }
}

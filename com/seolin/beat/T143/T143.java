package com.seolin.beat.T143;
//给定一个单链表 L 的头节点 head ，单链表 L 表示为：
//
//
//L0 → L1 → … → Ln - 1 → Ln
//
//
// 请将其重新排列后变为：
//
//
//L0 → Ln → L1 → Ln - 1 → L2 → Ln - 2 → …
//
// 不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
//
//
//
// 示例 1：
//
//
//
//
//输入：head = [1,2,3,4]
//输出：[1,4,2,3]
//
// 示例 2：
//
//
//
//
//输入：head = [1,2,3,4,5]
//输出：[1,5,2,4,3]
//
//
//
// 提示：
//
//
// 链表的长度范围为 [1, 5 * 10⁴]
// 1 <= node.val <= 1000
//
// Related Topics 栈 递归 链表 双指针 👍 897 👎 0


//leetcode submit region begin(Prohibit modification and deletion)

/**
 * @author chenkangkang
 * @date 2022/5/7 5:52 PM
 **/
public class T143 {
    public void reorderList(ListNode head) {
        //1. 快慢指针找中点
        //2. 反转中点之后的数据
        //3. 通过临时记住下一个节点来
        if (head == null) {
            return;
        }
        ListNode fast = head;
        ListNode slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        ListNode next = slow.next;
        slow.next = null;
        ListNode l2 = reverse(next);
        ListNode l1 = head;
        while (l2 != null) {
            ListNode next1 = l1.next;
            ListNode next2 = l2.next;
            l1.next = l2;
            l2.next = next1;
            l2 = next2;
            l1 = next1;
        }
    }

    private ListNode reverse(ListNode node) {
        ListNode pre = null;
        ListNode cur = node;
        while (cur != null) {
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }
}

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
 * 自顶向下
 *
 * @author liangzi on 2020/11/21
 */
public class Solution2 {
    public ListNode sortList(ListNode head) {
        //自顶向下，常规归并算法
        return sortList(head, null);
    }

    public ListNode sortList(ListNode head, ListNode tail) {

        //判空
        if (head == null) {
            return head;
        }
        if (head.next == tail){
            //将head独立出来
            head.next = null;
            return head;
        }
        //通过快慢指针找中点
        ListNode slow = head, fast = head;
        while (fast != tail) {
            slow = slow.next;
            fast = fast.next;
            if (fast != tail) {
                fast = fast.next;
            }
        }
        ListNode mid = slow;
        //mid是算作下一个组的，不在这这个组里面排序
        ListNode source = sortList(head, mid);
        ListNode target = sortList(mid, tail);
        ListNode merge = mergeList(source, target);
        return merge;
    }

    //有序链表合并
    public ListNode mergeList(ListNode sor, ListNode tar) {
        ListNode source = sor;
        ListNode target = tar;
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
        } else if (target != null) {
            current.next = target;
        }
        return dummyHead.next;
    }
}

package com.seolin.question.question1000.question201t300.question234;


/**
 * @author chenkangkang
 * @date 2023/6/16
 **/
public class Main {

    public static void main(String[] args) {
        String param = "[1,2,2,1]";
        ListNode head = build(param);
        boolean isTrue = new Solution().isPalindrome(head);
        System.out.println(isTrue);
    }

    private static String sout(ListNode listNode) {
        StringBuilder builder = new StringBuilder();
        builder.append("[");
        while (listNode != null) {
            builder.append(listNode.val).append(",");
            listNode = listNode.next;
        }
        return builder.substring(0, builder.length() - 1) + "]";
    }

    private static ListNode build(String param) {
        String substring = param.substring(1, param.length() - 1);
        String[] split = substring.split(",");
        ListNode dummyHead = new ListNode();
        ListNode cur = dummyHead;
        for (int i = 0; i < split.length; i++) {
            cur.next = new ListNode(Integer.parseInt(split[i]));
            cur = cur.next;
        }
        return dummyHead.next;
    }
}

package com.seolin.question.question1000.question201t300.question230;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.concurrent.LinkedBlockingDeque;

/**
 * @author chenkangkang
 * @date 2023/2/3 4:27 PM
 **/
public class Solution2 {
    public int kthSmallest(TreeNode root, int k) {
        Deque<TreeNode> deque = new ArrayDeque<>();
        while (root != null || !deque.isEmpty()) {
            while (root != null) {
                deque.addLast(root);
                root = root.left;
            }
            root = deque.pollLast();
            if (--k == 0) {
                return root.val;
            }
            root = root.right;
        }
        return -1;
    }
}

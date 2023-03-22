package com.seolin.question.question1000.question201t300.question230;

import java.util.Deque;
import java.util.concurrent.LinkedBlockingDeque;

/**
 * @author chenkangkang
 * @date 2023/2/3 4:27 PM
 **/
public class Solution1 {
    int ans, k;

    public int kthSmallest(TreeNode root, int _k) {
        //二叉搜索树是有序的，根据左节点比根节点小，右节点比根节点打
        //使用中序遍历，找到对应k值
        k = _k;
        dfs(root);
        return ans;
    }

    private void dfs(TreeNode root) {
        if (root == null || k <= 0) {
            return;
        }
        dfs(root.left);
        if (--k == 0) {
            ans = root.val;
            return;
        }
        dfs(root.right);
    }
}

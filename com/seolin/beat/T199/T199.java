package com.seolin.beat.T199;

import java.util.ArrayList;
import java.util.List;

/**
 * @author chenkangkang
 * @date 2022/5/10 11:05 AM
 **/
public class T199 {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> ansList = new ArrayList<>();
        dfs(root, ansList, 0);
        return ansList;
    }

    private void dfs(TreeNode root, List<Integer> ansList, int deep) {
        if (root == null) {
            return;
        }
        if (deep == ansList.size()) {
            ansList.add(root.val);
        }
        dfs(root.right, ansList, deep + 1);
        dfs(root.left, ansList, deep + 1);
    }
}

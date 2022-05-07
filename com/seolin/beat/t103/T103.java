package com.seolin.beat.t103;


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author chenkangkang
 * @date 2022/5/6 11:34 AM
 **/
public class T103 {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> ansList = new ArrayList<>();
        preOrder(ansList, root, 0);
        return ansList;
    }

    /**
     * dfs
     * 1. 通过level来判断当前元素需要在的数组
     * 2. 通过level来判断需要往头添加还是往尾添加
     */

    private void preOrder(List<List<Integer>> ansList, TreeNode root, int level) {
        if (root == null) {
            return;
        }
        if (ansList.size() <= level) {
            List<Integer> newAnsList = new LinkedList<>();
            ansList.add(newAnsList);
        }
        List<Integer> subAnsList = ansList.get(level);
        if (level % 2 == 0) {
            subAnsList.add(root.val);
        } else {
            subAnsList.add(0, root.val);
        }
        preOrder(ansList, root.left, level + 1);
        preOrder(ansList, root.right, level + 1);
    }
}



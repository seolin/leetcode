package com.seolin.question.question1000.question101t200.question102;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author chenkangkang
 * @date 2023/5/25
 **/
public class Solution2 {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> resultList = new ArrayList<>();
        if (root == null) {
            return resultList;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            List<Integer> subResultList = new ArrayList<>();
            List<TreeNode> nextList = new ArrayList<>();
            while(!queue.isEmpty()) {
                TreeNode node = queue.poll();
//                if (node == null) {
//                    break;
//                }
                subResultList.add(node.val);
                if (node.left != null) {
                    nextList.add(node.left);
                }
                if (node.right != null) {
                    nextList.add(node.right);
                }
            }
            for (TreeNode node : nextList) {
                queue.add(node);
            }
            resultList.add(subResultList);
        }
        return resultList;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        TreeNode node1 = new TreeNode(9);
        TreeNode node2 = new TreeNode(20);
        TreeNode node3 = new TreeNode(15);
        TreeNode node4 = new TreeNode(7);
        root.left = node1;
        root.right = node2;
        node2.left = node3;
        node2.right = node4;
        System.out.println(new Solution2().levelOrder(root));
    }
}

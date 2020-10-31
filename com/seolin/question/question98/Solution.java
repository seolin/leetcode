package com.seolin.question.question98;
// 98. 验证二叉搜索树
// 给定一个二叉树，判断其是否是一个有效的二叉搜索树。
//
// 假设一个二叉搜索树具有如下特征： 
//
// 
// 节点的左子树只包含小于当前节点的数。 
// 节点的右子树只包含大于当前节点的数。 
// 所有左子树和右子树自身必须也是二叉搜索树。 
// 
//
// 示例 1: 
//
// 输入:
//    2
//   / \
//  1   3
//输出: true
// 
//
// 示例 2: 
//
// 输入:
//    5
//   / \
//  1   4
//     / \
//    3   6
//输出: false
//解释: 输入为: [5,1,4,null,null,3,6]。
//     根节点的值为 5 ，但是其右子节点值为 4 。
// 
// Related Topics 树 深度优先搜索 

import java.util.ArrayList;
import java.util.List;

/**
 * @author liangzi on 2020/10/31
 */
public class Solution {
    public boolean isValidBST(TreeNode root) {
        List<Integer> tree = new ArrayList<>();
        inOrder(root, tree);
        for (int i = 1; i < tree.size(); i++) {
            if (tree.get(i) <= tree.get(i - 1)) {
                return false;
            }
        }
        return true;
    }

    private void inOrder(TreeNode root, List<Integer> tree) {
        if (root == null) {
            return;
        }
        inOrder(root.left, tree);
        tree.add(root.val);
        inOrder(root.right, tree);
    }

    public static void main(String[] args) {
//        int[] tree = {5, 1, 4, 3, 6};
//        TreeNode root = new TreeNode(tree[0]);
//        TreeNode treeNode1 = new TreeNode(tree[1]);
//        TreeNode treeNode2 = new TreeNode(tree[2]);
//        TreeNode treeNode3 = new TreeNode(tree[3]);
//        TreeNode treeNode4 = new TreeNode(tree[4]);
//
//        root.left = treeNode1;
//        root.right = treeNode2;
//
//        treeNode2.left = treeNode3;
//        treeNode2.right = treeNode4;
//
//        System.out.println(new Solution().isValidBST(root));


        int[] tree = {1, 1};
        TreeNode root = new TreeNode(tree[0]);
        TreeNode treeNode1 = new TreeNode(tree[1]);

        root.left = treeNode1;
        System.out.println(new Solution().isValidBST(root));
    }
}

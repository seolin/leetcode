package com.seolin.question.question1000.question101t200.question129;
//给定一个二叉树，它的每个结点都存放一个 0-9 的数字，每条从根到叶子节点的路径都代表一个数字。
//
// 例如，从根到叶子节点路径 1->2->3 代表数字 123。
//
// 计算从根到叶子节点生成的所有数字之和。
//
// 说明: 叶子节点是指没有子节点的节点。
//
// 示例 1:
//
// 输入: [1,2,3]
//    1
//   / \
//  2   3
//输出: 25
//解释:
//从根到叶子节点路径 1->2 代表数字 12.
//从根到叶子节点路径 1->3 代表数字 13.
//因此，数字总和 = 12 + 13 = 25.
//
// 示例 2:
//
// 输入: [4,9,0,5,1]
//    4
//   / \
//  9   0
// / \
//5   1
//输出: 1026
//解释:
//从根到叶子节点路径 4->9->5 代表数字 495.
//从根到叶子节点路径 4->9->1 代表数字 491.
//从根到叶子节点路径 4->0 代表数字 40.
//因此，数字总和 = 495 + 491 + 40 = 1026.
// Related Topics 树 深度优先搜索
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode(int x) { val = x; }
 * }
 */


/**
 * @author liangzi on 2020/10/29
 */

class Solution {
    public int sumNumbers(TreeNode root) {
        return preOrder(root, 0);
    }

    public int preOrder(TreeNode root, int sum) {
        if (root == null) {
            return 0;
        }
        sum = sum * 10 + root.val;
        if (root.left == null && root.right == null) {
            return sum;
        } else {
            return preOrder(root.left, sum) + preOrder(root.right, sum);
        }
    }


    public static void main(String[] args) {
        int[] tree = {4, 9, 0, 5, 1};
        TreeNode root = new TreeNode(tree[0]);
        TreeNode treeNode1 = new TreeNode(tree[1]);
        TreeNode treeNode2 = new TreeNode(tree[2]);
        TreeNode treeNode3 = new TreeNode(tree[3]);
        TreeNode treeNode4 = new TreeNode(tree[4]);
        TreeNode treeNode6 = new TreeNode(6);
        TreeNode treeNode7 = new TreeNode(7);

        root.left = treeNode1;
        root.right = treeNode2;

        treeNode1.left = treeNode3;
        treeNode1.right = treeNode4;

        System.out.println(new Solution().sumNumbers(root));
    }

}
package com.seolin.offer;

import java.util.HashMap;
import java.util.Map;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode(int x) { val = x; }
 * }
 */
public class Offer07 {

    int[] preorder = null;
    Map<Integer, Integer> num2IndexMap = new HashMap<>();

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        this.preorder = preorder;
        for (int i = 0; i < inorder.length; i++) {
            num2IndexMap.put(inorder[i], i);
        }
        return recur(0, 0, inorder.length - 1);
    }

    private TreeNode recur(int root, int left, int right) {
        if (left > right) {
            return null;
        }
        TreeNode treeNode = new TreeNode(preorder[root]);
        int i = num2IndexMap.get(preorder[root]);
        treeNode.left = recur(root + 1, left, i - 1);
        treeNode.right = recur(root + i - left + 1, i + 1, right);
        return treeNode;
    }

    /**
     * Input: preorder = [3,9,20,15,7], inorder = [9,3,15,20,7]
     * Output: [3,9,20,null,null,15,7]
     * <p
     *
     * @param args
     */
    public static void main(String[] args) {
        int[] preorder = {3, 9, 20, 15, 7};
        int[] inorder = {9, 3, 15, 20, 7};
        TreeNode node = new Offer07().buildTree(preorder, inorder);
        System.out.println(node);
    }
}
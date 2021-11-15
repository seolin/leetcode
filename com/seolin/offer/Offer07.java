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

    //保留前序遍历
    int[] preorder = null;
    //记录中序遍历
    Map<Integer, Integer> num2IndexMap = new HashMap<>();

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        this.preorder = preorder;
        for (int i = 0; i < inorder.length; i++) {
            num2IndexMap.put(inorder[i], i);
        }
        //当前树在preorder根节点索引
        //递归树在inorder左边界
        //递归树在inorder右边界
        return recur(0, 0, inorder.length - 1);
    }

    private TreeNode recur(int root, int left, int right) {
        //左边界超过右边界，说明到头了
        if (left > right) {
            return null;
        }
        //获取root节点
        TreeNode treeNode = new TreeNode(preorder[root]);
        //获取root节点在inorder中的所以，以方便获取左右子树的边界
        int i = num2IndexMap.get(preorder[root]);
        //左子树的根节点索引，为前序遍历中当前根节点索引 + 1
        //左子树的左子树边界为原来中序的索引
        //左子树的柚子树边界中序中的根节点索引 - 1
        treeNode.left = recur(root + 1, left, i - 1);

        //(i - left) 为左子树长度
        // root + 1 为左子树在前序遍历中的索引
        // i + 1 是中序遍历中，右子树的左子树边界  中序遍历示意图 ： | 左子树 | 根节点 | 右子树 |， 这边的右子树，就是当前根节点右子树的右子树边界
        treeNode.right = recur((i - left ) + (root + 1) , i + 1, right);
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
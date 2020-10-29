package com.seolin.base.tree.search;


/**
 * @author liangzi on 2020/10/29
 */
public class TreeTest {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        TreeNode treeNode1 = new TreeNode(5);
        TreeNode treeNode2 = new TreeNode(1);
        TreeNode treeNode3 = new TreeNode(6);
        TreeNode treeNode4 = new TreeNode(2);
        TreeNode treeNode5 = new TreeNode(7);
        TreeNode treeNode6 = new TreeNode(4);
        TreeNode treeNode7 = new TreeNode(0);
        TreeNode treeNode8 = new TreeNode(8);

        root.left = treeNode1;
        root.right = treeNode2;

        treeNode1.left = treeNode3;
        treeNode1.right = treeNode4;

        treeNode2.left = treeNode7;
        treeNode2.right = treeNode8;

        treeNode4.left = treeNode5;
        treeNode4.right = treeNode6;

        TreeSearch treeSearch = new TreeSearch();
        treeSearch.postOrder(root);
    }
}

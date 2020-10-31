package com.seolin.question.question1000.question236;
//236. 二叉树的最近公共祖先
// 给定一个二叉树, 找到该树中两个指定节点的最近公共祖先。
//
// 百度百科中最近公共祖先的定义为：“对于有根树 T 的两个结点 p、q，最近公共祖先表示为一个结点 x，满足 x 是 p、q 的祖先且 x 的深度尽可能大（
//一个节点也可以是它自己的祖先）。”
//
// 例如，给定如下二叉树: root = [3,5,1,6,2,0,8,null,null,7,4]
//
//
//
//
//
// 示例 1:
//
// 输入: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 1
//输出: 3
//解释: 节点 5 和节点 1 的最近公共祖先是节点 3。
//
//
// 示例 2:
//
// 输入: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 4
//输出: 5
//解释: 节点 5 和节点 4 的最近公共祖先是节点 5。因为根据定义最近公共祖先节点可以为节点本身。
//
//
//
//
// 说明:
//
//
// 所有节点的值都是唯一的。
// p、q 为不同节点且均存在于给定的二叉树中。
//
// Related Topics 树

/**
 * @author liangzi on 2020/10/29
 */
public class Solution {
    TreeNode ans = null;

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        dfs(root, p, q);
        return ans;
    }

    private boolean dfs(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return false;
        }
        boolean leftContain = dfs(root.left, p, q);
        boolean rightContain = dfs(root.right, p, q);
        if ((leftContain && rightContain) || ((leftContain || rightContain) && (root.val == p.val || root.val == q.val))) {
            ans = root;
        }
        return leftContain || rightContain || root.val == p.val || root.val == q.val;
    }

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
        System.out.println(new Solution().lowestCommonAncestor(root, treeNode3, treeNode5).val);
    }

}

package com.seolin.battle;

/**
 * @author chenkangkang
 * @date 2022/5/8 10:15 AM
 **/
public class T2 {
    int ans = 0;

    public int averageOfSubtree(TreeNode root) {
        dfs(root);
        return ans;
    }

    private int[] dfs(TreeNode root) {
        if (root == null) {
            return new int[2];
        }
        int[] left = dfs(root.left);
        int[] right = dfs(root.right);
        int count = left[0] + right[0] + root.val;
        int sum = left[1] + right[1] + 1;
        if ((count / sum) == root.val) {
            ans++;
        }
        return new int[]{count, sum};
    }
}

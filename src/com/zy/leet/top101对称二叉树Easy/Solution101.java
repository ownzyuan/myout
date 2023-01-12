package com.zy.leet.top101对称二叉树Easy;

public class Solution101 {

    public static void main(String[] args) {

    }

    public static boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }
        return dfs(root.left, root.right);
    }

    /**
     * 通过递归，逐一对比，从当前节点的最左节点和最右节点到的值是否相同
     * @param left
     * @param right
     * @return
     */
    public static boolean dfs(TreeNode left, TreeNode right) {
        if (left == null && right == null) {
            return true;
        } else if ((left != null && right == null) || left == null && right != null) {
            return false;
        }
        if (left.val != right.val) {
            return false;
        }
        return dfs(left.left, right.right) && dfs(left.right, right.left);
    }

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int val) {
            this.val = val;
        }
    }

}

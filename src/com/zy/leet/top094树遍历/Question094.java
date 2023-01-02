package com.zy.leet.top094树遍历;

import java.util.ArrayList;
import java.util.List;

/**
 * 写出树的中序遍历
 */
public class Question094 {

    public static void main(String[] args) {

    }

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        infixOrder(root, result);
        return result;
    }

    // 先序遍历：中左右
    private static void preorder(TreeNode tree, List<Integer> data){
        if (tree == null) {
            return;
        }
        data.add(tree.val);
        preorder(tree.left, data);
        preorder(tree.right, data);
    }

    // 中序遍历：左中右
    private void infixOrder(TreeNode root, List<Integer> data) {
        if (root == null) {
            return;
        }
        infixOrder(root.left, data);
        int val = root.val;
        data.add(val);
        infixOrder(root.right, data);
    }

    // 后序遍历：左右中
    private static void postorder(TreeNode tree, List<Integer> data){
        if (tree == null) {
            return;
        }
        postorder(tree.left, data);
        postorder(tree.right, data);
        data.add(tree.val);
    }

    static class TreeNode {
        TreeNode left;
        TreeNode right;
        int val;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(TreeNode left, TreeNode right, int val) {
            this.left = left;
            this.right = right;
            this.val = val;
        }
    }
}

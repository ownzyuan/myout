package com.zy.leet.top094树遍历Easy;

import java.util.ArrayList;
import java.util.List;

public class ZyAnswer094 {

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int x) {
            this.val = x;
        }
    }

    public static void main(String[] args) {

    }

    public static List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        infixOrder(root, result);
        return result;
    }

    // 先序遍历
    private static void preorder(TreeNode tree, List<Integer> data){
        if (tree == null) {
            return;
        }
        data.add(tree.val);
        preorder(tree.left, data);
        preorder(tree.right, data);
    }

    // 中序遍历
    private static void infixOrder(TreeNode tree, List<Integer> data){
        if (tree == null) {
            return;
        }
        infixOrder(tree.left, data);
        data.add(tree.val);
        infixOrder(tree.right, data);
    }

    // 后序遍历
    private static void postorder(TreeNode tree, List<Integer> data){
        if (tree == null) {
            return;
        }
        postorder(tree.left, data);
        postorder(tree.right, data);
        data.add(tree.val);
    }

}

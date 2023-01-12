package com.zy.leet.top101对称二叉树Easy;

import java.util.*;

public class ZyAnswer101 {

    public static void main(String[] args) {

    }

    public static boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return false;
        }
        List<List<Integer>> leftDataList = new LinkedList<>();
        List<List<Integer>> rightDataList = new LinkedList<>();
        Queue<TreeNode> treeNodeQueue = new LinkedList<>();
        treeNodeQueue.add(root);
        int depth = 0;
        while (!treeNodeQueue.isEmpty()) {
            List<Integer> leftData = new ArrayList<>();
            List<Integer> rightData = new ArrayList<>();
            Queue<TreeNode> nodeQueue = new LinkedList<>();
            int size = treeNodeQueue.size();
            for (int i = 0; i < size; i++) {
                TreeNode treeNode = treeNodeQueue.poll();
                if (treeNode.left != null) {
                    leftData.add(treeNode.left.val);
                    nodeQueue.add(treeNode.left);
                } else {
                    leftData.add(-100);
                }
                if (treeNode.right != null) {
                    rightData.add(treeNode.right.val);
                    nodeQueue.add(treeNode.right);
                } else {
                    rightData.add(-100);
                }
            }
            treeNodeQueue.addAll(nodeQueue);
            leftDataList.add(leftData);
            rightDataList.add(rightData);
            depth++;
        }
        for (int i = 0; i < depth; i++) {
            List<Integer> leftData = leftDataList.get(i);
            List<Integer> rightData = rightDataList.get(i);
            if (leftData.size() != rightData.size()) {
                return false;
            }
            int end = leftData.size() - 1;
            for (int j = 0; j < leftData.size(); j++) {
                if (!Objects.equals(leftData.get(j), rightData.get(end))) {
                    return false;
                }
                end--;
            }
        }
        return true;
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

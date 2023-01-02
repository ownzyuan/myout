package com.zy.leet.top095不同的二叉搜索树;

import java.util.ArrayList;
import java.util.List;

/**
 * 给你一个整数 n ，求恰由 n 个节点组成且节点值从 1 到 n 互不相同的 二叉搜索树 有多少种？
 * 返回满足题意的二叉搜索树的种数。
 */
public class Question095 {

    public static void main(String[] args) {
        numTrees(3);
    }

    public static int numTrees(int n) {
        if (n == 0 || n == 1) {
            return 1;
        }
        int[] nums = new int[n + 1];
        nums[0] = 1;
        nums[1] = 1;
        for (int i = 2; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                nums[i] += nums[j - 1] * nums[i - j];
            }
        }
        return nums[n];
    }

}

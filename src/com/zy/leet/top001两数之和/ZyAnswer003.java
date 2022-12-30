package com.zy.leet.top001两数之和;

import java.util.Scanner;

public class ZyAnswer003 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("输入数组元素个数:");
        int length = sc.nextInt();
        int[] nums = new int[length];
        System.out.print("输入数组元素(空格分割):");
        for (int i = 0; i < length; i++) {
            nums[i] = sc.nextInt();
        }
        System.out.print("输入目标值:");
        int target = sc.nextInt();
        getByDoublePointer(nums, target);
    }

    /**
     * 双指针
     * @param nums
     * @param target
     */
    private static void getByDoublePointer(int[] nums, int target) {
        int left, right;
        for (int i = 0; i < nums.length; i++) {
            left = i;
            right = nums.length - 1;
            while ((nums[left] + nums[right] > target) && (left < right)) {
                right--;
            }
            if (nums[left] + nums[right] < target) {
                continue;
            } else if (nums[left] + nums[right] == target) {
                System.out.println("[" + left + "," + right + "]");
            }
        }

    }
}

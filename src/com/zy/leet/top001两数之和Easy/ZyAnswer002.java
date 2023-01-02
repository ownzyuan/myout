package com.zy.leet.top001两数之和Easy;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class ZyAnswer002 {
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
        test(nums, target);
    }

    private static void test(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        int data, key;
        for (int i = 0; i < nums.length; i++) {
            data = nums[i];
            if (map.containsKey(data)) {
                System.out.println("[" + map.get(data) + "," + i + "]");
            }
            key = target - data;
            map.put(key, i);
        }
    }
}

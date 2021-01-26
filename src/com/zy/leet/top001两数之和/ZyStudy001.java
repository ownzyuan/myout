package com.zy.leet.top001两数之和;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class ZyStudy001 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] nums = new int[3];
        System.out.print("输入数组元素(空格分割):");
        while (sc.hasNext()) {
            for (int i = 0; i < nums.length; i++) {
                nums[i] = sc.nextInt();
            }
            System.out.print("输入目标值:");
            int target = sc.nextInt();
            test(nums, target);
        }
    }

    private static void test(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                System.out.println("[" + map.get(nums[i]) + "," + i + "]");
                return;
            }
            map.put(target - nums[i], i);
        }
        System.out.println("none");
    }
}

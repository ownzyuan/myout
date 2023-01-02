package com.zy.leet.top001两数之和Easy;

import java.util.*;

public class ZyAnswer001 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] nums = new int[1000];
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
            map.put(i, nums[i]);
        }
        Set<Integer> keySet = map.keySet();
        for (Integer key : keySet) {
            for (int i = key + 1; i < map.size(); i++) {
                if (map.get(key) + map.get(i) == target) {
                    System.out.println("[" + key + "," + i + "]");
                    return;
                }
            }
        }
        System.out.println("none");
    }
}

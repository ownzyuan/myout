package com.zy.leet.top001两数之和Easy;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class SolutionAn001 {

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
            int[] twoSum = twoSum(nums, target);
            if (twoSum != null) {
                System.out.println("[" + twoSum[0] + "," + twoSum[1] + "]");
            }else {
                System.out.println("none");
            }
        }
    }

    /**
     * 通过map集合，key用于存储target减去各个元素值的结果，然后通过map的containsKey方法
     * 判断是否在数组中存在与该key相同的值，如果存在，则说明找到了结果
     * @param nums
     * @param target
     * @return
     */
    public static int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                return new int[] {map.get(nums[i]), i};
            }
            map.put(target - nums[i], i);
        }
        return null;
    }
}

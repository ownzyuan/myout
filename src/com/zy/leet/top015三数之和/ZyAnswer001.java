package com.zy.leet.top015三数之和;

import java.util.*;

public class ZyAnswer001 {
    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        int[] nums = new int[1000];
//        System.out.print("输入数组元素(空格分割):");
//        while (sc.hasNext()) {
//            for (int i = 0; i < nums.length; i++) {
//                nums[i] = sc.nextInt();
//            }
//            System.out.print("输入目标值:");
//            int target = sc.nextInt();
//            test(nums, target);
//        }
//        int[] nums = {1, 3, 4, 6, 7, 11, 15};
//        int[] nums = {-1,0,1,2,-1,-4};
        int[] nums = {3,0,3,2,-4,0,-3,2,2,0,-1,-5};
        int target = 13;
//        test(nums, target);
        threeSum(nums);
    }

    private static void test(int[] nums, int target) {
        Map<Integer, Integer> differenceMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            differenceMap.put(target - nums[i], i);
        }
        Map<Integer, Integer> findMap;
        for (Integer differenceNum : differenceMap.keySet()) {
            Integer rightSubscript = differenceMap.get(differenceNum);
            findMap = new HashMap<>();
            for (int i = rightSubscript - 1; i >= 0; i--) {
                int num = nums[i];
                if (findMap.containsKey(num)) {
                    Integer middleSubscript = findMap.get(num);
                    System.out.println("[" + i + "," + middleSubscript + "," + rightSubscript + "]");
                    return;
                } else {
                    findMap.put(differenceNum - num, i);
                }
            }
        }
        System.out.println("none");
    }

    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Map<Integer, List<Integer>> differenceMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (differenceMap.containsKey(0 - nums[i])) {
                List<Integer> list = differenceMap.get(0 - nums[i]);
                list.add(i);
            } else {
                List<Integer> data = new ArrayList<>();
                data.add(i);
                differenceMap.put(0 - nums[i], data);
            }
        }
        Map<Integer, Integer> findMap;
        for (Integer differenceNum : differenceMap.keySet()) {
            List<Integer> rightSubscripts = differenceMap.get(differenceNum);
            findMap = new HashMap<>();
            for (Integer rightSubscript : rightSubscripts) {
                for (int i = rightSubscript - 1; i >= 0; i--) {
                    List<Integer> list = new ArrayList<>();
                    int num = nums[i];
                    if (findMap.containsKey(num)) {
                        Integer middleSubscript = findMap.get(num);
                        list.add(nums[i]);
                        list.add(nums[middleSubscript]);
                        list.add(nums[rightSubscript]);
                        Boolean isRepetitive = false;
                        if (!result.isEmpty()) {
                            for (List<Integer> concurrentList : result) {
                                isRepetitive = (concurrentList.contains(nums[i])
                                        && concurrentList.contains(nums[middleSubscript])
                                        && concurrentList.contains(nums[rightSubscript]));
                                if (isRepetitive) break;
                            }
                        }
                        if (!isRepetitive) {
                            result.add(list);
                        }
                    } else {
                        findMap.put(differenceNum - num, i);
                    }
                }
            }
        }
        return result;
    }
}

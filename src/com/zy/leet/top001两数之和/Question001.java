package com.zy.leet.top001两数之和;

import java.util.HashMap;
import java.util.Map;

public class Question001 {
    /**
     * 题目描述：
     *
     * 给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那两个整数，并返回他们的数组下标。
     * 你可以假设每种输入只会对应一个答案。但是，你不能重复利用这个数组中同样的元素。
     *
     * 示例:
     * 给定 nums = [2, 7, 11, 15], target = 9
     * 因为 nums[0] + nums[1] = 2 + 7 = 9
     * 所以返回 [0, 1]
     */

    public static void main(String[] args) {
        int[] nums = {1,3,4,5,8};
        int target = 9;
        int[] result = test(nums, target);
    }

    private static int[] test(int[] nums, int target) {
        int[] result = new int[2];
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            if (map.containsKey(num)) {
                Integer one = map.get(num);
                result[0] = one;
                result[1] = i;
            } else {
                map.put(target - num, i);
            }
        }
        return result;
    }

}

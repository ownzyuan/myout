package com.zy.leet.top015三数之和Medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Question015 {
    /**
     * 题目描述：
     *
     * 给你一个整数数组 nums ，判断是否存在三元组 [nums[i], nums[j], nums[k]] 满足 i != j、i != k 且 j != k ，
     * 同时还满足 nums[i] + nums[j] + nums[k] == 0 。
     * 请你返回所有和为 0 且不重复的三元组。
     *
     * 示例 1：
     * 输入：nums = [-1,0,1,2,-1,-4]
     * 输出：[[-1,-1,2],[-1,0,1]]
     * 解释：
     * nums[0] + nums[1] + nums[2] = (-1) + 0 + 1 = 0 。
     * nums[1] + nums[2] + nums[4] = 0 + 1 + (-1) = 0 。
     * nums[0] + nums[3] + nums[4] = (-1) + 2 + (-1) = 0 。
     * 不同的三元组是 [-1,0,1] 和 [-1,-1,2] 。
     * 注意，输出的顺序和三元组的顺序并不重要。
     *
     * 示例 2：
     * 输入：nums = [0,1,1]
     * 输出：[]
     * 解释：唯一可能的三元组和不为 0 。
     *
     * 示例 3：
     * 输入：nums = [0,0,0]
     * 输出：[[0,0,0]]
     * 解释：唯一可能的三元组和为 0 。
     */

    /**
     * 变种：
     * 给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的三个整数，并返回他们的数组下标。
     * 你可以假设每种输入只会对应一个答案。但是，你不能重复利用这个数组中同样的元素。
     * <p>
     * 示例:
     * 给定 nums = [2, 3, 4, 6, 7, 11, 15], target = 13
     * 因为 nums[1] + nums[2] + nums[3] = 3 + 4 + 6 = 13
     * 所以返回 [1, 2, 3]
     */

    public static void main(String[] args) {
//        int[] nums = {-1, 0, 1, 2, -1, -4};
//        int[] nums = {0, 0, 0, 0};
        int[] nums = {-2, 0, 1, 1, 2};
        threeSum(nums);
    }

    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        // 按顺序排序
        Arrays.sort(nums);
        if (nums.length < 3) {
            return result;
        }
        for (int i = 0; i < nums.length; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int start = i + 1;
            int num = nums[i];
            if (num > 0) {
                break;
            }
            int target = -num;
            int end = nums.length - 1;
            for (int k = start; k < nums.length; k++) {
                if (k > start && nums[k] == nums[k - 1]) {
                    continue;
                }
                while (k < end && nums[k] + nums[end] > target) {
                    end--;
                }
                if (k == end) {
                    break;
                }
                if (nums[k] + nums[end] == target) {
                    List<Integer> list = new ArrayList<>();
                    list.add(num);
                    list.add(nums[k]);
                    list.add(nums[end]);
                    result.add(list);
                }
            }
        }
        return result;
    }

}

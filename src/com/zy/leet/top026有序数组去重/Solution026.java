package com.zy.leet.top026有序数组去重;

public class Solution026 {

    public static void main(String[] args) {
        int[] nums = {0, 0, 1, 1, 2, 2, 4, 4, 6, 6, 7, 8, 8};
        removeDuplicates(nums);
    }

    public static int removeDuplicates(int[] nums) {
        if (nums.length < 2) return nums.length;
        // [0...i]区间不包含重复元素, nums[i] == nums[j]
        int i = 0, j = 1;
        for (; j < nums.length; j++) {
            if (nums[j] != nums[i]) {
                nums[i + 1] = nums[j];
                i++;
            }
        }
        return i + 1;
    }
}

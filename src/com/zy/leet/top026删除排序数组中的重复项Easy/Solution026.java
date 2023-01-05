package com.zy.leet.top026删除排序数组中的重复项Easy;

public class Solution026 {

    public static void main(String[] args) {
        int[] nums = {0, 0, 1, 1, 2, 2, 4, 4, 6, 6, 7, 8, 8};
        removeDuplicates(nums);
    }

    public static int removeDuplicates(int[] nums) {
        if(nums == null || nums.length == 0) return 0;
        int p = 0;
        int q = 1;
        while(q < nums.length){
            if(nums[p] != nums[q]){
                nums[p + 1] = nums[q];
                p++;
            }
            q++;
        }
        return p + 1;
    }
}

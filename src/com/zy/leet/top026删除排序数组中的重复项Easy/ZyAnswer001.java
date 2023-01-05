package com.zy.leet.top026删除排序数组中的重复项Easy;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ZyAnswer001 {

    public static void main(String[] args) {
//        int[] nums = {1,1,2};
        int[] nums = {0,0,1,1,1,2,2,3,3,4};
        int count = removeDuplicates(nums);
        System.out.println(count);
    }

    public static int removeDuplicates(int[] nums) {
        int length = nums.length;
        int result = length;
        if (nums == null || length == 0) {
            return result;
        }
        for (int i = 0; i < length; i++) {
            if (i == length -1) {
                break;
            }
            for (int j = i + 1; j < length; j++) {
                if (nums[i] == nums[j]) {
                    result--;
                }
                if (nums[i] < nums[j]) {
                    break;
                }
            }
        }
        Set<Integer> hashSet = new HashSet<>(result);
        for (int num : nums) {
            hashSet.add(num);
        }
        List<Integer> list = new ArrayList<>(hashSet);
        for (int i = 0; i < list.size(); i++) {
            nums[i] = list.get(i);
        }
        return result;
    }

}

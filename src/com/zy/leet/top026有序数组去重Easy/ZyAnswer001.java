package com.zy.leet.top026有序数组去重Easy;

public class ZyAnswer001 {

    public int removeDuplicates(int[] nums) {
        int result = 0;
        String numStr = null;
        int i = 0;
        int j;
        int len = nums.length;
        for (; i < len; i++) {
            int num = nums[i];
            if (i == 0) {
                numStr = "nums = [" + num + ",";
            }
            j = i + 1;
            if (j < len) {
                for (; j < len; j++) {
                    int nextNum = nums[j];
                    if (num < nextNum) {
                        numStr += num + ",";
                        result ++;
                        break;
                    }
                }
            }
        }
        return result;
    }

}

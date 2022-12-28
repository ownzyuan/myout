package com.zy.leet.top004寻找两个有序数组的中位数Hard;

import java.util.Arrays;
import java.util.Scanner;

public class SolutionAn004 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("输入第一个数组(有序且空格分割):");
        while (sc.hasNext()) {
            String strNum1 = sc.nextLine();
            System.out.print("输入第二个数组(有序且空格分割):");
            String strNum2 = sc.nextLine();
            String[] strArr1 = strNum1.split(" ");
            String[] strArr2 = strNum2.split(" ");
            int[] num1 = Arrays.stream(strArr1).mapToInt(Integer::parseInt).toArray();
            int[] num2 = Arrays.stream(strArr2).mapToInt(Integer::parseInt).toArray();
            double result = findMedianSortedArrays(num1, num2);
            System.out.println(result);
        }
    }

    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        // 保证nums1不是最长的，时间复杂度可转化为O(log(Min(m, n)))
        if (nums1.length > nums2.length) {
            return findMedianSortedArrays(nums2, nums1);
        }

        int left = 0;
        int right = nums1.length;
        int halfLen = (nums1.length + nums2.length + 1) >> 1;

        while (left <= right) {
            int i = (left + right) >> 1; // nums1[i, nums1.length)为要分割的右半部分
            int j = halfLen - i; // nums2[j, nums2.length)为要分割的右半部分
            if (i < right && nums2[j - 1] > nums1[i]) { // nums1分割点此时需要右移
                left++;
            } else if (i > left && nums1[i - 1] > nums2[j]) { // nums1 分割点此时需要左移
                right--;
            } else {
                int leftMax = (i == 0) ? nums2[j - 1] :
                        (j == 0 ? nums1[i - 1] : Math.max(nums1[i - 1], nums2[j - 1]));
                if (((nums1.length + nums2.length) & 1) == 1) {
                    return leftMax * 1.0;
                }
                int rightMin = (i == nums1.length) ? nums2[j] :
                        (j == nums2.length ? nums1[i] : Math.min(nums1[i], nums2[j]));
                return (leftMax + rightMin) / 2.0;
            }
        }
        return 0.0;
    }
}

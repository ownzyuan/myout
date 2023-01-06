package com.zy.greed;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ZyAnswerTan001 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int t = sc.nextInt();
            int[] nums = new int[4];
            List<Integer> results = new ArrayList<>();
            for (int i = 0; i < t; i++) {
                for (int j = 0; j < nums.length; j++) {
                    nums[j] = sc.nextInt();
                }
                results.add(test(nums));
            }
            results.forEach(System.out::println);
        }
    }

    private static int test(int[] nums) {
        int a = nums[0];
        int b = nums[1];
        int p = nums[2];
        int q = nums[3];
        int count = 0;
        while (a < b) {
            p *= q;
            a += p;
            count ++;
        }
        return count;
    }

}

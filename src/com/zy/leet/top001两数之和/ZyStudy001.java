package com.zy.leet.top001两数之和;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class ZyStudy001 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("数组长度");
        int len = sc.nextInt();
        System.out.println("数组元素");
        int[] arr = new int[len];
        for (int i = 0; i < len; i++) {
            arr[i] = sc.nextInt();
        }
        System.out.println("目标值");
        int target = sc.nextInt();
        Map<Integer,Integer> map = new HashMap<>();
        int j = 0;
        for (; j < len; j++) {
            int key = target - arr[j];
            if (map.containsKey(arr[j])) {
                System.out.println((map.get(arr[j])+1) + "\t" + (j+1));
                break;
            }
            map.put(key, j);
        }
        System.out.println((j+1) == target ? "none" : "end");
    }
}

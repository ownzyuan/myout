package com.zy.leet.top004寻找两个有序数组的中位数Hard;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class ZyAnswer004 {
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
            test(num1, num2);
        }
    }

    private static void test(int[] num1, int[] num2) {
        if (num1 == null && num2 == null) {
            System.out.println("none");
            return;
        }
        List<Integer> list = new ArrayList<>();
        if (num1 != null) {
            for (int i = 0; i < num1.length; i++) {
                list.add(num1[i]);
            }
            if (num2 != null) {
                for (int i = 0; i < num2.length; i++) {
                    list.add(num2[i]);
                }
            }
        } else {
            for (int i = 0; i < num2.length; i++) {
                list.add(num2[i]);
            }
        }
        List<Integer> resultList = list.stream().sorted().collect(Collectors.toList());
        int length = resultList.size();
        if (length % 2 != 0) {
            System.out.println(resultList.get(length / 2));
            return;
        }
        Double left = Double.valueOf(resultList.get(length / 2));
        Double right = Double.valueOf(resultList.get(length / 2 - 1));
        Double result = (left + right) / 2;
        System.out.println(result);
    }

}

package com.zy.leet.top003无重复字符的最长子串Medium;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class ZyAnswer003 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            String str = sc.nextLine();
            test(str);
        }
    }

    private static void test(String str) {
        int count = 0;
        char[] array = str.toCharArray();
        Map<String,Integer> map = new HashMap<>();
        for (int i = 0; i < array.length; i++) {
            String key = String.valueOf(array[i]);
            if (map.containsKey(key)) {
                count = map.size();
                map.clear();
            }
            map.put(key, i);
        }
        count = Math.max(count, map.size());
        System.out.println(count);
    }
}

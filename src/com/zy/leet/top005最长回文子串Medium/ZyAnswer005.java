package com.zy.leet.top005最长回文子串Medium;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class ZyAnswer005 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("输入一个字符串:");
        while (sc.hasNext()) {
            String str = sc.nextLine();
            test(str);
        }
    }

    private static void test(String str) {
        char[] array = str.toCharArray();
        String[] strArr = new String[1000];
        for (int i = 0; i < array.length; i++) {
            strArr[i] = String.valueOf(array[0]);
        }
        int start = 0;
        int end = strArr.length;
        Map<String, Integer> map = new HashMap<>();
        String startStr = strArr[start];
        StringBuffer stringBuffer = new StringBuffer();
        for (int i = 0; i < end; i++) {
            if (map.containsKey(startStr)) {
                if (map.size() > stringBuffer.length()) {
                    map.keySet().forEach(key -> stringBuffer.append(key));
                    map.clear();
                }
            }
            map.put(strArr[i], i);
        }
        System.out.println(stringBuffer.toString());
    }

}

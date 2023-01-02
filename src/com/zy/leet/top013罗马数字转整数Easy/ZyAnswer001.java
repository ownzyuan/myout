package com.zy.leet.top013罗马数字转整数Easy;


public class ZyAnswer001 {

    //I             1
    //V             5
    //X             10
    //L             50
    //C             100
    //D             500
    //M             1000

    public int romanToInt(String s) {
        int result = 0;
        char[] array = s.toCharArray();
        for (int i = 0; i < array.length; i++) {
            char c = array[i];
            String str = String.valueOf(c);
            int num = compareStr(str);
            result += num;
        }
        return result;
    }

    private static int compareStr(String str) {
        if ("I".equals(str)) {
            return 1;
        }
        if ("V".equals(str)) {
            return 5;
        }
        if ("X".equals(str)) {
            return 10;
        }
        if ("L".equals(str)) {
            return 50;
        }
        if ("C".equals(str)) {
            return 100;
        }
        if ("D".equals(str)) {
            return 500;
        }
        if ("M".equals(str)) {
            return 1000;
        }
        return 0;
    }
}

package com.zy.leet.top013罗马数字转整数Easy;

import java.util.HashMap;
import java.util.Map;

public class Solution013 {

    public static void main(String[] args) {
        String s = "MCMXCIV";
        int i = romanToInt(s);
        System.out.println(i);
    }

    public static int romanToInt(String s) {
        Map<Character, Integer> map = new HashMap<Character, Integer>();
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);
        int nums = 0;
        int i;
        for(i = 0; i < s.length() - 1; i++)
        {
            if (map.get(s.charAt(i)) < map.get(s.charAt(i + 1)))
                nums -= map.get(s.charAt(i));
            else
                nums += map.get(s.charAt(i));
        }
        return nums + map.get(s.charAt(i));
    }

}

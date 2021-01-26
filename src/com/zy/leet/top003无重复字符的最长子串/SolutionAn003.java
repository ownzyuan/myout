package com.zy.leet.top003无重复字符的最长子串;

import java.util.Scanner;

@Deprecated
public class SolutionAn003 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            String str = sc.nextLine();
            int length = lengthOfLongestSubstring(str);
            System.out.println(length);
        }
    }

    /**
     * @param s
     * @return
     */
    public static int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() < 1) {
            return 0;
        }

        int[] arr = new int[256];
        int l = 0;
        int r = 0; // 滑动窗口为[l, r)，其间为不重复的元素
        int res = 0;
        while (l < s.length()) {
            if (r < s.length() && arr[s.charAt(r)] == 0) {
                arr[s.charAt(r++)]++;
                res = Math.max(res, r - l);
            } else {
                arr[s.charAt(l++)]--;
            }
        }
        return res;
    }
}

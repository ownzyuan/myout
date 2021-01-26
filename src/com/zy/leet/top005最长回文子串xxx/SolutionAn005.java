package com.zy.leet.top005最长回文子串xxx;

import java.util.Scanner;

public class SolutionAn005 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("输入一个字符串:");
        while (sc.hasNext()) {
            String str = sc.nextLine();
            String result = new SolutionAn005().longestPalindrome(str);
            System.out.println(result);
        }
    }

    private int left;
    private int len;

    public String longestPalindrome(String s) {
        if (s == null || s.length() < 2) {
            return s;
        }

        for (int i = 0; i < s.length(); i++) {
            find(s, i, i); // 奇数长度
            find(s, i, i + 1); // 偶数长度
        }
        return s.substring(left, left + len);
    }

    private void find(String s, int left, int right) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            if (right - left + 1 > len) {
                len = right - left + 1;
                this.left = left;
            }
            right++;
            left--;
        }
    }

}

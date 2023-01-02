package com.zy.leet.top009回文数Easy;

/**
 * 给你一个整数 x ，如果 x 是一个回文整数，返回 true ；否则，返回 false 。
 * 回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。
 * 例如，121 是回文，而 123 不是。
 *
 * 示例 1：
 * 输入：x = 121
 * 输出：true
 *
 * 示例2：
 * 输入：x = -121
 * 输出：false
 * 解释：从左向右读, 为 -121 。 从右向左读, 为 121- 。因此它不是一个回文数。
 *
 * 示例 3：
 * 输入：x = 10
 * 输出：false
 * 解释：从右向左读, 为 01 。因此它不是一个回文数。
 */
public class Question009 {

    public static void main(String[] args) {
        boolean palindrome = isPalindrome(-11);
        System.out.println(palindrome);
    }

    public static boolean isPalindrome(int x) {
        String str = x + "";
        char[] chars = str.toCharArray();
        if (chars.length < 1) {
            return false;
        } else if (chars.length == 1) {
            return true;
        }
        int center = chars.length >> 1;
        int end = chars.length - 1;
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] != chars[end]) {
                return false;
            }
            if (i == center) {
                return true;
            }
            end--;
        }
        return true;
    }

}

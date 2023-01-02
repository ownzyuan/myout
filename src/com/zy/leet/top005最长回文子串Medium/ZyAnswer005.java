package com.zy.leet.top005最长回文子串Medium;

public class ZyAnswer005 {
    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        System.out.print("输入一个字符串:");
//        while (sc.hasNext()) {
//            String str = sc.nextLine();
//            String result = longestPalindrome(str);
//            System.out.println(result);
//        }

//        String str = "babad";
//        String str = "ccc";
//        String str = "bacbqbrttrb";
        String str = "aaacabdkacaa";
//        String str = "babadada";
        String result = longestPalindrome(str);
        System.out.println(result);
    }

    /**
     * todo （性能有问题）
     * 思路：双指针做法，指针一从首位逐渐指到末位，指针二从指针一+1处开始到末尾，通过判断两个指针的元素是否相同来初步确认是否回文子串，
     *      然后再通过特定的check方法确认是否回文子串，是的话记录长度以及此时的指针位置。
     *      当后续遇见更长的回文子串，就替换记录的指针位置，最后输出
     * @param s
     * @return
     */
    public static String longestPalindrome(String s) {
        if (s == null || "".equals(s)) {
            return "";
        }
        // 记录满足条件的子串的首位指针
        int start = 0;
        // 记录满足条件的子串的末位指针
        int end = 0;
        // 记录满足条件的子串长度
        int maxCount = 0;
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            // 记录当前满足条件的子串的长度
            int concurrentCount = 0;
            // 记录j循环中满足条件的子串的长度
            int strCount = 0;
            char startChar = chars[i];
            // 记录当前满足条件的子串的末位指针
            int pointerEnd = i;
            int j = i + 1;
            for (; j < chars.length; j++) {
                if (startChar == chars[j]) {
                    strCount = j - i + 1;
                    // 子串更长且符合回文子串，则更新记录
                    if (strCount >= concurrentCount && check(i, j, chars)) {
                        concurrentCount = strCount;
                        pointerEnd = j;
                    }
                }
            }
            // 当前子串长度比之前记录的更长，就更新指针位置
            if (concurrentCount > maxCount) {
                start = i;
                end = pointerEnd;
                maxCount = concurrentCount;
            }
        }
        StringBuffer stringBuffer = new StringBuffer();
        for (int i = start; i <= end; i++) {
            stringBuffer.append(chars[i]);
        }
        return stringBuffer.toString();
    }

    /**
     * 通过start、end指针判断其间的子串是否满足回文的条件
     * @param start
     * @param end
     * @param chars
     * @return
     */
    private static boolean check(int start, int end, char[] chars) {
        while (start < end) {
            if (chars[start] != chars[end]) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }

}

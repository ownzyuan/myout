package com.zy.leet.top020有效的括号Easy;

import java.util.Stack;

/**
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']'的字符串 s ，判断字符串是否有效。
 *
 * 有效字符串需满足：
 * 左括号必须用相同类型的右括号闭合。
 * 左括号必须以正确的顺序闭合。
 * 每个右括号都有一个对应的相同类型的左括号。
 *
 * 示例 1：
 * 输入：s = "()"
 * 输出：true
 *
 * 示例2：
 * 输入：s = "()[]{}"
 * 输出：true
 *
 * 示例3：
 * 输入：s = "(]"
 * 输出：false
 *
 * 提示：
 * 1 <= s.length <= 104
 * s 仅由括号 '()[]{}' 组成
 */
public class Question020 {

    public static void main(String[] args) {
//        String s = "()";
//        String s = "{[]}";
//        String s = "){";
//        String s = "([]{)}";
        String s = "))";
//        String s = "([}}])";
        System.out.println(isValid(s));
    }

    public static boolean isValid(String s) {
        if (s == null || s.length()%2 != 0) {
            return false;
        }
        // 存放左括号的栈
        Stack<String> stack = new Stack<>();
        // 存放未找到对应左括号的右括号
        Stack<String> otherStack = new Stack<>();
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            String str = String.valueOf(chars[i]);
            if ("(".equals(str) || "[".equals(str) || "{".equals(str)) {
                stack.push(str);
            } else {
                otherStack.push(str);
                if (!stack.empty()){
                    // 取出栈顶元素，然后获取他对应的另一半括号
                    String currentStr = stack.pop();
                    String rightStr = getStr(currentStr);
                    // 如果另一半括号对不上，则又重新放回去，反之从右括号栈中取出元素
                    if (!rightStr.equals(str)) {
                        stack.push(currentStr);
                    } else {
                        otherStack.pop();
                    }
                }
            }
        }
        // 当元素都为空时，说明括号有效
        return stack.empty() && otherStack.empty();
    }

    private static String getStr(String leftStr) {
        String str = null;
        switch (leftStr) {
            case "(":
                str = ")";break;
            case "[":
                str = "]";break;
            case "{":
                str = "}";break;
        }
        return str;
    }

}

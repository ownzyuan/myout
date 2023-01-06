package com.zy.leet.top022括号生成Medium;

import java.util.*;

/**
 * 数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。
 *
 * 示例 1：
 * 输入：n = 3
 * 输出：["((()))","(()())","(())()","()(())","()()()"]
 *
 * 示例 2：
 * 输入：n = 1
 * 输出：["()"]
 *
 * 提示：
 * 1 <= n <= 8
 */
public class Question022 {

    public static void main(String[] args) {
        List<String> list = generateParenthesis(5);
        //"(((())))","((()))()","()((()))"
        // "((()()))","(()())()","()(()())"
        // "((())())","(())()()","()(())()"
        // "(()(()))","()()(())"
        // "(()()())","()()()()"
        // "(())(())"
//        System.out.println(list.contains("(())(())"));
        String str5 =  "\"((((()))))\",\"(((()())))\",\"(((())()))\",\"(((()))())\",\"(((())))()\",\"((()(())))\",\"((()()()))\",\"((()())())\",\"((()()))()\",\"((())(()))\",\"((())()())\",\"((())())()\",\"((()))(())\",\"((()))()()\",\"(()((())))\",\"(()(()()))\",\"(()(())())\",\"(()(()))()\",\"(()()(()))\",\"(()()()())\",\"(()()())()\",\"(()())(())\",\"(()())()()\",\"(())((()))\",\"(())(()())\",\"(())(())()\",\"(())()(())\",\"(())()()()\",\"()(((())))\",\"()((()()))\",\"()((())())\",\"()((()))()\",\"()(()(()))\",\"()(()()())\",\"()(()())()\",\"()(())(())\",\"()(())()()\",\"()()((()))\",\"()()(()())\",\"()()(())()\",\"()()()(())\",\"()()()()()\"";
        System.out.println(str5.split(",").length);
        list.forEach(System.out::println);
    }

    public static List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            // 为1就只有一种画法
            if (i == 1) {
                result.add("()");
                continue;
            }
            // 保存后续画出括号的数据
            Set<String> recordSet = new HashSet<>();
            for (String str : result) {
                StringBuffer buffer = new StringBuffer(str);
                // 第一种画法：首尾加“()”
                buffer.insert(0, "(");
                buffer.insert(buffer.length() - 1, ")");
                recordSet.add(buffer.toString());
                // 第二种画法：左侧加“()”
                buffer = new StringBuffer(str);
                buffer.insert(0, "()");
                recordSet.add(buffer.toString());
                // 第三种画法：右侧加“()”
                buffer = new StringBuffer(str);
                buffer.insert(buffer.length(), "()");
                recordSet.add(buffer.toString());
            }
            // 如果i为偶数，还有1种特殊画法，如 2：()() 4：(())(()) 6：((()))((()))
            if (i % 2 == 0) {
                StringBuffer bufferSpecial = new StringBuffer();
                for (int j = 0; j < i; j++) {
                    if (j < i / 2) {
                        bufferSpecial.append("(");
                    } else if (i / 2 <= j) {
                        bufferSpecial.append(")");
                    }
                }
                bufferSpecial.append(bufferSpecial.toString());
                recordSet.add(bufferSpecial.toString());
            }
            result = new ArrayList<>(recordSet);
        }
        return result;
    }

}

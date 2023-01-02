package com.zy.leet.top002两数相加Medium;

import java.util.Scanner;

public class Question002 {
    /**
     * 题目描述：
     *
     * 给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，
     * 并且它们的每个节点只能存储 一位 数字。
     *
     * 如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。
     * 您可以假设除了数字 0 之外，这两个数都不会以 0 开头。
     *
     * 示例：
     * 输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
     * 输出：7 -> 0 -> 8
     * 原因：342 + 465 = 807
     */

    public static void main(String[] args) {
        ListNode addListNodeOne = null;
        ListNode addListNodeTwo = null;
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int numOne = sc.nextInt();
            int numTwo = sc.nextInt();
            while (numOne > 0 ) {
                addListNodeOne = addFirst(addListNodeOne, numOne%10);
                numOne=numOne/10;
            }
            while (numTwo > 0 ) {
                addListNodeTwo = addFirst(addListNodeTwo, numTwo%10);
                numTwo=numTwo/10;
            }
            ListNode listNode = test(addListNodeOne, addListNodeTwo);
            systemOutListNode(listNode.next);
        }
    }

    static class ListNode {
        ListNode next;
        int val;
        ListNode(int value) {
            this.val = value;
        }
    }

    private static ListNode test(ListNode l1, ListNode l2) {
        ListNode listNode = new ListNode(0);
        int nextValue = 0;
        ListNode record = listNode;
        while (l1 != null || l2 != null) {
            int valueOne = 0;
            if (l1 != null) {
                valueOne = l1.val;
                l1 = l1.next;
            }
            int valueTwo = 0;
            if (l2 != null) {
                valueTwo = l2.val;
                l2 = l2.next;
            }
            int value = valueOne + valueTwo + nextValue;
            if (value >= 10) {
                nextValue = value / 10;
                value = value % 10;
            } else {
                nextValue = 0;
            }
            record.next = new ListNode(value);
            record = record.next;
            if (l1 == null && l2 == null && nextValue > 0) {
                record.next = new ListNode(nextValue);
                record = record.next;
            }
        }
        return listNode;
    }

    private static ListNode addEnd(ListNode listNode, int value) {
        ListNode listNodeQuestion = new ListNode(value);
        if (listNode == null) {
            listNode = listNodeQuestion;
            return listNode;
        }
        ListNode node = listNode;
        while (node.next != null) {
            node = node.next;
        }
        node.next = node;
        return listNode;
    }

    private static ListNode addFirst(ListNode listNode, int value) {
        ListNode listNodeQuestion = new ListNode(value);
        if (listNode == null) {
            listNode = listNodeQuestion;
            return listNode;
        }
        listNodeQuestion.next = listNode;
        listNode = listNodeQuestion;
        return listNode;
    }

    private static void systemOutListNode(ListNode listNode) {
        if (listNode != null) {
            System.out.println(listNode.val);
            systemOutListNode(listNode.next);
        }
    }

}

package com.zy.leet.top002两数相加;

import java.util.Scanner;

public class ListNodeTest {

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    // 头插法
    public static ListNode addFirst(ListNode head, int data) {
        ListNode node = new ListNode(data);
        if (head == null) {
            head = node;
            return head;
        }
        node.next = head;
        head = node;
        return head;
    }

    // 尾插法
    public static ListNode addEnd(ListNode head, int data) {
        ListNode node = new ListNode(data);
        if (head == null) {
            head = node;
            return head;
        }
        ListNode end = head;
        while (end.next != null) {
            end = end.next;
        }
        end.next = node;
        return head;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ListNode listNode1 = null;
        ListNode listNode2 = null;
        while (sc.hasNext()) {
            int num1 = sc.nextInt();
            int num2 = sc.nextInt();
            // listNode1使用尾插法
            while (num1 > 0) {
                if (listNode1 == null) {
                    listNode1 = addEnd(listNode1, num1 % 10);
                    num1 /= 10;
                    continue;
                }
                addEnd(listNode1, num1 % 10);
                num1 /= 10;
            }
            // listNode2使用头插法
            while (num2 > 0) {
                listNode2 = addFirst(listNode2, num2 % 10);
                num2 /= 10;
            }

            // 输出
            while (listNode1 != null) {
                System.out.println(listNode1.val);
                listNode1 = listNode1.next;
            }
            while (listNode2 != null) {
                System.out.println(listNode2.val);
                listNode2 = listNode2.next;
            }
        }
    }

}

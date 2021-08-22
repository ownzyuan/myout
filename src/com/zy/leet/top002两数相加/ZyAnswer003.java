package com.zy.leet.top002两数相加;

import java.util.Scanner;

public class ZyAnswer003 {

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    // 头插法
    public static ListNode addFirst(ListNode head, int val) {
        ListNode node = new ListNode(val);
        if (head == null) {
            head = node;
            return head;
        }
        node.next = head;
        head = node;
        return head;
    }

    // 尾插法
    public static ListNode addEnd(ListNode head, int val) {
        ListNode node = new ListNode(val);
        if (head == null) {
            head = node;
            return head;
        }
        ListNode end = head.next;
        while (end.next != null) {
            end = end.next;
        }
        end.next = node;
        return head;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("输入链表01");
        int num01 = sc.nextInt();
        ListNode node01 = null;
        while (num01 > 0) {
            node01 = addEnd(node01, num01 % 10);
            num01 /= 10;
        }
        int num02 = sc.nextInt();
        ListNode node02 = null;
        while (num02 > 0) {
            node02 = addEnd(node02, num01 % 10);
            num01 /= 10;
        }

        System.out.println();
    }

}

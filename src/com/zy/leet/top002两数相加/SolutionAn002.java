package com.zy.leet.top002两数相加;

import java.util.Scanner;

public class SolutionAn002 {

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public static void main(String[] args) {
        ListNode listNode1 = null;
        ListNode listNode2 = null;
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int num1 = sc.nextInt();
            int num2 = sc.nextInt();
            long start = System.currentTimeMillis();
            while (num1 > 0) {
                listNode1 = addFirst(listNode1, num1 % 10);
                num1 /= 10;
            }
            while (num2 > 0) {
                listNode2 = addFirst(listNode2, num2 % 10);
                num2 /= 10;
            }
            ListNode result = addTwoNumbers(listNode1, listNode2);
            while (result != null) {
                System.out.println(result.val);
                result = result.next;
            }
            long end = System.currentTimeMillis();
            System.out.println("执行时间:" + (end - start) + "ms");
        }

    }

    // 尾插法
    private static ListNode addEnd(ListNode listNode, int data) {
        ListNode node = new ListNode(data);
        if (listNode == null) {
            listNode = node;
            return listNode;
        }
        ListNode end = listNode;
        while (end.next != null) {
            end = end.next;
        }
        end.next = node;
        return listNode;
    }

    // 头插法
    private static ListNode addFirst(ListNode listNode, int data) {
        ListNode node = new ListNode(data);
        if (listNode == null) {
            listNode = node;
            return listNode;
        }
        node.next = listNode;
        listNode = node;
        return listNode;
    }

    /**
     * 通过map集合，key用于存储target减去各个元素值的结果，然后通过map的containsKey方法
     * 判断是否在数组中存在与该key相同的值，如果存在，则说明找到了结果
     *
     * @return
     */
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);
        int sum = 0; // 结果
        int more = 0; // 进位
        ListNode pre = dummy;
        while (l1 != null || l2 != null || more > 0) {
            sum = (l1 == null ? 0 : l1.val) + (l2 == null ? 0 : l2.val) + more;
            more = sum / 10;
            sum %= 10;
            ListNode node = new ListNode(sum);
            pre.next = node;
            pre = node;
            l1 = l1 == null ? null : l1.next;
            l2 = l2 == null ? null : l2.next;
        }
        return dummy.next;
    }
}

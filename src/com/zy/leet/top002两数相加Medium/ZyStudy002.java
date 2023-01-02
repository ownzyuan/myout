package com.zy.leet.top002两数相加Medium;

import java.util.Scanner;

public class ZyStudy002 {

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            ListNode listNode1 = null;
            ListNode listNode2 = null;
            int num1 = sc.nextInt();
            int num2 = sc.nextInt();
            long start = System.currentTimeMillis();
            while (num1 > 0) {
                if (listNode1 == null) {
                    listNode1 = addEnd(listNode1, num1 % 10);
                    num1 /= 10;
                    continue;
                }
                addEnd(listNode1, num1 % 10);
                num1 /= 10;
            }
            while (num2 > 0) {
                if (listNode2 == null) {
                    listNode2 = addEnd(listNode2, num2 % 10);
                    num2 /= 10;
                    continue;
                }
                addEnd(listNode2, num2 % 10);
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

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode sumListNode = null;
        StringBuffer stringBuffer1 = new StringBuffer();
        StringBuffer stringBuffer2 = new StringBuffer();
        while (l1 != null) {
            stringBuffer1.append(l1.val);
            l1 = l1.next;
        }
        stringBuffer1.reverse();
        while (l2 != null) {
            stringBuffer2.append(l2.val);
            l2 = l2.next;
        }
        stringBuffer2.reverse();
        Integer num1 = Integer.valueOf(stringBuffer1.toString());
        Integer num2 = Integer.valueOf(stringBuffer2.toString());
        int sums = num1 + num2;
        while (sums > 0) {
            if (sumListNode == null) {
                sumListNode = addEnd(sumListNode, sums % 10);
                sums /= 10;
                continue;
            }
            addEnd(sumListNode, sums % 10);
            sums /= 10;
        }
        return sumListNode;
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

}

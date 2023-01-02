package com.zy.leet.top021合并2个有序链表Easy;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ZyAnswer001 {

    static class ListNode {
        int val;
        ListNode next;

        public ListNode(int x) {
            this.val = x;
        }
    }

    public static ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        List<Integer> nums = new ArrayList<>();
        while (list1 != null) {
            nums.add(list1.val);
            list1 = list1.next;
        }
        while (list2 != null) {
            nums.add(list2.val);
            list2 = list2.next;
        }
        List<Integer> collect = nums.stream().sorted().collect(Collectors.toList());
        ListNode result = null;
        for (Integer num : collect) {
            ListNode listNode = addLast(result, num);
            result = listNode;
        }
        System.out.println(1);
        return result;
    }

    private static ListNode addFirst(ListNode list, int num) {
        ListNode listNode = new ListNode(num);
        if (list == null) {
            list = listNode;
            return list;
        }
        listNode.next = list;
        list = listNode;
        return list;
    }

    private static ListNode addLast(ListNode list, int num) {
        ListNode listNode = new ListNode(num);
        if (list == null) {
            list = listNode;
            return list;
        }
        ListNode end = list;
        while (end.next != null) {
            end = end.next;
        }
        end.next = listNode;
        return list;
    }

}

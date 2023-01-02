package com.zy.leet.top021合并2个有序链表Easy;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Question001 {

    /**
     * 将两个升序链表合并为一个新的 升序 链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的
     *
     * 示例 1：
     * 输入：l1 = [1,2,4], l2 = [1,3,4]
     * 输出：[1,1,2,3,4,4]
     *
     * 示例 2：
     * 输入：l1 = [], l2 = []
     * 输出：[]
     *
     * 示例 3：
     * 输入：l1 = [], l2 = [0]
     * 输出：[0]
     */

    static class ListNode {
        ListNode next;
        int val;
        ListNode (int val) {
            this.val = val;
        }
    }

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode result = new ListNode(0);
        List<Integer> list = new ArrayList<>();
        while (list1 != null || list2 != null) {
            if (list1 != null) {
                int valOne = list1.val;
                list.add(valOne);
                list1 = list1.next;
            }
            if (list2 != null) {
                int valTwo = list2.val;
                list.add(valTwo);
                list2 = list2.next;
            }
        }
        list.sort(Comparator.comparing(Integer::intValue));
        ListNode record = result;
        for (Integer num : list) {
            record.next = new ListNode(num);
            record = record.next;
        }
        return result.next;
    }

}

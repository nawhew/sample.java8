package com.example.sample.algorithm.inflearn.linkedlist;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.TreeMap;

public class MergeKSortedLists {
    public static void main(String[] args) {

        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(4);
        l1.next.next = new ListNode(5);

        ListNode l2 = new ListNode(1);
        l2.next = new ListNode(3);
        l2.next.next = new ListNode(4);

        ListNode l3 = new ListNode(2);
        l3.next = new ListNode(6);

        System.out.println(mergeKLists(new ListNode[]{l1, l2, l3}));
    }

    public static ListNode mergeKLists(ListNode[] lists) {
        TreeMap<Integer, Integer> listValues = new TreeMap<>();

        for (ListNode listNode : lists) {
            while(listNode != null) {
                listValues.put(listNode.val, listValues.getOrDefault(listNode.val, 0) + 1);
                listNode = listNode.next;
            }
        }

        ListNode result = new ListNode(0);
        ListNode temp = result;
        for (Integer key : listValues.keySet()) {
            int val = listValues.get(key);
            for (int i = 0; i < val; i++) {
                temp.next = new ListNode(key);
                temp = temp.next;
            }
        }
        return result.next;
    }
}
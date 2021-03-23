package com.example.sample.algorithm.inflearn.linkedlist;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ReverseLinkedLists {
    public static void main(String[] args) {

        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(2);
        l1.next.next = new ListNode(3);
        l1.next.next.next = new ListNode(4);
        l1.next.next.next.next = new ListNode(5);

        System.out.println(reverseList(l1));
        System.out.println(reverseList2(l1));
    }

    public static ListNode reverseList(ListNode current) {
        List<Integer> currentValues = new ArrayList<>();
        while(current != null) {
            currentValues.add(current.val);
            current = current.next;
        }

        ListNode resultDummyHeader = new ListNode(0);
        ListNode temp = resultDummyHeader;

        for (int i = currentValues.size() - 1; i >= 0 ; i--) {
            temp.next = new ListNode(currentValues.get(i));
            temp = temp.next;
        }

        return resultDummyHeader.next;
    }

    public static ListNode reverseList2(ListNode current) {
        ListNode tempNode = null;
        ListNode preNode = null;

        while (current != null) {
            tempNode = new ListNode(current.val);
            tempNode.next = preNode;
            preNode = tempNode;
            current = current.next;
        }

        return tempNode;
    }

}

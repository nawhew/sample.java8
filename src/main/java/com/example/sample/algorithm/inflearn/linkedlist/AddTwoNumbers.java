package com.example.sample.algorithm.inflearn.linkedlist;

public class AddTwoNumbers {

    public static void main(String[] args) {
        ListNode l1 = new ListNode(2);
        l1.next = new ListNode(4);
        l1.next.next = new ListNode(3);

        ListNode l2 = new ListNode(5);
        l2.next = new ListNode(6);
        l2.next.next = new ListNode(8);

        System.out.println(solve(l1, l2));
    }

    public static ListNode solve(ListNode l1, ListNode l2) {

        ListNode dummyHeadListNode = new ListNode(0);
        ListNode temp = dummyHeadListNode;

        int sum = 0;
        while(l1 != null || l2 != null) {
            if(l1 != null) {
                sum += l1.val;
                l1 = l1.next;
            }
            if(l2 != null) {
                sum += l2.val;
                l2 = l2.next;
            }
            temp.next = new ListNode(sum % 10);
            temp = temp.next;
            sum /= 10;
        }
        if(sum != 0) {
            temp.next = new ListNode(sum % 10);
        }

        return dummyHeadListNode.next;
    }
}


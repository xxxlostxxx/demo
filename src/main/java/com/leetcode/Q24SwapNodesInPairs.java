package com.leetcode;


public class Q24SwapNodesInPairs {

    public static void main(String[] args) {
        Q24SwapNodesInPairs q = new Q24SwapNodesInPairs();

        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);

        ListNode listNode = q.swapPairs(head);
        System.out.println("down");
    }

    public ListNode swapPairs(ListNode head) {
        ListNode it = head;
        ListNode pre = head;
        ListNode newHead;
        while (it != null) {
            if (it.next !=null) {
                ListNode next=it.next;
                if (it == pre) {
                    //it.next为head
                    newHead=it.next;
                    it.next=it.next.next;
                    newHead.next=it;
                } else {

                }

                // 1-2-3  123456 124356
                it.next = it.next.next;
                it.next.next = it;
                it=next;
            }else {
                break;
            }
        }

        return head;
    }

}

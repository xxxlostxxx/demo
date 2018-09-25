package com.leetcode;

import java.util.List;

/**
 * Merge two sorted linked lists and return it as a new list.
 * The new list should be made by splicing together the nodes of the first two lists.

 Example:

 Input: 1->2->4, 1->3->4
 Output: 1->1->2->3->4->4
 */
public class Q21MergeTwoLists {


    public static void main(String[] args) {
        Q21MergeTwoLists q = new Q21MergeTwoLists();
        ListNode listNode = new ListNode(1);
        listNode.next=new ListNode(2);
        listNode.next.next = new ListNode(4);
        ListNode listNode1 = new ListNode(1);
        listNode1.next = new ListNode(3);
        listNode1.next.next = new ListNode(4);
        ListNode listNode2 = q.mergeTwoLists(listNode, listNode1);
        System.out.println("down");
    }
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null ) {
            if (l2 == null){
                return null;
            }else {
                return l2;
            }
        }
        if (l2 == null) {
            if (l1 == null){
                return null;
            }else {
                return l1;
            }
        }
        //新建一个list
        ListNode listNode ;
        ListNode listNode1;
        ListNode listNode2;
        int x = 0;
        if (l1.val < l2.val) {
            x=l1.val;
            listNode = new ListNode(l1.val);
            listNode1=l1.next;
            listNode2 = l2;
        } else {
            x = l2.val;
            listNode = new ListNode(l2.val);
            listNode1=l1;
            listNode2=l2.next;
        }
        ListNode res = listNode;
        while (listNode1!= null || listNode2!=null){
            if (listNode1 == null) {
                listNode.next = listNode2;
                break;
            }
            if (listNode2 == null) {
                listNode.next = listNode1;
                break;
            }
            int y ;
            if (listNode1.val < listNode2.val) {
                y=listNode1.val;
                listNode1 = listNode1.next;
            } else {
                y = listNode2.val;
                listNode2 = listNode2.next;
            }
            listNode.next = new ListNode(y);
            listNode = listNode.next;
        }
        return res;
    }
}

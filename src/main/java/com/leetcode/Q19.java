package com.leetcode;


import java.util.ArrayList;
import java.util.List;

/**
 *
 给定一个链表，删除链表的倒数第 n 个节点，并且返回链表的头结点。

 示例：

 给定一个链表: 1->2->3->4->5, 和 n = 2.

 当删除了倒数第二个节点后，链表变为 1->2->3->5.
 说明：

 给定的 n 保证是有效的。

 进阶：

 你能尝试使用一趟扫描实现吗？
 */
public class Q19 {




    public static void main(String[] args) {
         ListNode listNode  = new ListNode(1);
         listNode.next = new ListNode(2);
         listNode.next.next = new ListNode(3);
         listNode.next.next.next = new ListNode(4);
         listNode.next.next.next.next = new ListNode(5);
         Q19 q19 = new Q19();
        ListNode listNode1 = q19.deleteByIndex(listNode, 2);
        System.out.println("down");



    }


    /**
     * 时间 O(n) 空间 O(n)
     * 一次扫描 从链表头部开始 扫描倒数第n个元素删除
     * 未知链表长度 需要迭代 需要迭代到最后 返查第n个 新建list记录
     * @param listNode
     * @param index
     */
    public ListNode deleteByIndex(ListNode listNode ,int index) {
        List list  = new ArrayList();
        ListNode  copy = listNode;
        while (listNode !=null) {
            list.add(listNode);
            listNode = listNode.next;
        }

        if (index>list.size()) return copy;
        if (index == list.size()) {
            return copy.next;
        }
        // 需要取出被删除元素前一个元素
        ListNode listNode1 =   (ListNode)list.get(list.size()-index-1);
        ListNode listNode2 = listNode1.next;
        ListNode listNode3 =  listNode2.next;
        listNode1.next = listNode3;
        return copy;
    }

    /**
     * 时间 O(n) 空间 O(n)
     * 一次扫描 从链表头部开始 扫描倒数第n个元素删除
     * 未知链表长度 需要迭代 需要迭代到最后 返查第n个 新建list记录
     * @param listNode
     * @param index
     */
    public ListNode deleteByIndex2(ListNode listNode ,int index) {
        ListNode dummy =  new ListNode(0);
        dummy.next = listNode ;

        ListNode first = dummy;
        ListNode second = dummy;

        for (int i = 0 ; i< index ; i++) {
            first = first.next;
        }

        while (first != null) {
            first = first.next;
            second= second.next;
        }

        // 此时 first 遍历 size+1 次  second 遍历 size+1-n-1 次 second 所在的位置为 size-n   5-2 = 3 第三个元素  需要删除的是
/*


        ListNode  copy = listNode;

        while (listNode !=null) {
            list.add(listNode);
            listNode = listNode.next;
        }

        if (index>list.size()) return copy;
        if (index == list.size()) {
            return copy.next;
        }
        // 需要取出被删除元素前一个元素
        ListNode listNode1 =   (ListNode)list.get(list.size()-index-1);
        ListNode listNode2 = listNode1.next;
        ListNode listNode3 =  listNode2.next;
        listNode1.next = listNode3;
        return copy;*/

return null;
    }


}

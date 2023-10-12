package com.everdata.demo.algo.linked_list;

import com.everdata.demo.domain.ListNode;

/**
 * ReverseNList
 * 反转链表的前N个元素
 * @author liujin
 * @date 2023/10/9
 */
public class ReverseNList {

    public ListNode successor =null;
    public ListNode reverseN(ListNode head, int n) {

        if (n == 1) {
            successor = head.next;
            return head;
        }

        ListNode last = reverseN(head.next, n - 1);
        head.next.next =head;
        head.next = successor;
        return last;
    }
}

package com.everdata.demo.domain;

import javax.management.DynamicMBean;
import java.util.List;

/**
 * ListNode
 *
 * @author liujin
 * @date 2023/9/21
 */
public class ListNode {
    public int val;
    public ListNode next;

    public ListNode() {
    }

    public ListNode(int val) {
        this.val = val;
    }

    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    public ListNode(int[] vals) {
        ListNode dummy = new ListNode(-1, null);
        ListNode cur = dummy;
        for (int i : vals) {
            cur.next = new ListNode(i, null);
            cur = cur.next;
        }
        val = dummy.next.val;
        next = dummy.next.next;
    }

    @Override
    public String toString() {
        return "ListNode{" + "val=" + val + ", next=" + next + '}';
    }
}

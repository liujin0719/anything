package com.everdata.demo.domain;

import com.everdata.demo.algo.top100._61RotateRight;

/**
 * ListNode
 *
 * @author liujin
 * @date 2023/9/21
 */
public class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    @Override
    public String toString() {
        return "ListNode{" + "val=" + val + ", next=" + next + '}';
    }
}

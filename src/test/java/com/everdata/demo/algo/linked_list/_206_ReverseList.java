package com.everdata.demo.algo.linked_list;

import com.everdata.demo.domain.ListNode;

/**
 * <pre>
 * 给你单链表的头节点 head ，请你反转链表，并返回反转后的链表。
 *
 * 输入：head = [1,2,3,4,5] 输出：[5,4,3,2,1]
 *
 * 输入：head = [1,2] 输出：[2,1]
 *
 * 输入：head = [] 输出：[]
 *
 * 提示：
 * 链表中节点的数目范围是 [0, 5000]
 * -5000 <= Node.val <= 5000
 * </pre>
 *
 * @author liujin
 * @date 2023/10/9
 */
public class _206_ReverseList {
    public static void main(String[] args) {
        ListNode listNode = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))));
        _206_ReverseList reverseList = new _206_ReverseList();
        System.out.println(reverseList.reverseList(listNode));
    }

    public ListNode reverseList(ListNode head) {
        ListNode dummy = new ListNode(-1);

        while (head != null) {
            ListNode next = dummy.next;
            dummy.next = head;
            head = head.next;
            dummy.next.next = next;
        }

        return dummy.next;

    }

    public ListNode reverseList2(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode last = reverseList2(head.next);
        head.next.next = head;
        head.next = null;
        return last;
    }
}

package com.everdata.demo.algo.linked_list;

import com.everdata.demo.domain.ListNode;

/**
 * 将两个升序链表合并为一个新的 升序 链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。
 * <pre>
 * 输入：l1 = [1,2,4], l2 = [1,3,4]
 * 输出：[1,1,2,3,4,4]
 * 示例 2：
 *
 * 输入：l1 = [], l2 = []
 * 输出：[]
 * 示例 3：
 *
 * 输入：l1 = [], l2 = [0]
 * 输出：[0]
 * </pre>
 *
 * @author liujin
 * @date 2023/10/9
 */
public class _21_MergeTwoLists {

    public static void main(String[] args) {

        _21_MergeTwoLists mergeTwoLists = new _21_MergeTwoLists();

        ListNode listNode1 = new ListNode(1, new ListNode(2, new ListNode(4)));
        ListNode listNode2 = new ListNode(1, new ListNode(3, new ListNode(4)));

        ListNode listNode = mergeTwoLists.mergeTwoLists(listNode1, listNode2);

        System.out.println(listNode);


    }

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {

        ListNode l1 = list1;
        ListNode l2 = list2;
        ListNode ret = new ListNode(-1);

        ListNode head = ret;

        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                ret.next = l1;
                l1 = l1.next;
            } else {
                ret.next = l2;
                l2 = l2.next;
            }
            ret = ret.next;
        }

        if (l1 == null) {
            ret.next = l2;
        } else {
            ret.next = l1;
        }
        
        return head.next;

    }
}

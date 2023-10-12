package com.everdata.demo.algo.linked_list;

import com.everdata.demo.domain.ListNode;

/**
 * <pre>
 *     给定一个已排序的链表的头 head ， 删除所有重复的元素，使每个元素只出现一次 。返回 已排序的链表 。
 *     输入：head = [1,1,2] 输出：[1,2]
 *     输入：head = [1,1,2,3,3] 输出：[1,2,3]
 * </pre>
 *
 * @author liujin
 * @date 2023/10/9
 */
public class _83_DeleteDuplicates {

    public static void main(String[] args) {
        ListNode listNode = new ListNode(1, new ListNode(1, new ListNode(2)));
        _83_DeleteDuplicates deleteDuplicates = new _83_DeleteDuplicates();
        System.out.println(deleteDuplicates.deleteDuplicates(listNode));


    }

    public ListNode deleteDuplicates(ListNode head) {

        ListNode cur = head;

        while (cur != null && cur.next != null) {
            if (cur.val == cur.next.val) {
                cur.next = cur.next.next;
            } else {
                cur = cur.next;
            }
        }

        return head;
    }
}

package com.everdata.demo.algo.linked_list;

import com.everdata.demo.domain.ListNode;

/**
 * 给你一个链表，删除链表的倒数第 n 个结点，并且返回链表的头结点。
 * <pre>
 * 输入：head = [1,2,3,4,5], n = 2
 * 输出：[1,2,3,5]
 * 示例 2：
 *
 * 输入：head = [1], n = 1
 * 输出：[]
 * 示例 3：
 *
 * 输入：head = [1,2], n = 1
 * 输出：[1]
 * 提示：
 *
 * 链表中结点的数目为 sz
 * 1 <= sz <= 30
 * 0 <= Node.val <= 100
 * 1 <= n <= sz
 * 进阶：你能尝试使用一趟扫描实现吗？
 * </pre>
 *
 * @author liujin
 * @date 2023/10/9
 */
public class _19_RemoveNthFromEnd {
    public static void main(String[] args) {
        ListNode listNode = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))));

        _19_RemoveNthFromEnd removeNthFromEnd = new _19_RemoveNthFromEnd();

        System.out.println(removeNthFromEnd.removeNthFromEnd(listNode, 2));
    }

    public ListNode removeNthFromEnd(ListNode head, int n) {

        ListNode dummy = new ListNode(-1, head);

        ListNode p1 = dummy;
        ListNode p2 = dummy;

        for (int i = 0; i <= n; i++) {
            p1 = p1.next;
        }
        while (p1 != null) {
            p1 = p1.next;
            p2 = p2.next;
        }

        p2.next = p2.next.next;
        return dummy.next;
    }

}

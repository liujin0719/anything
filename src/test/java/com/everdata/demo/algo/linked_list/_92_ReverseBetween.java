package com.everdata.demo.algo.linked_list;

import com.everdata.demo.domain.ListNode;

/**
 * _92_ReverseBetween
 * <pre>
 * 给你单链表的头指针 head 和两个整数 left 和 right ，其中 left <= right 。请你反转从位置 left 到位置 right 的链表节点，返回 反转后的链表 。
 * 示例 1：
 *
 *
 * 输入：head = [1,2,3,4,5], left = 2, right = 4
 * 输出：[1,4,3,2,5]
 * 示例 2：
 *
 * 输入：head = [5], left = 1, right = 1
 * 输出：[5]
 * 提示：
 *
 * 链表中节点数目为 n
 * 1 <= n <= 500
 * -500 <= Node.val <= 500
 * 1 <= left <= right <= n
 * </pre>
 *
 * @author liujin
 * @date 2023/10/10
 */
public class _92_ReverseBetween {
    public ListNode successor = null;

    public ListNode reverseBetween(ListNode head, int left, int right) {

        // base case
        if (left == 1) {
            return reverseN(head, right);
        }

        // 前进到反转的起点触发 base case
        head.next = reverseBetween(head.next, left - 1, right - 1);

        return head;
    }


    private ListNode reverseN(ListNode head, int n) {

        if (n == 1) {
            successor = head.next;
            return head;
        }
        ListNode last = reverseN(head.next, n - 1);
        head.next.next = head;
        head.next = successor;
        return last;
    }


}

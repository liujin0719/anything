package com.everdata.demo.algo.linked_list;

import com.everdata.demo.domain.ListNode;

/**
 * <pre>
 * 给你单链表的头结点 head ，请你找出并返回链表的中间结点。
 *
 * 如果有两个中间结点，则返回第二个中间结点。
 *
 * 示例 1：
 *
 * 输入：head = [1,2,3,4,5]
 * 输出：[3,4,5]
 * 解释：链表只有一个中间结点，值为 3 。
 *
 *
 * 示例 2：
 *
 * 输入：head = [1,2,3,4,5,6]
 * 输出：[4,5,6]
 * 解释：该链表有两个中间结点，值分别为 3 和 4 ，返回第二个结点。
 *
 * 提示：
 * 链表的结点数范围是 [1, 100]
 * 1 <= Node.val <= 100
 * </pre>>
 *
 * @author liujin
 * @date 2023/10/9
 */
public class _876_MiddleNode {
    public ListNode middleNode(ListNode head) {

        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
}

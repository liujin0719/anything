/**
 * Copyright ©2021-2025 Eversec Corporation, All Rights Reserved
 * http://eversec.com.cn/
 */

package com.everdata.demo.algo.top100;

/**
 * _61RotateRight
 *
 * @author liujin
 * @date 2022/3/2 16:13
 */
public class _61RotateRight {
	public static void main(String[] args) {
		ListNode listNode = new ListNode(1, new ListNode(2, new ListNode(3)));
		int k = 2000000000;
		//		System.out.println(rotateRight(listNode, k));
		System.out.println(rotateRight2(listNode, k));
	}

	//暴力移动
	public static ListNode rotateRight(ListNode head, int k) {
		while (head != null && head.next != null && k-- > 0) {
			ListNode tail = head;
			ListNode pre = null;
			while (tail.next != null) {
				pre = tail;
				tail = tail.next;
			}
			tail.next = head;
			pre.next = null;
			head = tail;
		}
		return head;

	}

	//成环
	public static ListNode rotateRight2(ListNode head, int k) {
		if (k == 0 || head == null || head.next == null) {
			return head;
		}

		ListNode iter = head;

		int n = 1;
		//获取末尾节点以及节点总数
		while (iter.next != null) {
			iter = iter.next;
			n++;
		}

		//获取最后需要移动的次数
		int add = n - k % n;
		if (add == n) {
			return head;
		}

		//形成环
		iter.next = head;

		//开始移动add次
		while (add-- > 0) {
			iter = iter.next;
		}

		//切开
		ListNode ret = iter.next;
		iter.next = null;
		return ret;
	}

	public static class ListNode {
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
}
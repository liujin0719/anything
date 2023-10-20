package com.everdata.demo.algo.queue;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

/**
 * _239_MaxSlidingWindow
 * <pre>
 * 给你一个整数数组 nums，有一个大小为 k 的滑动窗口从数组的最左侧移动到数组的最右侧。你只可以看到在滑动窗口内的 k 个数字。滑动窗口每次只向右移动一位。
 *
 * 返回 滑动窗口中的最大值 。
 *
 * 示例 1：
 *
 * 输入：nums = [1,3,-1,-3,5,3,6,7], k = 3
 * 输出：[3,3,5,5,6,7]
 * 解释：
 * 滑动窗口的位置                最大值
 * ---------------               -----
 * [1  3  -1] -3  5  3  6  7       3
 *  1 [3  -1  -3] 5  3  6  7       3
 *  1  3 [-1  -3  5] 3  6  7       5
 *  1  3  -1 [-3  5  3] 6  7       5
 *  1  3  -1  -3 [5  3  6] 7       6
 *  1  3  -1  -3  5 [3  6  7]      7
 * 示例 2：
 *
 * 输入：nums = [1], k = 1
 * 输出：[1]
 * 提示：
 *
 * 1 <= nums.length <= 105
 * -104 <= nums[i] <= 104
 * 1 <= k <= nums.length
 * </pre>
 *
 * @author liujin
 * @date 2023/10/17
 */
public class _239_MaxSlidingWindow {
    public static void main(String[] args) {
        _239_MaxSlidingWindow maxSlidingWindow = new _239_MaxSlidingWindow();
        System.out.println(Arrays.toString(maxSlidingWindow.maxSlidingWindow(new int[]{1, 3, -1, -3, 5, 3, 6, 7}, 3)));
        System.out.println(Arrays.toString(maxSlidingWindow.maxSlidingWindow(new int[]{1}, 1)));
    }

    public int[] maxSlidingWindow(int[] nums, int k) {
        int[] res = new int[nums.length - k + 1];
        MonotoneQueue window = new MonotoneQueue();
        for (int i = 0; i < nums.length; i++) {
            if (i < k - 1) {
                window.push(nums[i]);
            } else {
                window.push(nums[i]);
                int max = window.max();
                res[i - k + 1] = max;
                window.pop(nums[i - k + 1]);
            }
        }
        return res;
    }

    public static class MonotoneQueue {
        private final Deque<Integer> list = new LinkedList<>();

        public void push(int n) {
            System.out.println("current list : " + list);

            while (!list.isEmpty() && list.getLast() < n) {
                list.removeLast();
            }
            System.out.println("after remove list : " + list);

            System.out.println("add : " + n);
            list.addLast(n);
        }

        public int max() {
            return list.getFirst();
        }


        /**
         * 移除队头元素
         *
         * @param n
         * @return
         */
        public void pop(int n) {
            System.out.println("check pop : " + n);
            if (list.getFirst() == n) {
                list.removeFirst();
                System.out.println("pop : " + n);
            }
        }
    }
}

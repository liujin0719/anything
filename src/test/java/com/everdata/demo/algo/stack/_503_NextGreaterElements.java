package com.everdata.demo.algo.stack;

import java.util.Arrays;
import java.util.Stack;

/**
 * _503_NextGreaterElements
 * <pre>
 * 给定一个循环数组 nums （ nums[nums.length - 1] 的下一个元素是 nums[0] ），返回 nums 中每个元素的 下一个更大元素 。
 *
 * 数字 x 的 下一个更大的元素 是按数组遍历顺序，这个数字之后的第一个比它更大的数，这意味着你应该循环地搜索它的下一个更大的数。如果不存在，则输出 -1 。
 *
 * 示例 1:
 *
 * 输入: nums = [1,2,1]
 * 输出: [2,-1,2]
 * 解释: 第一个 1 的下一个更大的数是 2；
 * 数字 2 找不到下一个更大的数；
 * 第二个 1 的下一个最大的数需要循环搜索，结果也是 2。
 * 示例 2:
 *
 * 输入: nums = [1,2,3,4,3]
 * 输出: [2,3,4,-1,4]
 * 提示:
 *
 * 1 <= nums.length <= 104
 * -109 <= nums[i] <= 109
 * </pre>
 *
 * @author liujin
 * @date 2023/10/17
 */
public class _503_NextGreaterElements {
    public static void main(String[] args) {

        _503_NextGreaterElements nextGreaterElements = new _503_NextGreaterElements();
        System.out.println(Arrays.toString(nextGreaterElements.nextGreaterElements(new int[]{1, 2, 1})));
        System.out.println(Arrays.toString(nextGreaterElements.nextGreaterElements(new int[]{1, 2, 3, 4, 3})));
        System.out.println(Arrays.toString(nextGreaterElements.nextGreaterElements2(new int[]{1, 2, 1})));
        System.out.println(Arrays.toString(nextGreaterElements.nextGreaterElements2(new int[]{1, 2, 3, 4, 3})));

    }

    public int[] nextGreaterElements(int[] nums) {

        int length = nums.length;
        int[] res = new int[length];

        Stack<Integer> stack = new Stack<>();

        for (int i = 2 * length - 1; i >= 0; i--) {

            while (!stack.isEmpty() && stack.peek() <= nums[i % length]) {
                stack.pop();
            }
            res[i % length] = stack.isEmpty() ? -1 : stack.peek();
            stack.push(nums[i % length]);
        }
        return res;
    }

    public int[] nextGreaterElements2(int[] nums) {

        int length = nums.length;
        int[] res = new int[length];

        Arrays.fill(res, -1);

        //存储下标
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < 2 * length; i++) {
            int index = i % length;
            while (!stack.isEmpty() && nums[stack.peek()] < nums[index]) {
                res[stack.pop()] = nums[index];
            }
            stack.push(index);
        }
        return res;
    }
}

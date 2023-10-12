package com.everdata.demo.algo.array;

import java.util.Arrays;

/**
 * <pre>
 * 给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
 *
 * 请注意 ，必须在不复制数组的情况下原地对数组进行操作。
 *
 * 示例 1:
 *
 * 输入: nums = [0,1,0,3,12]
 * 输出: [1,3,12,0,0]
 *
 * 示例 2:
 *
 * 输入: nums = [0]
 * 输出: [0]
 * 提示:
 *
 * 1 <= nums.length <= 104
 * -231 <= nums[i] <= 231 - 1
 * 进阶：你能尽量减少完成的操作次数吗？
 * </pre>>
 *
 * @author liujin
 * @date 2023/10/9
 */
public class _283_MoveZeroes {
    public static void main(String[] args) {
        _283_MoveZeroes moveZeroes = new _283_MoveZeroes();

        int[] nums1 = new int[]{0, 1, 0, 3, 12};
        int[] nums2 = new int[]{0};

        moveZeroes.moveZeroes(nums1);
        moveZeroes.moveZeroes(nums2);

        System.out.println(Arrays.toString(nums1));
        System.out.println(Arrays.toString(nums2));
    }

    public void moveZeroes(int[] nums) {

        if (nums == null || nums.length == 0) {
            return;
        }
        int slow = 0;
        int fast = 0;
        while (fast < nums.length) {
            if (nums[fast] != 0) {
                nums[slow] = nums[fast];
                slow++;
            }
            fast++;
        }
        for (slow = slow + 1; slow < nums.length; slow++) {
            nums[slow] = 0;
        }
    }
}

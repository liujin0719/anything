package com.everdata.demo.algo.binarySearch;

import java.util.Arrays;

/**
 * 在排序数组中查找元素的第一个和最后一个位置
 * <pre>
 * 给你一个按照非递减顺序排列的整数数组 nums，和一个目标值 target。请你找出给定目标值在数组中的开始位置和结束位置。
 *
 * 如果数组中不存在目标值 target，返回 [-1, -1]。
 *
 * 你必须设计并实现时间复杂度为 O(log n) 的算法解决此问题。
 *
 * 示例 1：
 *
 * 输入：nums = [5,7,7,8,8,10], target = 8
 * 输出：[3,4]
 * 示例 2：
 *
 * 输入：nums = [5,7,7,8,8,10], target = 6
 * 输出：[-1,-1]
 * 示例 3：
 *
 * 输入：nums = [], target = 0
 * 输出：[-1,-1]
 *
 * 提示：
 * 0 <= nums.length <= 105
 * -109 <= nums[i] <= 109
 * nums 是一个非递减数组
 * -109 <= target <= 109
 * </pre>
 *
 * @author liujin
 * @date 2023/10/8
 */
public class _34_SearchRange {
    public static void main(String[] args) {
        int[] nums1 = {5, 7, 7, 8, 8, 10};
        int[] nums2 = {};
        System.out.println(Arrays.toString(searchRange(nums1, 8)));
        System.out.println(Arrays.toString(searchRange(nums1, 6)));
        System.out.println(Arrays.toString(searchRange(nums2, 0)));
    }

    public static int[] searchRange(int[] nums, int target) {
        int[] ret = new int[2];
        if (nums == null || nums.length == 0) {
            ret[0] = -1;
            ret[1] = -1;
            return ret;
        }

        int leftIndex = findLeftIndex(nums, target);
        int rightIndex = findRightIndex(nums, target);

        ret[0] = leftIndex;
        ret[1] = rightIndex;
        return ret;
    }

    private static int findRightIndex(int[] nums, int target) {
        int start = 0;
        int end = nums.length - 1;
        int mid;
        while (start <= end) {
            mid = start + (end - start) / 2;
            if (nums[mid] < target) {
                start = mid + 1;
            } else if (nums[mid] == target) {
                if (mid < end && nums[mid + 1] == target) {
                    start = mid + 1;
                } else {
                    return mid;
                }
            } else {
                end = mid - 1;
            }
        }
        return -1;
    }

    private static int findLeftIndex(int[] nums, int target) {
        int start = 0;
        int end = nums.length - 1;
        int mid;
        while (start <= end) {
            mid = start + (end - start) / 2;
            if (nums[mid] < target) {
                start = mid + 1;
            } else if (nums[mid] == target) {
                if (mid > 0 && nums[mid - 1] == target) {
                    end = mid - 1;
                } else {
                    return mid;
                }
            } else {
                end = mid - 1;
            }
        }
        return -1;
    }
}

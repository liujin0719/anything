package com.everdata.demo.algo.binarySearch;

/**
 * LeftBoundaryBinarySearch
 * 二分查找数组中指定数值对应的下标，如果数值重复，获取左侧第一个的下标
 *
 * @author liujin
 * @date 2023/9/27
 */
public class LeftBoundaryBinarySearch {
    public static void main(String[] args) {
        int[] nums1 = {-1, 0, 3, 9, 9, 9, 12};
        int[] nums2 = {-1, 0, 3, 5, 9, 12};

        System.out.println(search(nums1, 9));
        System.out.println(search(nums1, 3));
        System.out.println(search(nums2, 2));
    }

    public static int search(int[] nums, int target) {
        if (nums == null) {
            return 0;
        }

        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] > target) {
                right = mid - 1;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                if (mid > 0 && nums[mid - 1] == target) {
                    right = mid - 1;
                } else {
                    return mid;
                }
            }

        }
        return -1;
    }
}

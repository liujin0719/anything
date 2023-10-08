package com.everdata.demo.algo.binarySearch;

/**
 * FirstGreaterBinarySearch
 * 查找第一个大于等于给定值的元素
 *
 * @author liujin
 * @date 2023/9/27
 */
public class FirstGreaterOrEqualBinarySearch {

    public static void main(String[] args) {
        int[] nums1 = {-1, 0, 3, 9, 9, 9, 12};
        System.out.println(search(nums1, 9));
        System.out.println(search(nums1, -1));
        System.out.println(search(nums1, -2));
        System.out.println(search(nums1, 20));
        System.out.println(search(nums1, 12));
        System.out.println(search(nums1, 2));
    }

    public static int search(int[] nums, int target) {

        if (nums == null) {
            return -1;
        }

        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {

            int mid = left + (right - left) / 2;
            if (nums[mid] >= target) {
                if (mid == 0 || nums[mid - 1] < target) {
                    return mid;
                } else {
                    right = mid - 1;
                }
            } else {
                left = mid + 1;
            }
        }

        return -1;
    }
}

package com.everdata.demo.algo.binarySearch;

/**
 * _704_Search
 * 给定一个 n 个元素有序的（升序）整型数组 nums 和一个目标值 target ，写一个函数搜索 nums 中的 target，如果目标值存在返回下标，否则返回 -1。
 *
 * @author liujin
 * @date 2023/9/27
 */
public class _704_Search {

    public static void main(String[] args) {
        _704_Search search = new _704_Search();
        int[] nums1 = {-1, 0, 3, 5, 9, 12};
        int[] nums2 = {-1, 0, 3, 5, 9, 12};
        assert search.search(nums1, 9) == 4;
        assert search.search(nums2, 2) == -1;
        System.out.println(search.search(nums1, 9));
        System.out.println(search.search(nums2, 2));
    }

    public int search(int[] nums, int target) {
        if (nums == null || nums.length == 1) {
            return -1;
        }

        int left = 0;
        int right = nums.length;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] > target) {
                right = mid - 1;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                return mid;
            }
        }
        return -1;
    }
}

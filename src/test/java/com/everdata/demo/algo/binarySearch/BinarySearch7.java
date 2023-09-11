/**
 * Copyright ©2021-2025 Eversec Corporation, All Rights Reserved
 * http://eversec.com.cn/
 */

package com.everdata.demo.algo.binarySearch;

/**
 * BinarySearch7
 *
 * @author liujin
 * @date 2022/3/2 17:36
 */
public class BinarySearch7 {
	public static void main(String[] args) {
		int[] arr = { 1, 5, 7, 11, 22 };

		int ret = bSearch7(arr, arr.length, 6);
		System.out.println(ret);
	}

	private static int bSearch7(int[] arr, int length, int value) {

		int low = 0;
		int high = length - 1;

		while (low <= high) {
			int mid = low + (high - low) / 2;
			if (arr[mid] <= value) {
				if (mid == length - 1 || arr[mid + 1] > value) {
					return mid;
				} else {
					low = mid + 1;
				}
			} else {
				high = mid - 1;
			}
		}

		return -1;
	}
}
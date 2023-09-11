/**
 * Copyright ©2021-2025 Eversec Corporation, All Rights Reserved
 * http://eversec.com.cn/
 */

package com.everdata.demo.algo.sort;

/**
 * QuickSort
 *
 * @author liujin
 * @date 2022/3/2 17:11
 */
public class QuickSort {
	public static void main(String[] args) {
		int[] arr = { 5, 2, 6, 8, 1, 3 };
		quickSort(arr, 0, arr.length - 1);
		for (int i : arr) {
			System.out.print(i);
		}
	}

	private static void quickSort(int[] arr, int start, int end) {
		if (arr == null || arr.length == 1 || start >= end) {
			return;
		}
		int midIndex = partition(arr, start, end);
		quickSort(arr, start, midIndex - 1);
		quickSort(arr, midIndex + 1, end);
	}

	private static int partition(int[] arr, int start, int end) {
		int value = arr[end];
		int i = start;
		for (int j = start; j < end; j++) {
			if (arr[j] <= value) {
				if (i == j) {
					i++;
				} else {
					int temp = arr[i];
					arr[i++] = arr[j];
					arr[j] = temp;
				}
			}
		}
		arr[end] = arr[i];
		arr[i] = value;
		return i;
	}
}
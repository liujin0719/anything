/**
 * Copyright ©2021-2025 Eversec Corporation, All Rights Reserved
 * http://eversec.com.cn/
 */

package com.everdata.demo.algo.sort;

/**
 * MergeSort
 *
 * @author liujin
 * @date 2022/3/2 16:40
 */
public class MergeSort {
	public static void main(String[] args) {

		int[] arr = { 5, 2, 6, 8, 1, 3 };
		mergeSort(arr, 0, arr.length - 1);
		for (int i : arr) {
			System.out.print(i);
		}
	}

	public static void mergeSort(int[] arr, int start, int end) {
		if (arr==null || start >= end) {
			return;
		}
		int mid = start + (end - start) / 2;
		System.out.println("start:"+start+"---"+"mid:"+mid+"---"+"end:"+end);
		mergeSort(arr, start, mid);
		mergeSort(arr, mid + 1, end);
		merge(arr, start, mid, end);
	}

	private static void merge(int[] arr, int start, int mid, int end) {
		int[] tmp = new int[end - start + 1];
		int i = start;
		int j = mid + 1;
		int k = 0;
		while (i <= mid && j <= end && k<=end) {
			if (arr[i] <= arr[j]) {
				tmp[k++] = arr[i++];
			} else {
				tmp[k++] = arr[j++];
			}
		}
		int s = i;
		int e = mid;
		if (j <= end) {
			s = j;
			e = end;
		}
		while (s <= e) {
			tmp[k++] = arr[s++];
		}
		for (int i1 = 0; i1 < tmp.length; i1++) {
			arr[start+i1] = tmp[i1];
		}
	}


}
/**
 * Copyright ©2021-2025 Eversec Corporation, All Rights Reserved
 * http://eversec.com.cn/
 */

package com.everdata.demo.algo;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeSet;

/**
 * MergeSortDemo
 * N个有序无重复数据数组合并为一个有序去重数组
 * @author liujin
 * @date 2022/2/21 下午5:19
 */
public class MergeSortArrayDemo {
	public static void main(String[] args) {
		ArrayList<int[]> list = new ArrayList<>();
		list.add(new int[] { 1, 2, 3 });
		list.add(new int[] { 3, 4, 5, 6 });
		list.add(new int[] { 3, 4, 5, 7,8 });
		list.add(new int[] { 3, 4, 5, 7,8,12 });

		int[] result = mergeSortArrays(list, 0, list.size()-1);
		for (int i : result) {
			System.out.println(i);
		}
	}

	private static int[] mergeSortArrays(ArrayList<int[]> list, int l, int r) {

		if (l >= r) {
			return list.get(l);
		}
		int mid = l + (r - l) / 2;
		int[] left = mergeSortArrays(list, l, mid);
		int[] right = mergeSortArrays(list, mid+1, r);
		return merge(left, right);
	}

	private static int[] merge(int[] arr1, int[] arr2) {

		int[] tmp = new int[arr1.length + arr2.length];
		int count = 0;

		int i = 0;
		int j = 0;

		while (i < arr1.length && j < arr2.length && count < tmp.length) {
			int v1 = arr1[i];
			int v2 = arr2[j];

			if (v1 > v2) {
				tmp[count++] = v2;
				j++;
			} else if (v1 < v2) {
				tmp[count++] = v1;
				i++;
			} else {
				tmp[count++] = v1;
				i++;
				j++;
			}
		}

		while (i < arr1.length) {
			tmp[count++] = arr1[i++];
		}

		while (j < arr2.length) {
			tmp[count++] = arr2[j++];
		}

		int[] ret = new int[count];

		System.arraycopy(tmp, 0, ret, 0, count);
		return ret;
	}

}
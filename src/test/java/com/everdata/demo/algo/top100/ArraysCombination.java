/**
 * Copyright ©2021-2025 Eversec Corporation, All Rights Reserved
 * http://eversec.com.cn/
 */

package com.everdata.demo.algo.top100;

import java.util.ArrayList;
import java.util.List;

/**
 * ArraysCombinationDemo
 * 字符串全组合
 * @author liujin
 * @date 2022/3/3 20:31
 */
public class ArraysCombination {
	public static void main(String[] args) {
		char[] chars = { 'a', 'b', 'c', 'd', 'e', 'f' };

		List<char[]> ret = allArray(chars);
		for (char[] charArray : ret) {
			System.out.println(charArray);
		}

	}

	public static List<char[]> allArray(char[] arr) {
		List<char[]> list = new ArrayList<>();
		if (arr.length <= 1) {
			list.add(arr);
			return list;
		}

		for (int i = 0; i < arr.length; i++) {
			for (int j = i; j < arr.length; j++) {
				char[] chars = new char[j - i + 1];
//				System.out.println(chars.length);
				for (int k = 0; k < chars.length; k++) {
//					System.out.println("i:"+i+"j:"+j+"k:"+k);
					chars[k] = arr[i + k];
				}
				list.add(chars);
			}
		}
		return list;
	}
}
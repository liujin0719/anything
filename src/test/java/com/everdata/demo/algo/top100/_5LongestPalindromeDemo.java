/**
 * Copyright ©2021-2025 Eversec Corporation, All Rights Reserved
 * http://eversec.com.cn/
 */

package com.everdata.demo.algo.top100;

/**
 * LongestPalindromeDemo
 *
 * @author liujin
 * @date 2022/2/24 16:41
 */
public class _5LongestPalindromeDemo {
	public static void main(String[] args) {
		String str = "babad";
//		System.out.println(longestPalindrome(str));
		System.out.println(longestPalindrome2(str));

	}

	public static String longestPalindrome(String s) {
		int length = s.length();
		if (s.length() < 2) {
			return s;
		}

		//二维数组描述起始位置到结束位置是否是回文数
		final boolean[][] isPalindrome = new boolean[length][length];

		//长度为1的都是回文数，即起始位置与结束位置相等的都是回文数
		for (int i = 0; i < length; i++) {
			isPalindrome[i][i] = true;
		}

		int maxLen = 1;
		int begin = 0;
		final char[] chars = s.toCharArray();
		//从长度
		for (int len = 2; len <= length; len++) {
			for (int i = 0; i < length; i++) {
				//j-i+1=len
				int j = i + len - 1;
				if (j >= length) {
					break;
				}
				if (chars[i] == chars[j]) {
					if (j - i < 3) {
						isPalindrome[i][j] = true;
					} else {
						isPalindrome[i][j] = isPalindrome[i + 1][j - 1];
					}
				} else {
					isPalindrome[i][j] = false;
				}
				if (isPalindrome[i][j] && j - i + 1 > maxLen) {
					maxLen = j - i + 1;
					begin = i;
				}
			}
		}
		return s.substring(begin, begin + maxLen);
	}


	public static String longestPalindrome2(String s) {
		String res = "";
		for (int i = 0; i < s.length(); i++) {
			String res1 = palindrome(s, i, i);
			String res2 = palindrome(s, i, i + 1);
			res = res1.length() > res.length() ? res1 : res;
			res = res2.length() > res.length() ? res2 : res;
		}

		return res;
	}


	private static String palindrome(String s, int l, int r) {
		while (l >= 0 && r <= s.length()-1 && s.charAt(l) == s.charAt(r)) {
			l--;
			r++;
		}
		return s.substring(l+1, r);
	}
}
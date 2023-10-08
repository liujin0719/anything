package com.everdata.demo.algo.slice_window;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * <pre>
 * 给定一个字符串 s ，请你找出其中不含有重复字符的 最长子串 的长度。
 *
 * 示例 1:
 *
 * 输入: s = "abcabcbb"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 * 示例 2:
 *
 * 输入: s = "bbbbb"
 * 输出: 1
 * 解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
 * 示例 3:
 *
 * 输入: s = "pwwkew"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
 *      请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
 * </pre>
 * @author liujin
 * @date 2023/9/26
 */
public class _3_LengthOfLongestSubstring {
    public static void main(String[] args) {
        String s = "abcabcbb";
        System.out.println(lengthOfLongestSubstring(s));
    }

    public static int lengthOfLongestSubstring(String s) {

        int res = 0;
        int left = 0;
        int right = 0;
        Map<Character, Integer> window = new HashMap<>();

        while (right < s.length()) {
            char rc = s.charAt(right);
            right++;

            window.put(rc, window.getOrDefault(rc, 0) + 1);

            while (window.get(rc) > 1) {
                char lc = s.charAt(left);
                left++;
                window.put(lc, window.get(lc) - 1);
            }
            res = Math.max(res, right - left);
        }
        return res;
    }
}

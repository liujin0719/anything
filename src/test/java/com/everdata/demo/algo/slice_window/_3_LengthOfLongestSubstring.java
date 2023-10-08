package com.everdata.demo.algo.slice_window;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * _3_LengthOfLongestSubstring
 * 给定一个字符串 s ，请你找出其中不含有重复字符的 最长子串 的长度。
 *
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

package com.everdata.demo.algo.slice_window;

import java.util.*;

/**
 * _438_FindAnagrams
 * 给定两个字符串 s 和 p，找到 s 中所有 p 的 异位词 的子串，返回这些子串的起始索引。
 *
 * @author liujin
 * @date 2023/9/26
 */
public class _438_FindAnagrams {
    public static void main(String[] args) {
        System.out.println(findAnagrams("cbaebabacd", "abc"));
    }

    public static List<Integer> findAnagrams(String s, String p) {

        Map<Character, Integer> needs = new HashMap<>();
        Map<Character, Integer> window = new HashMap<>();

        int left = 0;
        int right = 0;
        int valid = 0;

        List<Integer> ret = new ArrayList<>();

        for (int i = 0; i < p.length(); i++) {
            char c = p.charAt(i);
            needs.put(c, needs.getOrDefault(c, 0) + 1);
        }

        while (right < s.length()) {
            char rc = s.charAt(right);
            right++;

            if (needs.containsKey(rc)) {
                window.put(rc, window.getOrDefault(rc, 0) + 1);
                if (window.get(rc).equals(needs.get(rc))) {
                    valid++;
                }
            }

            while (right - left >= p.length()) {
                if (valid == needs.size()) {
                    ret.add(left);
                }

                char lc = s.charAt(left);
                left++;
                if (needs.containsKey(lc)) {
                    if (window.get(lc).equals(needs.get(lc))) {
                        valid--;
                    }
                    window.put(lc, window.get(lc) - 1);
                }
            }
        }
        return ret;

    }

}

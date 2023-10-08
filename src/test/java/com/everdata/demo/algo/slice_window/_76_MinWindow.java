package com.everdata.demo.algo.slice_window;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * <pre>
 * 给你一个字符串 s 、一个字符串 t 。返回 s 中涵盖 t 所有字符的最小子串。如果 s 中不存在涵盖 t 所有字符的子串，则返回空字符串 "" 。
 *
 * 注意：
 *
 * 对于 t 中重复字符，我们寻找的子字符串中该字符数量必须不少于 t 中该字符数量。
 * 如果 s 中存在这样的子串，我们保证它是唯一的答案。
 * 示例 1：
 *
 * 输入：s = "ADOBECODEBANC", t = "ABC"
 * 输出："BANC"
 * 解释：最小覆盖子串 "BANC" 包含来自字符串 t 的 'A'、'B' 和 'C'。
 * 示例 2：
 *
 * 输入：s = "a", t = "a"
 * 输出："a"
 * 解释：整个字符串 s 是最小覆盖子串。
 * 示例 3:
 *
 * 输入: s = "a", t = "aa"
 * 输出: ""
 * 解释: t 中两个字符 'a' 均应包含在 s 的子串中，
 * 因此没有符合条件的子字符串，返回空字符串。
 * </pre>
 * @author liujin
 * @date 2023/9/26
 */
public class _76_MinWindow {
    public static void main(String[] args) {
        System.out.println(minWindow("ADOBECODEBANC", "ABC"));
    }

    public static String minWindow(String s, String t) {

        //初始化需要的字符字典
        HashMap<Character, Integer> needs = new HashMap<>();
        for (int i = 0; i < t.length(); i++) {
            Character c = t.charAt(i);
            needs.put(c, needs.getOrDefault(c, 0) + 1);
        }

        for (Map.Entry<Character, Integer> entry : needs.entrySet()) {
            System.out.println(entry.getKey() + "---" + entry.getValue());
        }

        HashMap<Character, Integer> window = new HashMap<>();
        int left = 0;
        int right = 0;
        int start = 0;
        int len = Integer.MAX_VALUE;

        int valid = 0;
        while (right < s.length()) {
            char c = s.charAt(right);
            if (needs.containsKey(c)) {
                window.put(c, window.getOrDefault(c, 0) + 1);
                if (window.get(c).equals(needs.get(c))) {
                    valid++;
                }
            }
//            右滑
            right++;

            System.out.println("window:" + left + " right:" + right);
//            当所有元素都被包含后，开始左滑找最小子串
            while (valid == needs.size()) {

                if (right - left < len) {
                    start = left;
                    len = right - left;
                }
                char lc = s.charAt(left);
                if (needs.containsKey(lc)) {
                    if (window.get(lc).equals(needs.get(lc))) {
                        valid--;
                    }
                    window.put(lc, window.getOrDefault(lc, 0) - 1);
                }
                left++;
            }
        }

        System.out.println("start:" + start + " len:" + len);
        return len == Integer.MAX_VALUE ? "" : s.substring(start, start + len);
    }
}

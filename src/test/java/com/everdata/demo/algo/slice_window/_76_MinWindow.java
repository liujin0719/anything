package com.everdata.demo.algo.slice_window;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * _76_MinWindow
 *
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

package com.everdata.demo.algo.slice_window;

import java.util.HashMap;

/**
 * <pre>
 * 给你两个字符串 s1 和 s2 ，写一个函数来判断 s2 是否包含 s1 的排列。如果是，返回 true ；否则，返回 false 。
 *
 * 换句话说，s1 的排列之一是 s2 的 子串 。
 *
 * 示例 1：
 *
 * 输入：s1 = "ab" s2 = "eidbaooo"
 * 输出：true
 * 解释：s2 包含 s1 的排列之一 ("ba").
 * 示例 2：
 *
 * 输入：s1= "ab" s2 = "eidboaoo"
 * 输出：false
 * </pre>
 *
 * @author liujin
 * @date 2023/9/26
 */
public class _567_CheckInclusion {

    public static void main(String[] args) {
        System.out.println(checkInclusion("ab", "eidbaooo"));
    }

    public static boolean checkInclusion(String s1, String s2) {
        HashMap<Character, Integer> needs = new HashMap<>();

        for (int i = 0; i < s1.length(); i++) {
            char c1 = s1.charAt(i);
            needs.put(c1, needs.getOrDefault(c1, 0) + 1);
        }

        int left = 0;
        int right = 0;
        int valid = 0;

        HashMap<Character, Integer> window = new HashMap<>();

        while (right < s2.length()) {
            char rc = s2.charAt(right);
            right++;
            if (needs.containsKey(rc)) {
                window.put(rc, window.getOrDefault(rc, 0) + 1);
                if (window.get(rc).equals(needs.get(rc))) {
                    valid++;
                }
            } else {
                left = right;
                valid = 0;
                window.clear();
            }

            System.out.println("left:" + left + " right:" + right);
            while (right - left >= s1.length()) {
                if (valid == needs.size()) {
                    return true;
                }
                char lc = s2.charAt(left);
                left++;
                if (needs.containsKey(lc)) {
                    System.out.println("lc:" + lc + " size:" + window.get(lc));
                    System.out.println("lc:" + lc + " size:" + needs.get(lc));
                    if (window.getOrDefault(lc, 0).equals(needs.get(lc))) {
                        valid--;
                    }
                    window.put(lc, window.getOrDefault(lc, 0) - 1);

                }
            }
        }
        return false;

    }
}

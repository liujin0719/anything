package com.everdata.demo.algo.stack;

import java.util.Arrays;

/**
 * _316_RemoveDuplicateLetters
 * <pre>
 * 给你一个字符串 s ，请你去除字符串中重复的字母，使得每个字母只出现一次。需保证 返回结果的字典序最小（要求不能打乱其他字符的相对位置）。
 *
 * 示例 1：
 *
 * 输入：s = "bcabc"
 * 输出："abc"
 * 示例 2：
 *
 * 输入：s = "cbacdcbc"
 * 输出："acdb"
 * 提示：
 *
 * 输入：s = "edebbed"
 * 输出："bed"
 * 提示：
 *
 * 1 <= s.length <= 104
 * s 由小写英文字母组成
 * 注意：该题与 1081 https://leetcode-cn.com/problems/smallest-subsequence-of-distinct-characters 相同
 * </pre>
 *
 * @author liujin
 * @date 2023/10/18
 */
public class _316_RemoveDuplicateLetters {
    public static void main(String[] args) {
        _316_RemoveDuplicateLetters removeDuplicateLetters = new _316_RemoveDuplicateLetters();
        System.out.println(removeDuplicateLetters.removeDuplicateLetters("bcabc"));
        System.out.println(removeDuplicateLetters.removeDuplicateLetters("cbacdcbc"));
        System.out.println(removeDuplicateLetters.removeDuplicateLetters("edebbed"));
    }

    public String removeDuplicateLetters(String s) {

        boolean[] visit = new boolean[26];

        int[] nums = new int[26];

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            nums[ch - 'a'] += 1;
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            if (!visit[ch - 'a']) {
                while (sb.length() > 0 && sb.charAt(sb.length() - 1) > ch) {
                    if (nums[sb.charAt(sb.length() - 1) - 'a'] > 0) {
                        int last_index = sb.length() - 1;
                        visit[sb.charAt(last_index) - 'a'] = false;
                        sb.deleteCharAt(last_index);
                    } else {
                        break;
                    }
                }
                visit[ch - 'a'] = true;
                sb.append(ch);
            }
            nums[ch - 'a']--;
        }
        return sb.toString();
    }
}

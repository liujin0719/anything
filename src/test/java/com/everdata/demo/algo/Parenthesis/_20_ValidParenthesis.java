package com.everdata.demo.algo.Parenthesis;

import java.util.Stack;

/**
 * _20_ValidParenthesis
 * <pre>
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串 s ，判断字符串是否有效。
 *
 * 有效字符串需满足：
 *
 * 左括号必须用相同类型的右括号闭合。
 * 左括号必须以正确的顺序闭合。
 * 每个右括号都有一个对应的相同类型的左括号。
 * 示例 1：
 *
 * 输入：s = "()"
 * 输出：true
 * 示例 2：
 *
 * 输入：s = "()[]{}"
 * 输出：true
 * 示例 3：
 *
 * 输入：s = "(]"
 * 输出：false
 * 提示：
 *
 * 1 <= s.length <= 104
 * s 仅由括号 '()[]{}' 组成
 * </pre>
 *
 * @author liujin
 * @date 2023/10/12
 */
public class _20_ValidParenthesis {
    public static void main(String[] args) {
        _20_ValidParenthesis validParenthesis = new _20_ValidParenthesis();

        System.out.println(validParenthesis.isValid("()"));
        System.out.println(validParenthesis.isValid("()[]{}"));
        System.out.println(validParenthesis.isValid("(]"));

    }


    public boolean isValid(String s) {
        Stack<Character> left = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '[' || c == '{' || c == '(') {
                left.push(c);
            } else {
                if (!left.isEmpty() && leftOf(c) == left.peek()) {
                    left.pop();
                } else {
                    return false;
                }

            }
        }
        return left.isEmpty();
    }

    private Character leftOf(char c) {
        if (c == ']') {
            return '[';
        } else if (c == ')') {
            return '(';
        } else if (c == '}') {
            return '{';
        }
        return null;
    }
}

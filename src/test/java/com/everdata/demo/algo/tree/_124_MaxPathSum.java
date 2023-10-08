package com.everdata.demo.algo.tree;

import com.everdata.demo.domain.TreeNode;

/**
 * _124_MaxPathSum
 * <pre>
 * 二叉树中的 路径 被定义为一条节点序列，序列中每对相邻节点之间都存在一条边。同一个节点在一条路径序列中 至多出现一次 。该路径 至少包含一个节点，且不一定经过根节点。
 * 路径和 是路径中各节点值的总和。
 * 给你一个二叉树的根节点 root ，返回其 最大路径和 。
 * </pre>
 *
 * @author liujin
 * @date 2023/9/21
 */
public class _124_MaxPathSum {
    public static void main(String[] args) {

    }

    public static int res;

    public static int maxPathSum(TreeNode root) {
        res = Integer.MIN_VALUE;
        return oneSideMax(root);
    }

    public static int oneSideMax(TreeNode root) {
        if (root == null) return 0;

        int left = Math.max(0, oneSideMax(root.left));
        int right = Math.max(0, oneSideMax(root.right));
        // 后序位置
        res = Math.max(res, left + right + root.val);
        return Math.max(left, right) + root.val;
    }
}

package com.everdata.demo.algo.tree;

import com.everdata.demo.domain.TreeNode;

/**
 * _230_KthSmallest
 *
 * @author liujin
 * @date 2023/9/21
 */
public class _230_KthSmallest {

    public static int rank = 1;
    public static int res = 1;

    public static int kthSmallest(TreeNode root, int k) {
        rank = 1;
        findKthSmallest(root, k);
        return res;
    }

    private static void findKthSmallest(TreeNode root, int k) {

        if (root == null) {
            return;
        }

        findKthSmallest(root.left, k);
        if (rank++ == k){
            res = root.val;
            return;
        }
        findKthSmallest(root.right, k);
    }
}

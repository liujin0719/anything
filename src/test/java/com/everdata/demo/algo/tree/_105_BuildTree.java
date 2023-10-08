package com.everdata.demo.algo.tree;

import com.everdata.demo.domain.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * _105_Reduntion
 *
 * @author liujin
 * @date 2023/9/21
 */
public class _105_BuildTree {
    public static void main(String[] args) {

    }

    public static Map<Integer, Integer> valIndexMap = new HashMap<>();

    public static TreeNode buildTree(int[] preorder, int[] inorder) {
        for (int i = 0; i < inorder.length; i++) {
            valIndexMap.put(inorder[i], i);
        }

        return build(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1);
    }

    private static TreeNode build(int[] preorder, int preStart, int preEnd, int[] inorder, int inStart, int inEnd) {

        if (preStart > preEnd) {
            return null;
        }

        int rootVal = preorder[preStart];

        int rootIndex = valIndexMap.get(rootVal);

        int leftSize = rootIndex - inStart;

        TreeNode root = new TreeNode(rootVal);

        root.left = build(preorder, preStart + 1, preStart + leftSize, inorder, inStart, rootIndex - 1);

        root.right = build(preorder, preStart + leftSize + 1, preEnd, inorder, rootIndex + 1, inEnd);
        return root;
    }
}

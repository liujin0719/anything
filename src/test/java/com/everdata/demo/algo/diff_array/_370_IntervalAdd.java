package com.everdata.demo.algo.diff_array;

import java.util.Arrays;

/**
 * _350_IntervalAdd
 * <pre>
 * 假设你有一个长度为 n 的数组，初始情况下所有的数字均为 0，你将会被给出 k 个更新的操作。
 *
 * 其中，每个操作会被表示为一个三元组：[startIndex, endIndex, inc]，你需要将子数组 A[startIndex … endIndex]（包括 startIndex 和 endIndex）增加 inc。
 *
 * 请你返回 k 次操作后的数组。
 *
 * 示例:
 *
 * 输入: length = 5, updates = [[1,3,2],[2,4,3],[0,2,-2]]
 * 输出: [-2,0,3,5,3]
 *
 * 解释:
 *
 * 初始状态:
 * [0,0,0,0,0]
 * 进行了操作 [1,3,2] 后的状态:
 * [0,2,2,2,0]
 * 进行了操作 [2,4,3] 后的状态:
 * [0,2,5,5,3]
 * 进行了操作 [0,2,-2] 后的状态:
 * [-2,0,3,5,3]
 *
 * </pre>
 * @author liujin
 * @date 2023/9/25
 */
public class _370_IntervalAdd {
    public static void main(String[] args) {
        int[][] updates = new int[3][3];
        updates[0] = new int[]{1, 3, 2};
        updates[1] = new int[]{2, 4, 3};
        updates[2] = new int[]{0, 2, -2};
        System.out.println(Arrays.toString(getModifiedArray(5, updates)));
    }

    public static int[] getModifiedArray(int length, int[][] updates) {
        int[] diff = new int[length];

        for (int[] update : updates) {
            int start = update[0];
            int end = update[1];
            int val = update[2];
            diff[start] += val;
            if (end + 1 < diff.length) {
                diff[end + 1] -= val;
            }
        }

        int[] res = new int[length];
        res[0] = diff[0];

        for (int i = 1; i < res.length; i++) {
            res[i] = res[i - 1] + diff[i];
        }
        return res;
    }
}

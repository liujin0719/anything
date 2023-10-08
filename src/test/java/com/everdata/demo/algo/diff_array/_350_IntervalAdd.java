package com.everdata.demo.algo.diff_array;

import java.util.Arrays;

/**
 * _350_IntervalAdd
 *  区间相加
 * @author liujin
 * @date 2023/9/25
 */
public class _350_IntervalAdd {
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

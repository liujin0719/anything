package com.everdata.demo.algo.diff_array;

/**
 * _1094_a
 * <pre>
 * 车上最初有 capacity 个空座位。车 只能 向一个方向行驶（也就是说，不允许掉头或改变方向）
 *
 * 给定整数 capacity 和一个数组 trips , trip[i] = [numPassengersi, fromi, toi] 表示第 i 次旅行有 numPassengersi 乘客，接他们和放他们的位置分别是 fromi 和 toi 。这些位置是从汽车的初始位置向东的公里数。
 *
 * 当且仅当你可以在所有给定的行程中接送所有乘客时，返回 true，否则请返回 false。
 *
 * 示例 1：
 *
 * 输入：trips = [[2,1,5],[3,3,7]], capacity = 4
 * 输出：false
 * 示例 2：
 *
 * 输入：trips = [[2,1,5],[3,3,7]], capacity = 5
 * 输出：true
 * </pre>
 * @author liujin
 * @date 2023/10/8
 */
public class _1094_CarPooling {
    public static class Difference {
        private final int[] diff;

        public Difference(int[] nums) {

            diff = new int[nums.length];
            diff[0] = nums[0];

            for (int i = 1; i < nums.length; i++) {
                diff[i] = nums[i] - nums[i - 1];
            }
        }

        public void increment(int l, int r, int val) {
            diff[l] += val;
            if (r + 1 < diff.length) {
                diff[r + 1] -= val;
            }
        }

        public int[] getResult() {
            int[] res = new int[diff.length];

            res[0] = diff[0];

            for (int i = 1; i < diff.length; i++) {
                res[i] = res[i - 1] + diff[i];
            }

            return res;
        }
    }


    public boolean carPooling(int[][] trips, int capacity) {

        Difference difference = new Difference(new int[1001]);

        for (int i = 0; i < trips.length; i++) {
            difference.increment(trips[i][1], trips[i][2] - 1, trips[i][0]);
        }

        int[] result = difference.getResult();

        boolean flag = true;
        for (int i = 0; i < result.length; i++) {
            if (result[i] > capacity) {
                flag = false;
                break;
            }
        }
        return flag;
    }
}

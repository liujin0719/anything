package com.everdata.demo.algo.binarySearch;

/**
 * _875_MinEatingSpeed
 * <pre>
 * 珂珂喜欢吃香蕉。这里有 n 堆香蕉，第 i 堆中有 piles[i] 根香蕉。警卫已经离开了，将在 h 小时后回来。
 *
 * 珂珂可以决定她吃香蕉的速度 k （单位：根/小时）。每个小时，她将会选择一堆香蕉，从中吃掉 k 根。如果这堆香蕉少于 k 根，她将吃掉这堆的所有香蕉，然后这一小时内不会再吃更多的香蕉。
 *
 * 珂珂喜欢慢慢吃，但仍然想在警卫回来前吃掉所有的香蕉。
 *
 * 返回她可以在 h 小时内吃掉所有香蕉的最小速度 k（k 为整数）。
 *
 * 示例 1：
 *
 * 输入：piles = [3,6,7,11], h = 8
 * 输出：4
 * 示例 2：
 *
 * 输入：piles = [30,11,23,4,20], h = 5
 * 输出：30
 * 示例 3：
 *
 * 输入：piles = [30,11,23,4,20], h = 6
 * 输出：23
 * </pre>
 *
 * @author liujin
 * @date 2023/9/27
 */
public class _875_MinEatingSpeed {

    public int minEatingSpeed(int[] piles, int h) {

        int low = 1;
        int high = 0;
        for (int pile : piles) {
            high = Math.max(high, pile);
        }

        while (low <= high) {

            int speed = low + (high - low) / 2;
            int cost_hour = getTime(piles, speed);

            if (cost_hour > h) {
                low = speed + 1;
            } else if (cost_hour <= h) {
                if (speed == 1 || getTime(piles, speed - 1) > h) {
                    return speed;
                }
                high = speed - 1;
            }
        }
        return -1;
    }

    private static int getTime(int[] piles, int speed) {

        int res = 0;

        for (int pile : piles) {
            res += (pile + speed - 1) / speed;
        }

        return res;
    }
}

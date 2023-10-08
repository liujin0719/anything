package com.everdata.demo.algo.binarySearch;

/**
 * _1011_asd
 * <pre>
 * 传送带上的包裹必须在 days 天内从一个港口运送到另一个港口。
 *
 * 传送带上的第 i 个包裹的重量为 weights[i]。每一天，我们都会按给出重量（weights）的顺序往传送带上装载包裹。我们装载的重量不会超过船的最大运载重量。
 *
 * 返回能在 days 天内将传送带上的所有包裹送达的船的最低运载能力。
 *
 * 示例 1：
 *
 * 输入：weights = [1,2,3,4,5,6,7,8,9,10], days = 5
 * 输出：15
 * 解释：
 * 船舶最低载重 15 就能够在 5 天内送达所有包裹，如下所示：
 * 第 1 天：1, 2, 3, 4, 5
 * 第 2 天：6, 7
 * 第 3 天：8
 * 第 4 天：9
 * 第 5 天：10
 *
 * 请注意，货物必须按照给定的顺序装运，因此使用载重能力为 14 的船舶并将包装分成 (2, 3, 4, 5), (1, 6, 7), (8), (9), (10) 是不允许的。
 * 示例 2：
 *
 * 输入：weights = [3,2,2,4,1,4], days = 3
 * 输出：6
 * 解释：
 * 船舶最低载重 6 就能够在 3 天内送达所有包裹，如下所示：
 * 第 1 天：3, 2
 * 第 2 天：2, 4
 * 第 3 天：1, 4
 * 示例 3：
 *
 * 输入：weights = [1,2,3,1,1], days = 4
 * 输出：3
 * 解释：
 * 第 1 天：1
 * 第 2 天：2
 * 第 3 天：3
 * 第 4 天：1, 1
 * 提示：
 *
 * 1 <= days <= weights.length <= 5 * 104
 * 1 <= weights[i] <= 500
 * </pre>
 *
 * @author liujin
 * @date 2023/9/27
 */
public class _1011_ShipWithinDays {

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int days = 5;

        _1011_ShipWithinDays shipWithinDays = new _1011_ShipWithinDays();
        System.out.println(shipWithinDays.shipWithinDays(nums, days));
        System.out.println(shipWithinDays.getDays(nums, 10));
    }

    public int shipWithinDays(int[] weights, int days) {

        int low = 0;
        int high = 0;
        for (int weight : weights) {
            //最大容量是所有包裹的重量之和
            high += weight;
            //最小容量必须比单个包裹的重量大
            low = Math.max(low, weight);
        }

        System.out.println("low:" + low + " high:" + high);

        while (low < high) {
            int mid = low + (high - low) / 2;
            int cur_days = getDays(weights, mid);
            if (cur_days <= days) {
                if (mid == low || getDays(weights, mid - 1) > days) {
                    return mid;
                }
                high = mid;
            } else {
                low = mid + 1;
            }
        }

        return high;
    }

    private int getDays(int[] weights, int capacity) {
        int need_days = 0;

        int need_weight = 0;
        for (int weight : weights) {
            if (need_weight + weight <= capacity) {
                need_weight += weight;
            } else {
                need_days++;
                need_weight = weight;
            }
        }
        return need_days + 1;
    }
}

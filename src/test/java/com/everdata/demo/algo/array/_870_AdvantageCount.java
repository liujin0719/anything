package com.everdata.demo.algo.array;


import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * <pre>
 * 给定两个长度相等的数组 nums1 和 nums2，nums1 相对于 nums2 的优势可以用满足 nums1[i] > nums2[i] 的索引 i 的数目来描述。
 *
 * 返回 nums1 的任意排列，使其相对于 nums2 的优势最大化。
 *
 * 示例 1：
 *
 * 输入：nums1 = [2,7,11,15], nums2 = [1,10,4,11]
 * 输出：[2,11,7,15]
 * 示例 2：
 *
 * 输入：nums1 = [12,24,8,32], nums2 = [13,25,32,11]
 * 输出：[24,32,8,12]
 * 提示：
 *
 * 1 <= nums1.length <= 105
 * nums2.length == nums1.length
 * 0 <= nums1[i], nums2[i] <= 109
 * </pre>
 *
 * @author liujin
 * @date 2023/10/8
 */
public class _870_AdvantageCount {

    public static void main(String[] args) {
        int[] nums1 = new int[]{12, 24, 8, 32};
        int[] nums2 = new int[]{13, 25, 32, 11};
        _870_AdvantageCount advantageCount = new _870_AdvantageCount();
        System.out.println(Arrays.toString(advantageCount.advantageCount(nums1, nums2)));
    }

    public int[] advantageCount(int[] nums1, int[] nums2) {

        PriorityQueue<int[]> priorityQueue = new PriorityQueue<>((o1, o2) -> o2[1] - o1[1]);

        for (int i = 0; i < nums2.length; i++) {
            priorityQueue.add(new int[]{i, nums2[i]});
        }

        Arrays.sort(nums1);
        int left = 0;
        int right = nums1.length - 1;
        int[] ret = new int[nums1.length];
        while (!priorityQueue.isEmpty()) {
            int[] maxVal = priorityQueue.poll();
            if (nums1[right] > maxVal[1]) {
                ret[maxVal[0]] = nums1[right];
                right--;
            } else {
                ret[maxVal[0]] = nums1[left];
                left++;
            }
        }

        return ret;
    }

}

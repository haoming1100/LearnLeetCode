package com.hm.fourth;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * @author haoming
 *
 *
 * 给定两个大小为 m 和 n 的有序数组 nums1 和 nums2。
 *
 * 请你找出这两个有序数组的中位数，并且要求算法的时间复杂度为 O(log(m + n))。
 *
 * 你可以假设 nums1 和 nums2 不会同时为空。
 *
 * 示例 1:
 *
 * nums1 = [1, 3]
 * nums2 = [2]
 *
 * 则中位数是 2.0
 *
 * 示例 2:
 *
 * nums1 = [1, 2]
 * nums2 = [3, 4]
 *
 * 则中位数是 (2 + 3)/2 = 2.5
 */
public class FourthSolution {

    public static void main(String[] args) {
        int[] nums1 = {};
        int[] nums2 = {2,3};
        System.out.println(findMedianSortedArrays(nums1, nums2));
    }

    /**
     * 执行用时 : 97 ms, 在Median of Two Sorted Arrays的Java提交中击败了11.35% 的用户
     * 内存消耗 : 47.7 MB, 在Median of Two Sorted Arrays的Java提交中击败了51.07% 的用户
     * @param nums1
     * @param nums2
     * @return
     */
    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        List<Integer> intList1 = new ArrayList<>();
        for (int i : nums1) {
            intList1.add(i);
        }
        List<Integer> intList2 = new ArrayList<>();
        for (int i : nums2) {
            intList2.add(i);
        }
        intList1.addAll(intList2);
        intList1.sort(Comparator.comparingInt(o -> o));
        if (intList1.size() % 2 == 0) {
            int left = intList1.size() / 2 - 1;
            int right = left + 1;
            return (intList1.get(left) + intList1.get(right)) / 2.0;
        } else {
            return intList1.get(intList1.size() / 2);
        }
    }
}

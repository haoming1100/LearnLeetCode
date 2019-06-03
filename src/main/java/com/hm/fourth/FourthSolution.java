package com.hm.fourth;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * @author haoming
 * <p>
 * <p>
 * 给定两个大小为 m 和 n 的有序数组 nums1 和 nums2。
 * <p>
 * 请你找出这两个有序数组的中位数，并且要求算法的时间复杂度为 O(log(m + n))。
 * <p>
 * 你可以假设 nums1 和 nums2 不会同时为空。
 * <p>
 * 示例 1:
 * <p>
 * nums1 = [1, 3]
 * nums2 = [2]
 * <p>
 * 则中位数是 2.0
 * <p>
 * 示例 2:
 * <p>
 * nums1 = [1, 2]
 * nums2 = [3, 4]
 * <p>
 * 则中位数是 (2 + 3)/2 = 2.5
 */
public class FourthSolution {

    public static void main(String[] args) {
        int[] nums1 = {};
        int[] nums2 = {2, 3};
        System.out.println(findMedianSortedArrays1(nums1, nums2));
    }

    /**
     * 执行用时 : 97 ms, 在Median of Two Sorted Arrays的Java提交中击败了11.35% 的用户
     * 内存消耗 : 47.7 MB, 在Median of Two Sorted Arrays的Java提交中击败了51.07% 的用户
     *
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


    public static double findMedianSortedArrays1(int[] A, int[] B) {
        int m = A.length;
        int n = B.length;
        // to ensure m<=n
        if (m > n) {
            int[] temp = A;
            A = B;
            B = temp;
            int tmp = m;
            m = n;
            n = tmp;
        }
        int iMin = 0, iMax = m, halfLen = (m + n + 1) / 2;
        while (iMin <= iMax) {
            int i = (iMin + iMax) / 2;
            int j = halfLen - i;
            if (i < iMax && B[j - 1] > A[i]) {
                // i is too small
                iMin = i + 1;
            } else if (i > iMin && A[i - 1] > B[j]) {
                // i is too big
                iMax = i - 1;
            } else { // i is perfect
                int maxLeft = 0;
                if (i == 0) {
                    maxLeft = B[j - 1];
                } else if (j == 0) {
                    maxLeft = A[i - 1];
                } else {
                    maxLeft = Math.max(A[i - 1], B[j - 1]);
                }
                if ((m + n) % 2 == 1) {
                    return maxLeft;
                }

                int minRight = 0;
                if (i == m) {
                    minRight = B[j];
                } else if (j == n) {
                    minRight = A[i];
                } else {
                    minRight = Math.min(B[j], A[i]);
                }

                return (maxLeft + minRight) / 2.0;
            }
        }
        return 0.0;
    }
}

package com.hm.first;

import java.util.HashMap;
import java.util.Map;

/**
 * @author haoming
 * <p>
 * 两数之和
 * <p>
 * <p>
 * 给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
 * 你可以假设每种输入只会对应一个答案。但是，你不能重复利用这个数组中同样的元素。
 * 示例:
 * 给定 nums = [2, 7, 11, 15], target = 9
 * 因为 nums[0] + nums[1] = 2 + 7 = 9
 * 所以返回 [0, 1]
 */
public class SumOfTwoNumbers {

    public static void main(String[] args) {
        int[] nums = {3,2,4};
        int target = 6;
        int[] twoSum = twoSum3(nums, target);
        System.out.println(twoSum[0]);
        System.out.println(twoSum[1]);
    }

    /**
     * 求 两数之和
     *  解答思路：使用 2 层的 for 循环，进行相加，如果和等于 目标值，则直接返回
     *  使用正序循环
     *  计算结果：内存消耗: 40.7 MB, 在Two Sum的Java提交中击败了0.99% 的用户，执行用时：84 ms
     * @param nums
     * @param target
     * @return
     */
    private static int[] twoSum1(int[] nums, int target) {
        for (int x = 0; x < nums.length; x ++) {
            for (int y = 0; y < nums.length; y ++) {
                if (nums[x] + nums[y] == target && x != y) {
                    return new int[]{x,y};
                }
            }
        }
        return null;
    }

    /**
     * 求 两数之和
     * 解答思路：使用 2 层的 for 循环，进行相加，如果和等于 目标值，则直接返回
     * 与 twoSum1 不同的是 使用 倒序循环
     * 计算结果：执行用时 51 ms，内存消耗 40.4 MB
     * @param nums
     * @param target
     * @return
     */
    private static int[] twoSum2(int[] nums, int target) {
        for (int x = nums.length - 1; x >= 0 ; x --) {
            for (int y = nums.length - 1; y >= 0 ; y --) {
                if (nums[x] + nums[y] == target && x != y) {
                    return new int[]{x,y};
                }
            }
        }
        return null;
    }

    /**
     * 求 两数之和
     * 解答思路：使用 2 层的 for 循环，进行相加，如果和等于 目标值，则直接返回
     * 与 twoSum2 不同的是在使用倒序循环的基础上 少比较了一次父列
     * 计算结果：执行用时: 46 ms 内存消耗: 40.2 MB
     * @param nums
     * @param target
     * @return
     */
    private static int[] twoSum3(int[] nums, int target) {
        for (int x = nums.length - 1; x >= 0 ; x --) {
            for (int y = x - 1; y >= 0 ; y --) {
                if (nums[x] + nums[y] == target && x != y) {
                    return new int[]{x,y};
                }
            }
        }
        return null;
    }

    /**
     * twoSum4 是典型的 空间换时间的做法
     * 两遍哈希值的计算
     * 计算结果:执行用时: 13 ms 内存消耗: 41.9 MB
     * @param nums
     * @param target
     * @return
     */
    private static int[] twoSum4(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int x = 0 ; x < nums.length; x ++) {
            //空间换时间，由于hash 表查找某个下标总是 O(1)的
            // key 代表着 数值，value 代表着 下标
            map.put(nums[x], x);
        }
        //查找下标
        for (int y = 0; y < nums.length; y ++) {
            int difference = target - nums[y];
            //查看差值是否为 map 的key
            // 能重复利用这个数组中同样的元素 所以 y != map.get(difference)
            if (map.containsKey(difference) && y != map.get(difference)) {
                return new int[]{y, map.get(difference)};
            }
        }
        return null;
    }


    /**
     * 一遍哈希表
     * 计算结果：执行用时: 5 ms 内存消耗: 38.9 MB
     * @param nums
     * @param target
     * @return
     */
    private static int[] twoSum5(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        //查找下标
        for (int y = 0; y < nums.length; y ++) {
            int difference = target - nums[y];
            //查看差值是否为 map 的key
            // 能重复利用这个数组中同样的元素 所以 y != map.get(difference)
            if (map.containsKey(difference) && y != map.get(difference)) {
                return new int[]{y, map.get(difference)};
            } else {
                map.put(nums[y], y);
            }
        }
        return null;
    }

}

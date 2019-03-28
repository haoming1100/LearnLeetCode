package com.hm.third;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * 题目描述
 *
 * 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
 *
 * 示例 1:
 * 输入: "abcabcbb"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 *
 * 示例 2:
 * 输入: "bbbbb"
 * 输出: 1
 * 解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
 *
 * 示例 3:
 * 输入: "pwwkew"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
 *
 *请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
 *
 *
 */
public class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        String s = "aedfghedfgh";
        System.out.println(solution.lengthOfLongestSubstring1(s));
    }

    /**
     * 在解决该题的时候,因为题目是求出无重复的字符串长度,所以首先想到的就是使用唯一性的集合进行处理,那么我们就可以使用 map 或者是 set
     *
     * 注意,该算法的时间复杂度为 O(n3)
     * @param s
     * @return
     */
    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        //首先计算 字符串长度
        int stringLength = s.length();
        int ans = 0;
        for (int i = 0; i < stringLength; i++) {
            // 从 j = i + 1 开始是为了自己和自己本身比较的问题
            for (int j = i + 1; j <= stringLength; j++) {
                // 进行比较,每轮都是父级循环与每次子级循环进行比较
                if (allUnique(s, i, j)) {
                    //当有重复元素的时候,就用 max 函数比较 是否是最大值
                    //true 的条件是 已经有包含值
                    ans = Math.max(ans, j - i);
                }
            }
        }
        return ans;
    }

    /**
     * 比较是否有包含
     * @param s
     * @param start
     * @param end
     * @return
     */
    private boolean allUnique(String s, int start, int end) {
        Set<Character> set = new HashSet<>();
        for (int i = start; i < end; i++) {
            Character ch = s.charAt(i);
            if (set.contains(ch)) {
                return false;
            }
            set.add(ch);
        }
        return true;
    }

    /**
     * 滑动窗口  滑动窗口是数组/字符串问题中常用的抽象概念。
     * 窗口通常是在数组/字符串中由开始和结束索引定义的一系列元素的集合，即 [i, j)[i,j)（左闭，右开）。
     * 而滑动窗口是可以将两个边界向某一方向“滑动”的窗口。
     * 例如，我们将 [i, j)[i,j) 向右滑动 11 个元素，则它将变为 [i+1, j+1)[i+1,j+1)（左闭，右开）。
     * @param s
     * @return
     */
    private int lengthOfLongestSubstring1(String s) {
        int n = s.length();
        Set<Character> set = new HashSet<>();
        int ans = 0, i = 0, j = 0;
        while (i < n && j < n) {
            // 判断 Set 中是否包含 某字段
            if (!set.contains(s.charAt(j))){
                set.add(s.charAt(j++));
                ans = Math.max(ans, j - i);
            }
            else {
                set.remove(s.charAt(i++));
            }
        }
        return ans;
    }
}

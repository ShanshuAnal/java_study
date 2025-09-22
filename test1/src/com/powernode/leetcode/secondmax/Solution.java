package com.powernode.leetcode.secondmax;

/**
 * @Author: 19599
 * @Date: 2025/5/23 16:11
 * @Description: 找出数组中第二大的数据，没有的话返回最小值
 */
public class Solution {
    public static Integer secondMax(int[] nums) {
        if (nums == null || nums.length < 2) {
            return null;
        }
        Integer max = null, second = null;
        for (int num : nums) {
            if (max == null || num > max) {
                second = max;
                max = num;
            } else if (num != max && (second == null || num > second)) {
                second = num;
            }
        }

        return second;
    }

    public static void main(String[] args) {
        System.out.println(secondMax(new int[]{3, 2, 1}));       // 2
        System.out.println(secondMax(new int[]{1, 1, 1}));       // null
        System.out.println(secondMax(new int[]{1}));             // null
        System.out.println(secondMax(new int[]{5, 5, 2, 5}));     // 2
        System.out.println(secondMax(new int[]{Integer.MIN_VALUE, Integer.MAX_VALUE})); // Integer.MIN_VALUE

    }
}

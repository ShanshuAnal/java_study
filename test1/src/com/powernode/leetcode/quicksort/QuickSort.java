package com.powernode.leetcode.quicksort;

import java.util.Arrays;

/**
 * @Author: 19599
 * @Date: 2025/5/31 12:47
 * @Description:
 */
public class QuickSort {
    public static void main(String[] args) {
        int[] arr = {3, 6, 3, 1, 8, 1, 2, 5, 9, 4, 4, 6};
        new Sort().quickSort(arr);
        // 输出：[1, 2, 3, 5, 6, 8]
        System.out.println(Arrays.toString(arr));
    }
}

class Sort {
    public void quickSort(int[] nums) {
        quickSort(nums, 0, nums.length - 1);
    }

    private void quickSort(int[] nums, int left, int right) {
        if (left < right) {
            // 将这个pivot给他找到位置，[比pivot小的，pivot，比pivot大的]
            int pivotIndex = partition(nums, left, right);
            // 对左半部分排序
            quickSort(nums, left, pivotIndex - 1);
            // 对右半部分排序
            quickSort(nums, pivotIndex + 1, right);
        }
    }

    private int partition(int[] nums, int left, int right) {
        int pivot = nums[right];
        int i = left;
        for (int j = left; j < right; j++) {
            if (nums[j] < pivot) {
                swap(nums, i++, j);
            }
        }
        swap(nums, i, right);
        return i;
    }

    private void swap(int[] nums, int left, int right) {
        int t = nums[left];
        nums[left] = nums[right];
        nums[right] = t;
    }
}


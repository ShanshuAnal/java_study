package com.powernode.leetcode.quicksort;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @Author: 19599
 * @Date: 2025/5/31 12:38
 * @Description:
 * 至于为什么时间复杂度是O(n)
 * 这是：每次 partition 会把数组分成两部分；
 * 只会递归包含目标元素的那一边（不像 Quicksort 会递归两边）；
 * 这样在平均情况下递归层数是 log n，但由于只递归一边，总体比较次数是：
 * 1 + n/2 + n/4 + .... = 2 - 1/(2^n-1) ≈ 2
 */
public class FindKthWithQuickSort {
    public static void main(String[] args) {
        int[] arr = {3, 6, 3, 1, 8, 1, 2, 5, 9, 4, 4, 6};
        System.out.println("刚开始：" + Arrays.toString(arr));
        System.out.println(new QuickSortFindKth().findKth(arr, 5));
    }
}

class QuickSortFindKth {
    public int findKth(int[] nums, int k) {
        return findKth(nums, 0, nums.length - 1, k - 1);
    }


    private int findKth(int[] nums, int left, int right, int k) {
        while (left <= right) {
            int pivotIndex = partition(nums, left, right);

            if (pivotIndex == k) {
                return nums[pivotIndex];
            } else if (pivotIndex < k) {
                left = pivotIndex + 1;
            } else {
                right = pivotIndex - 1;
            }
            System.out.println("第一轮排序后：" + Arrays.toString(nums) + "，基准是：" + nums[pivotIndex]);
        }
        return -1;
    }

    /*
    * 这里是倒序排序，将比pivot大的部分放到左边
    *
    * 如果找第k小的，那就是nums[j] < pivot
    * */
    private int partition(int[] nums, int left, int right) {
        int pivot = nums[right];
        int i = left;
        for (int j = left; j < right; j++) {
            if (nums[j] > pivot) {
                swap(nums, i++, j);
            }
        }
        swap(nums, i, right);
        return i;
    }

    private void swap(int[] nums, int i, int j) {
        int t = nums[i];
        nums[i] = nums[j];
        nums[j] = t;
    }
}

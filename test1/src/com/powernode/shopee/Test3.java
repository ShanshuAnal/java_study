package com.powernode.shopee;

import java.util.*;

/**
 * @Author: 19599
 * @Date: 2025/9/28 1:54
 * @Description:
 */
public class Test3 {
    List<List<Integer>> res = new ArrayList<>();
    List<Integer> path = new LinkedList<>();

    public static void main(String[] args) {
        Test3 test3 = new Test3();
        int[] coupons = {10 ,20, 50};
        int[][] res = test3.FindCouponCombinations(coupons, 50);
        for (int[] re : res) {
            System.out.println(Arrays.toString(re));
        }
    }

    public int[][] FindCouponCombinations(int[] coupons, int target) {
        Arrays.sort(coupons);
        backtrack(coupons, 0, target);
        int[][] resArr = new int[res.size()][];
        for (int i = 0; i < res.size(); i++) {
            List<Integer> list = res.get(i);
            int[] nums = new int[list.size()];
            for (int j = 0; j < list.size(); j++) {
                nums[j] = list.get(j);
            }
            resArr[i] = nums;
        }
        return res.toArray(new int[0][]);
    }

    private void backtrack(int[] coupons, int sum, int target) {
        if (target < sum) {
            return;
        }
        if (target == sum) {
            if (path.size() <= coupons.length) {
                res.add(new ArrayList<>(path));
            }
            return;
        }
        for (int i = 0; i < coupons.length; i++) {
            path.add(coupons[i]);
            backtrack(coupons, sum + coupons[i], target);
            path.remove(path.size() - 1);
        }
    }
}

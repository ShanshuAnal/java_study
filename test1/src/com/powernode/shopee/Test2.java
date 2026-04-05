package com.powernode.shopee;

/**
 * @Author: 19599
 * @Date: 2025/9/28 2:43
 * @Description:
 */
public class Test2 {
    public static void main(String[] args) {
        Test2 test2 = new Test2();
        int[] nums = {4, 2, 3, 1};
        System.out.println(test2.Solve(4, 2, nums));
        int[] nums1 = {4, 1, 3, 2};
        System.out.println(test2.Solve(4, 2, nums1));
    }
    public long Solve(int n, int m, int[] weights) {
        long sum = 0L;
        for (int weight : weights) {
            sum += weight;
        }
        for (long cap = Math.max(weights[0], sum / m); cap <= sum; cap++) {
            int count = 0, sumNow = 0;
            for (int  i = 0; i < n; i++) {
                sumNow += weights[i];
                if (sumNow == cap) {
                    count++;
                    sumNow = 0;
                }
                if (sumNow > cap) {
                    i = i - 1;
                    count++;
                     sumNow = 0;
                }
            }
            if (sumNow != 0 && sumNow < cap) {
                count++;
            }
            if (count == m) {
                return cap;
            }
        }
        return 0L;
    }
}

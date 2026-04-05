package com.powernode.shopee;


import java.util.Arrays;

public class Test1 {
    public static void main(String[] args) {

    }

    public int run(int[] arr) {
        if (arr.length == 1) {
            return 1;
        }
        int sum = 0, n = arr.length;
        Arrays.sort(arr);
        for (int i : arr) {
            sum += i;
        }
        // 1 2 3 3 3 4 4 5 5
        for (int cap = arr[n - 1]; cap <= sum; cap++) {
            if (sum % cap != 0) {
                continue;
            }
            int m = sum / cap;
            int count = 0;
            boolean[] isVisited = new boolean[n];
            for (int j = n - 1; j > 0; j--) {

            }

        }
        return 0;
    }
}
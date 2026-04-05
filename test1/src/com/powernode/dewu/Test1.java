package com.powernode.dewu;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @Author: 19599
 * @Date: 2025/10/11 11:01
 * @Description:
 */
public class Test1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int n = sc.nextInt();
        int k = sc.nextInt();

        int sum = 0;
        int[][] martix = new int[m][n];

        for (int i = 0; i < m; i++) {
            String s = sc.next();
            char[] chars = s.toCharArray();
            for (int j = 0; j < chars.length; j++) {
                martix[i][j] = chars[j] - '0';
                sum += martix[i][j];
            }
        }

        int res = 0;
        for (int row = 0; row < (1 << m); row++) {
            for (int col = 0; col < (1 << n); col++) {
                int cnt = 0;
                for (int i = 0; i < m; i++) {
                    for (int j = 0; j < n; j++) {
                        if ((row & (1 << i)) == 0 &&
                            (col & (1 << j)) == 0 &&
                            martix[i][j] == 1) {
                            cnt++;
                        }
                    }
                }
                if (cnt == k) {
                    res++;
                }
            }
        }
        System.out.println(res);
    }
}

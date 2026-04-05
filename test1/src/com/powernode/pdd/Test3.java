package com.powernode.pdd;


import java.util.Scanner;

public class Test3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // 课程数
        int n = sc.nextInt();
        // 楼层数
        int m = sc.nextInt();
        // 初始法力值
        int M = sc.nextInt();

        // 每门课收益
        int[] power = new int[n];
        for (int i = 0; i < n; i++) {
            power[i] = sc.nextInt();
        }
        // 每门课消耗
        int[] mana = new int[n];
        for (int i = 0; i < n; i++) {
            mana[i] = sc.nextInt();
        }
        // 每层楼加成系数
        int[] bonus = new int[m];
        for (int i = 0; i < m; i++) {
            bonus[i] = sc.nextInt();
        }

        int[][] dp = new int[n][m];
        for (int j = 0; j < m; j++) {
            if (mana[0] * bonus[j] < M) {
                dp[0][j] = power[0] * bonus[j];
            }
        }

        for (int i = 0; i < n; i++) {

        }


    }
}

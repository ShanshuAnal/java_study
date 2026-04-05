package com.powernode.pdd;


import java.util.Arrays;
import java.util.Scanner;

public class Test4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] fish = new int[n];
        for (int i = 0; i < n; i++) {
            fish[i] = sc.nextInt();
        }

        int[] pre = new int[n];
        for (int i = 1; i < n; i++) {
            if (fish[i - 1] == pre[i - 1]) {
                pre[i] = fish[i - 1];
            } else {
                pre[i] += pre[i - 1] + fish[i - 1];
            }
        }
        System.out.println(Arrays.toString(pre));

        int[] post = new int[n];
        for (int i = n - 2; i >= 0; i--) {
            if (fish[i + 1] == post[i + 1]) {
                post[i] = fish[i + 1];
            } else {
                post[i] = fish[i + 1] + post[i + 1];
            }
        }
        System.out.println(Arrays.toString(post));

        int[] res = new int[n];
        Arrays.fill(res, Integer.MAX_VALUE);
        for (int i = 0; i < n; i++) {
            int preSum = pre[i];
            int j = 0;
            for (; j < i && preSum - fish[j] > fish[i]; j++) {
                preSum -= fish[j];
            }
            if (preSum > fish[i]) {
                res[i] = Math.min(res[i], i - j);
            }

            int postSum = post[i];
            j = n - 1;
            for (; j > i && postSum - fish[j] > fish[i]; j--) {
                postSum -= fish[j];
            }
            if (postSum > fish[i]) {
                res[i] = Math.min(res[i], j - i);
            }
        }
        for (int i = 0; i < n - 1; i++) {
            if (res[i] == Integer.MAX_VALUE) {
                System.out.print(-1 + " ");
            } else {
                System.out.print(res[i] + " ");
            }
        }
        System.out.print(res[n - 1] == Integer.MAX_VALUE ? -1 : res[n - 1]);
    }
}

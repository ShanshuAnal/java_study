package com.powernode.pdd;

import java.util.Scanner;

public class Test2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] initial = new int[n];
        for (int i = 0; i < n; i++) {
            initial[i] = sc.nextInt() - 1;
        }
        int[] target = new int[n];
        for (int i = 0; i < n; i++) {
            target[i] = sc.nextInt() - 1;
        }
        int res = traversal(initial, 0, target, 0, n);
        System.out.println(res);
    }

    private static int traversal(int[] initial, int i, int[] target, int pre, int len) {
        if (i >= len || initial[i] == -1) {
            return 0;
        }
        initial[i] = (initial[i] + pre) % 5;
        int num = target[i] - initial[i];
        if (num < 0) {
            num = (num + 5) % 5;
        }
        int leftNum = traversal(initial, i * 2 + 1, target, pre + num, len);
        int rightNum = traversal(initial, i * 2 + 2, target, pre + num, len);
        return num + leftNum + rightNum;
    }
}

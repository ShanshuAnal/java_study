package com.powernode.didi;

import java.util.*;

public class Test1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        int l = sc.nextInt();
        int r = sc.nextInt();
        int k = sc.nextInt();

        List<Integer> res = new ArrayList<>();

        for (int num = l; num <= r; num++) {
            int count = 0;
            for (int div = a; div <= b; div++) {
                if (isWaveNum(num, div)) {
                    count++;
                    if (count > k) {
                        break;
                    }
                }
            }
            if (count == k) {
                res.add(num);
            }
        }

        res.forEach(System.out::println);
    }

    private static boolean isWaveNum(int num, int div) {
        int n1 = num % div;
        num /= div;
        if (num == 0) {
            return true;
        }
        int n2 = num % div;
        num /= div;
        if (n1 == n2) {
            return false;
        }
        while (num != 0) {
            int n3 = num % div;
            if (n3 != n1) {
                return false;
            }
            num /= div;
            if (num == 0) {
                return true;
            }
            int n4 = num % div;
            if (n4 != n2) {
                return false;
            }
            num /= div;
        }
        return true;
    }
}

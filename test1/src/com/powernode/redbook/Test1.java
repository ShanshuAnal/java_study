package com.powernode.redbook;

import java.util.*;

public class Test1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        Set<Integer> set = new HashSet<>(Arrays.asList(2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89, 97));
        while (t-- > 0) {
            int n = sc.nextInt();
            if (n == 1) {
                System.out.println("NO");
                continue;
            }
            int sum = 0;
            for (int i : set) {
                if (n % i == 0) {
                    sum += i;
                }
            }
            if (sum % 2 == 0) {
                System.out.println("NO");
            } else {
                System.out.println("YES");
            }
        }

    }
}
